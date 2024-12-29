package com.example.data.di

import TokenAuthenticator
import com.example.data.repository.local.api.SharedPrefApi
import com.example.data.repository.remote.api.AuthApi
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.api.helper.ApiConfig
import com.example.data.repository.remote.api.helper.ServiceGenerator
import com.example.data.repository.remote.api.middleware.AuthInterceptor
import com.example.data.repository.remote.api.middleware.BasicAuthInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideBasicAuthInterceptor(): BasicAuthInterceptor {
        return BasicAuthInterceptor()
    }

    @Provides
    @Singleton
    fun provideNoneAuthApi(gson: Gson, basicAuthInterceptor: BasicAuthInterceptor): NoneAuthApi {
        return ServiceGenerator.generate(
            baseUrl = ApiConfig.baseUrl(),
            serviceClass = NoneAuthApi::class.java,
            gson = gson,
            authenticator = null,
            loggingInterceptor = HttpLoggingInterceptor(),
            interceptors = arrayOf(basicAuthInterceptor)
        )
    }

    @Provides
    @Singleton
    fun provideAuthApi(
        gson: Gson,
        sharedPrefApi: SharedPrefApi,
        noneAuthApi: NoneAuthApi,
        basicAuthInterceptor: BasicAuthInterceptor
    ): AuthApi {
        return ServiceGenerator.generate(
            baseUrl = ApiConfig.baseUrl(),
            serviceClass = AuthApi::class.java,
            gson = gson,
            authenticator = TokenAuthenticator(noneAuthApi, sharedPrefApi),
            loggingInterceptor = HttpLoggingInterceptor(),
            interceptors = arrayOf(
                AuthInterceptor(sharedPrefApi),
                basicAuthInterceptor
            )
        )
    }

}
