package com.example.data.repository.remote.api

import com.example.data.model.UserToken
import retrofit2.http.GET

interface NoneAuthApi {
    @GET("login")
    suspend fun login(username: String, password: String): UserToken
}
