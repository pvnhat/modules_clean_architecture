package com.example.data.repository.remote

import com.example.data.model.UserToken
import com.example.data.repository.remote.api.AuthApi
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.api.helper.execute
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val authApi: AuthApi,
    private val noneAuthApi: NoneAuthApi
) {

    suspend fun login(username: String, password: String): UserToken {
        return noneAuthApi.execute { login(username, password) }
    }
}
