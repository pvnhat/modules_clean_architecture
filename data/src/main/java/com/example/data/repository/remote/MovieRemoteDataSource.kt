package com.example.data.repository.remote

import androidx.paging.PagingData
import com.example.data.model.MovieData
import com.example.data.repository.remote.api.AuthApi
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.api.helper.execute
import com.example.data.repository.remote.paging.CommonPager
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MovieRemoteDataSource @Inject constructor(
    private val authApi: AuthApi,
    private val noneAuthApi: NoneAuthApi
) {

    fun getPopularMovies(): Flow<PagingData<MovieData>> {
        return CommonPager<MovieData>().execute(block = { page ->
            authApi.execute { this.getPopularMovies(page) }
        })
    }

    suspend fun getMovieDetail(id: Int): MovieData {
        return authApi.execute {
            this.getMovieDetail(id)
        }
    }
}
