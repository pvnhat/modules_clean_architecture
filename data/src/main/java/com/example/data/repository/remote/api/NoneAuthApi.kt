package com.example.data.repository.remote.api

import com.example.data.model.PostData
import com.example.data.repository.remote.api.response.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("TooManyFunctions", "LargeClass", "LongParameterList")
interface NoneAuthApi {
    @GET("posts/newest")
    suspend fun getNewestPosts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

}
