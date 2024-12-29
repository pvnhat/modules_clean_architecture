package com.example.data.repository

import com.example.data.mapper.UserMapper
import com.example.data.model.UserToken
import com.example.data.repository.local.UserLocalDataSource
import com.example.data.repository.remote.UserRemoteDataSource
import com.example.domain.entities.UserModel
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

@Suppress("LongParameterList", "TooManyFunctions")
class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val localDataSource: UserLocalDataSource,
    private val userMapper: UserMapper,
) : UserRepository {

    override fun getUserToken(): String? {
        return localDataSource.getUserToken()
    }

    override fun logOut() {
        localDataSource.logOut()
    }

    override suspend fun logIn(username: String, password: String) {
        delay(1000)
        // TODO Replace token generate from themoviedb dashboard if this token expired
        localDataSource.saveUserToken(UserToken(accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MjdiNWFhOGE0NmFmMGE5OGUyYjM5OTIxMThmNDYzYiIsInN1YiI6IjVmOWZiZTJjZjA0ZDAxMDAzN2E0ZDc5YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.m-Dda75kQLr1zEk-xDKJpRLAi1G0bXVTq8sMt1LE02c"))
    }
}
