package com.example.domain.usecase

import com.example.domain.entities.MovieModel
import com.example.domain.interactor.input.BaseInput
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.base.AsyncUseCase
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val repository: MovieRepository
) : AsyncUseCase<GetMovieDetailUseCase.Input, MovieModel>() {

    override suspend fun buildUseCase(input: Input): MovieModel {
        return repository.getMovieDetail(input.id)
    }

    data class Input(val id: Int) : BaseInput()
}
