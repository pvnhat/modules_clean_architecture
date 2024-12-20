package com.example.data.repository.remote.api

import com.example.data.model.PostDetail
import com.example.data.model.UserData
import com.example.data.repository.remote.api.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {
    @GET("p/{slug}")
    suspend fun getPostDetail(@Path("slug") slug: String): PostDetail

    @GET("users/{username}")
    suspend fun getUserProfile(@Path("username") username: String): BaseResponse<UserData>
}
