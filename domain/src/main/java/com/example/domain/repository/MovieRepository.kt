package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.entities.MovieModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<MovieModel>>

    suspend fun getMovieDetail(id: Int): MovieModel
}
