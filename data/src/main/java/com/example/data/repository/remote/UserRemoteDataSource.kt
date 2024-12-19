package com.example.data.repository.remote

import com.example.data.model.UserData
import com.example.data.repository.remote.api.helper.execute
import com.sun.viblo.android.data.repository.remote.api.AuthApi
import com.sun.viblo.android.data.repository.remote.api.NoneAuthApi
import com.sun.viblo.android.data.repository.remote.api.OtherApi
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val authApi: AuthApi,
    private val noneAuthApi: NoneAuthApi,
    private val otherApi: OtherApi
) {
    suspend fun getUserProfile(username: String): UserData {
        return authApi.execute { getUserProfile(username).data }
    }
}
