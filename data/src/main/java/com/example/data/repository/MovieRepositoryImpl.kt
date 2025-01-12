package com.example.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.mapper.MovieMapper
import com.example.data.repository.remote.MovieRemoteDataSource
import com.example.domain.entities.MovieModel
import com.example.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val movieMapper: MovieMapper
) : MovieRepository {
    override fun getPopularMovies(): Flow<PagingData<MovieModel>> {
        return remoteDataSource.getPopularMovies().map { pager ->
            pager.map {
                movieMapper.map(it)
            }
        }
    }

    override suspend fun getMovieDetail(id: Int): MovieModel {
        val post = remoteDataSource.getMovieDetail(id)
        return movieMapper.map(post)
    }
}
