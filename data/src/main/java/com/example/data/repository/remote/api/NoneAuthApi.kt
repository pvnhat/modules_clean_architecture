package com.sun.viblo.android.data.repository.remote.api

import com.example.data.model.PostData
import com.sun.viblo.android.data.repository.remote.api.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

@Suppress("TooManyFunctions", "LargeClass", "LongParameterList")
interface NoneAuthApi {

    @GET("users/{username}/posts")
    suspend fun getPostsByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("users/{username}/questions")
    suspend fun getQuestionsByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<QuestionData>>

    @GET("users/{username}/answers")
    suspend fun getAnswersByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<AnswerData>>

    @GET("users/{username}/clipped-posts")
    suspend fun getBookmarkPostsByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("users/{username}/series")
    suspend fun getSeriesByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<SeriesData>>

    @GET("users/{username}/following-tags")
    suspend fun getTagsByUser(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<TagData>>

    @GET("tags/{slug}")
    suspend fun getTagInformation(@Path("slug") slug: String): BaseResponse<TagData>

    @GET("tags/{slug}/posts")
    suspend fun getPostsByTag(
        @Path("slug") slug: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("tags/{slug}/series")
    suspend fun getSeriesByTag(
        @Path("slug") slug: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<SeriesData>>

    @GET("tags/{slug}/questions")
    suspend fun getQuestionsByTag(
        @Path("slug") slug: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<QuestionData>>

    @POST("announcements/{slug}/counter")
    suspend fun increaseAnnouncementViewCount(
        @Path("slug") slug: String,
        @Body request: IncreaseViewCountRequest
    )

    @POST("series/{slug}/counter")
    suspend fun increaseSeriesViewCount(
        @Path("slug") slug: String,
        @Body request: IncreaseViewCountRequest
    )

    @POST("questions/{slug}/counter")
    suspend fun increaseQuestionsViewCount(
        @Path("slug") slug: String,
        @Body request: IncreaseViewCountRequest
    )

    @POST("posts/{slug}/counter")
    suspend fun increasePostsViewCount(
        @Path("slug") slug: String,
        @Body request: IncreaseViewCountRequest
    )

    @GET("announcements/{slug}")
    suspend fun getAnnouncementDetail(@Path("slug") slug: String): Announcement

    @GET("posts/{slug}/related?")
    suspend fun getRelatedPosts(@Path("slug") slug: String): RelatedPosts

    @GET("posts/newest")
    suspend fun getNewestPosts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("announcements-pin")
    suspend fun getPinnedPosts(): BaseResponse<List<PostData>>

    @GET("posts/trending")
    suspend fun getTrendingPosts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("posts/editors-choice")
    suspend fun getEditorChoicePosts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("videos")
    suspend fun getVideoPosts(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("series")
    suspend fun getSeries(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): BaseResponse<List<SeriesData>>

    @GET("content-creator")
    suspend fun getContentCreatorPosts(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("level") level: String
    ): BaseResponse<List<PostData>>

    @GET("u/{username}/skills")
    suspend fun getSkills(@Path("username") username: String): BaseResponse<List<SkillData>>

    @GET("users/{username}/organizations")
    suspend fun getOrganizations(
        @Path("username") username: String
    ): BaseResponse<List<OrganizationData>>

    @GET("search/posts")
    suspend fun searchPosts(
        @Query("q") query: String,
        @Query("s") sort: String,
        @Query("o") order: String?,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<PostData>>

    @GET("search/questions")
    suspend fun searchQuestions(
        @Query("q") query: String,
        @Query("s") sort: String,
        @Query("o") order: String?,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): BaseResponse<List<QuestionData>>
}
