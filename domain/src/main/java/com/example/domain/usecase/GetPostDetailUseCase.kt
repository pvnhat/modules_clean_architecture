package com.example.domain.usecase

import com.example.domain.entities.PostDetailModel
import com.example.domain.interactor.input.BaseInput
import com.example.domain.repository.PostRepository
import com.example.domain.usecase.base.AsyncUseCase
import javax.inject.Inject

class GetPostDetailUseCase @Inject constructor(
    private val repository: PostRepository
) : AsyncUseCase<GetPostDetailUseCase.Input, PostDetailModel>() {

    override suspend fun buildUseCase(input: Input): PostDetailModel {
        return repository.getPostDetail(input.slug)
    }

    data class Input(
        val slug: String
    ) : BaseInput()
}
