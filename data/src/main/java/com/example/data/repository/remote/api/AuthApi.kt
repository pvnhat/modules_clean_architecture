package com.example.data.repository.remote.api

import com.example.data.model.MovieData
import com.example.data.repository.remote.api.response.BaseListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AuthApi {
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
    ): BaseListResponse<MovieData>

    @GET("/3/movie/{id}")
    suspend fun getMovieDetail(@Path("id") movieId: Int): MovieData
}
