package com.example.domain.usecase

import com.example.domain.repository.PostRepository
import com.sun.viblo.android.domain.entities.PostDetailModel
import com.sun.viblo.android.domain.interactor.input.BaseInput
import com.sun.viblo.android.domain.usecase.base.AsyncUseCase
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
