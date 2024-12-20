package com.example.data.repository.remote

import com.example.data.model.UserData
import com.example.data.repository.remote.api.AuthApi
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.api.helper.execute
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val authApi: AuthApi,
    private val noneAuthApi: NoneAuthApi,
) {
    suspend fun getUserProfile(username: String): UserData {
        return authApi.execute { getUserProfile(username).data }
    }
}
