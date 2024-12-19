package com.sun.viblo.android.data.repository.remote.api

import com.skydoves.retrofit.adapters.paging.annotations.PagingKey
import com.skydoves.retrofit.adapters.paging.annotations.PagingKeyConfig
import com.sun.viblo.android.data.mapper.paging.PostPagingMapper
import com.example.data.model.PostData
import com.example.data.model.UserData
import com.sun.viblo.android.data.repository.remote.api.response.BaseResponse
import com.sun.viblo.android.data.repository.remote.api.response.CommentResponse
import com.sun.viblo.android.data.repository.remote.api.response.NotificationResponse
import com.sun.viblo.android.data.repository.remote.api.response.PostCommentResponse
import com.sun.viblo.android.data.repository.remote.api.response.UploadImageResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

@Suppress("TooManyFunctions")
interface AuthApi {
    @GET("me")
    suspend fun getUser(): BaseResponse<UserData>

    @GET("users/{username}")
    suspend fun getUserProfile(@Path("username") username: String): BaseResponse<UserData>

    @GET("posts/subscriptions")
    @PagingKeyConfig(
        keySize = 1,
        mapper = PostPagingMapper::class
    )
    suspend fun getFollowingPosts(
        @PagingKey @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("p/{slug}")
    suspend fun getPostDetail(@Path("slug") slug: String): PostDetail

    @GET("series/{hashId}")
    suspend fun getSeriesDetail(@Path("hashId") hashId: String): SeriesDetailData

    @POST("posts/{slug}/rate")
    suspend fun ratePost(@Path("slug") slug: String, @Body request: RateRequest)

    @POST("posts/{slug}/comments")
    suspend fun commentPost(
        @Path("slug") slug: String,
        @Body request: CommentRequest
    ): CommentResponse

    @POST("series/{hashId}/comments")
    suspend fun commentSeries(
        @Path("hashId") hashId: String,
        @Body request: CommentRequest
    ): CommentResponse

    @PUT("me/subscriptions/post/{slug}")
    suspend fun bookmarkPost(@Path("slug") slug: String)

    @DELETE("me/subscriptions/post/{slug}")
    suspend fun unBookmarkPost(@Path("slug") slug: String)

    @POST("series/{hashId}/rate")
    suspend fun rateSeries(@Path("hashId") hashId: String, @Body request: RateRequest)

    @PUT("me/subscriptions/series/{hashId}")
    suspend fun bookmarkSeries(@Path("hashId") slug: String)

    @DELETE("me/subscriptions/series/{hashId}")
    suspend fun unBookmarkSeries(@Path("hashId") slug: String)

    @PUT("me/subscriptions/user/{username}")
    suspend fun followUser(@Path("username") username: String)

    @DELETE("me/subscriptions/user/{username}")
    suspend fun unfollowUser(@Path("username") username: String)

    @GET("tags/{slug}/followers")
    suspend fun getFollowersByTag(
        @Path("slug") slug: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<UserData>>

    @GET("users/{username}/followers")
    suspend fun getFollowersByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<UserData>>

    @GET("users/{username}/followings")
    suspend fun getFollowingsByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<UserData>>

    @GET("me/notifications")
    suspend fun getNotifications(
        @PagingKey @Query("page") page: Int,
        @Query("limit") limit: Int
    ): NotificationResponse

    @POST("comments/{hashId}/rate")
    suspend fun rateComment(@Path("hashId") hashId: String, @Body request: RateRequest)

    @GET("posts/{slug}/comments")
    suspend fun getComments(@Path("slug") slug: String): PostCommentResponse

    @GET("series/{hashId}/comments")
    suspend fun getSeriesComments(@Path("hashId") hashId: String): PostCommentResponse

    @GET("users/{username}/comments")
    suspend fun getCommunicationByUser(@Path("username") username: String): PostCommentResponse

    @Multipart
    @POST("uploads")
    suspend fun uploadImage(@Part file: MultipartBody.Part): UploadImageResponse

    @DELETE("comments/{hashId}")
    suspend fun deleteComment(@Path("hashId") hashId: String)

    @PUT("comments/{hashId}")
    suspend fun editComment(@Path("hashId") hashId: String, @Body request: CommentRequest)

    @GET("search/users")
    suspend fun searchAuthors(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<UserData>>
}
