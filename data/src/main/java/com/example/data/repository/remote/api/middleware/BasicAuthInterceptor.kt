package com.example.data.repository.remote.api.middleware

import com.example.data.repository.remote.api.helper.ApiConfig.BASIC_AUTHORIZATION
import com.example.data.repository.remote.api.helper.ApiConfig.FLAVOR_PRD
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

@Suppress("KotlinConstantConditions")
class BasicAuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
//        if (BuildConfig.FLAVOR != FLAVOR_PRD) {
//            builder.addHeader(
//                BASIC_AUTHORIZATION,
//                Credentials.basic(BuildConfig.BASIC_ACCOUNT, BuildConfig.BASIC_PASSWORD)
//            )
//        }
        return chain.proceed(builder.build())
    }
}
