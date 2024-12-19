package com.example.data.repository

import com.example.data.mapper.UserMapper
import com.example.data.repository.local.UserLocalDataSource
import com.example.data.repository.remote.UserRemoteDataSource
import com.example.domain.entities.UserModel
import com.example.domain.repository.UserRepository
import javax.inject.Inject

@Suppress("LongParameterList", "TooManyFunctions")
class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource,
    private val userMapper: UserMapper,
) : UserRepository {
    override suspend fun getUserProfile(username: String): UserModel {
        return userMapper.map(remoteDataSource.getUserProfile(username))
    }

    override fun getUserToken(): String? {
        return localDataSource.getUserToken()
    }

    override fun logOut() {
        localDataSource.logOut()
    }

    override fun logIn() {
        // TODO later
    }
}
