package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.entities.MovieModel
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.base.EmptyInput
import com.example.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) : FlowUseCase<EmptyInput, PagingData<MovieModel>>() {

    override fun buildUseCase(input: EmptyInput): Flow<PagingData<MovieModel>> {
        return repository.getPopularMovies()
    }
}
