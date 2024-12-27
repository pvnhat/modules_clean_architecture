package com.example.data.di

import com.example.data.repository.MovieRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.MovieRepository
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun providePostRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}
