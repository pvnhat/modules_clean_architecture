package com.example.data.di

import android.content.Context
import com.example.data.repository.local.api.SharedPrefApi
import com.example.data.repository.local.api.pref.SharedPrefApiImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context, gson: Gson): SharedPrefApi {
        return SharedPrefApiImpl(context, gson)
    }
}
