package com.example.data.repository.remote.api.middleware

import com.example.data.model.UserToken
import com.example.data.repository.local.api.SharedPrefApi
import com.example.data.repository.local.api.pref.PREF_USER_TOKEN
import com.example.data.repository.remote.api.helper.ApiConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPrefApi: SharedPrefApi) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequestBuilder = originalRequest.newBuilder()
        newRequestBuilder.header(
            ApiConfig.AUTHORIZATION_TOKEN,
            ApiConfig.getBearerToken(
                sharedPrefApi.get(
                    PREF_USER_TOKEN,
                    UserToken::class.java
                )?.accessToken
            )
        )
        return chain.proceed(newRequestBuilder.build())
    }
}
