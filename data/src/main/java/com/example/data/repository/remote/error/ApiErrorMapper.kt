package com.example.data.repository.remote.error

import ErrorDeserializer
import com.example.data.repository.remote.api.response.ErrorResponse
import com.example.domain.error.ErrorEntity
import com.example.domain.error.ErrorMapper
import com.google.gson.GsonBuilder
import java.io.IOException
import retrofit2.HttpException

@Suppress("ReturnCount")
object ApiErrorMapper : ErrorMapper {
    private const val SERVER_ERROR_CODE = 500
    override fun map(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is HttpException -> errorEntityFromHttpException(throwable)
            is ExpiredTokenException -> ApiError.ExpiredTokenError(throwable)
            is IOException -> ApiError.NetworkError(throwable)
            else -> ApiError.UnexpectedError(throwable)
        }
    }

    private fun errorEntityFromHttpException(throwable: HttpException): ErrorEntity {
        val errorBody = throwable.response()?.errorBody()
        if (errorBody != null) {
            val errorResponse =
                deserializeServerError(errorBody.string())
                    ?: return ApiError.UnexpectedError(throwable)
            return if (throwable.code() > SERVER_ERROR_CODE) {
                ApiError.ServerError(throwable, errorResponse)
            } else {
                ApiError.HttpError(throwable, errorResponse)
            }
        }
        return ApiError.UnexpectedError(throwable)
    }

    private fun deserializeServerError(errorString: String): ErrorResponse? {
        val gson = GsonBuilder()
            .registerTypeAdapter(Any::class.java, ErrorDeserializer())
            .create()
        return try {
            gson.fromJson(errorString, ErrorResponse::class.java)
        } catch (ignored: Exception) {
            null
        }
    }
}
