package com.example.data.repository.remote.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.repository.remote.api.response.BaseResponse
import kotlinx.coroutines.flow.Flow

class CommonPager<T : Any> {
    fun execute(
        limit: Int = 20,
        block: suspend (Int) -> BaseResponse<List<T>>
    ): Flow<PagingData<T>> {
        return Pager(
            PagingConfig(
                pageSize = limit,
                prefetchDistance = 5
            ),
            pagingSourceFactory = { CommonPagingSource(block) }
        ).flow
    }
}
