package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.entities.PostModel
import com.example.domain.interactor.input.BaseInput
import com.example.domain.repository.PostRepository
import com.sun.viblo.android.domain.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewestPostsUseCase @Inject constructor(
    private val repository: PostRepository
) : FlowUseCase<GetNewestPostsUseCase.Input, PagingData<PostModel>>() {
    data class Input(val limit: Int = DEFAULT_ITEM_COUNT) : BaseInput()

    override suspend fun buildUseCase(input: Input): Flow<PagingData<PostModel>> {
        return repository.getNewestPosts(input.limit)
    }

    companion object {
        private const val DEFAULT_ITEM_COUNT = 20
    }
}
