package com.example.data.repository.remote.api

import com.example.data.model.UserToken
import com.example.data.repository.remote.api.request.TokenRequest
import retrofit2.http.GET
import retrofit2.http.POST

interface NoneAuthApi {
    @POST("login")
    suspend fun login(username: String, password: String): UserToken

    @POST("refresh_token")
    suspend fun refreshToken(request: TokenRequest): UserToken
}
