import com.example.data.model.UserToken
import com.example.data.repository.local.api.SharedPrefApi
import com.example.data.repository.local.api.helper.execute
import com.example.data.repository.local.api.pref.PREF_USER_DATA
import com.example.data.repository.local.api.pref.PREF_USER_TOKEN
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.api.helper.ApiConfig.AUTHORIZATION
import com.example.data.repository.remote.api.helper.ApiConfig.BEARER
import com.example.data.repository.remote.api.helper.execute
import com.example.data.repository.remote.api.request.TokenRequest
import com.example.data.repository.remote.error.ApiError
import com.example.data.repository.remote.error.ExpiredTokenException
import com.example.domain.error.ErrorEntity
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(
    private val noneApi: NoneAuthApi,
    private val sharedPrefApi: SharedPrefApi
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        if (responseCount(response) >= RETRY_COUNT_LIMIT) {
            doOnRefreshTokenFailed()
            return null
        }
        val oldUserToken =
            sharedPrefApi.execute {
                get(PREF_USER_TOKEN, UserToken::class.java)
            }

        synchronized(this) {
            // Prevent multiple unnecessary call refresh token
            val syncedUserToken = sharedPrefApi.execute {
                get(PREF_USER_TOKEN, UserToken::class.java)
            }

            if (
                oldUserToken?.refreshToken != null &&
                oldUserToken.accessToken != syncedUserToken?.accessToken
            ) {
                // if current refresh token is diff from saved, that mean another refresh has done.
                // we just use the new access token
                return if (syncedUserToken != null) {
                    response.request.newBuilder()
                        .header(
                            AUTHORIZATION,
                            "$BEARER ${syncedUserToken.accessToken}"
                        ).build()
                } else {
                    null
                }
            }

            return runBlocking {
                try {
                    val oldRefreshToken = oldUserToken?.refreshToken.orEmpty()
                    val newUserToken = noneApi.execute {
                        refreshToken(TokenRequest(oldRefreshToken))
                    }
                    sharedPrefApi.put(PREF_USER_TOKEN, newUserToken)
                    response.request.newBuilder()
                        .header(
                            AUTHORIZATION,
                            "$BEARER ${newUserToken.accessToken}"
                        ).build()
                } catch (exception: ErrorEntity) {
                    if (exception is ApiError.HttpError &&
                        (exception.errorResponse as? String) == ""
                    ) {
                        doOnRefreshTokenFailed()
                    }
                    null
                }
            }
        }
    }

    private fun responseCount(response: Response): Int {
        var responseMutable = response.priorResponse
        var count = 1
        while (responseMutable != null && count <= RETRY_COUNT_LIMIT) {
            count++
            responseMutable = response.priorResponse
        }
        return count
    }

    private fun doOnRefreshTokenFailed() {
        sharedPrefApi.removeKey(PREF_USER_TOKEN)
        sharedPrefApi.removeKey(PREF_USER_DATA)
        throw ExpiredTokenException()
    }

    companion object {
        private const val RETRY_COUNT_LIMIT = 3
    }
}
