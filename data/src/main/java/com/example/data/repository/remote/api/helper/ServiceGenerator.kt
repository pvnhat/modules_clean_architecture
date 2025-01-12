package com.example.data.repository.remote.api.helper

import com.example.clear_architecture_base.data.BuildConfig
import com.google.gson.Gson
import java.util.concurrent.TimeUnit
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private const val CONNECT_TIMEOUT = 20000L
    private const val READ_TIMEOUT = 20000L
    private const val WRITE_TIMEOUT = 20000L

    @Suppress("LongParameterList")
    fun <T> generate(
        baseUrl: String,
        serviceClass: Class<T>,
        gson: Gson,
        authenticator: Authenticator?,
        loggingInterceptor: HttpLoggingInterceptor?,
        vararg interceptors: Interceptor
    ): T {
        val okHttpBuilder = OkHttpClient().newBuilder()
        if (authenticator != null) {
            okHttpBuilder.authenticator(authenticator)
        }
        for (it in interceptors) {
            okHttpBuilder.addInterceptor(it)
        }
        // DON'T add other interceptor below logging interceptor.
        if (loggingInterceptor != null) {
            okHttpBuilder.addInterceptor { chain ->
                val origin = chain.request()
                val request = origin.newBuilder()
                loggingInterceptor.setLevel(
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                )
                chain.proceed(request.build())
            }
            okHttpBuilder.addInterceptor(loggingInterceptor)
        }
        okHttpBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        val retrofit =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build()
        return retrofit.create(serviceClass)
    }
}
