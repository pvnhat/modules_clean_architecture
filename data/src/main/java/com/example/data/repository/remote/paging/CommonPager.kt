package com.example.data.repository.remote.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.repository.remote.api.response.BaseListResponse
import com.example.shared.utils.DEFAULT_PAGE_ITEMS_COUNT
import kotlinx.coroutines.flow.Flow

class CommonPager<T : Any> {
    fun execute(
        limit: Int = DEFAULT_PAGE_ITEMS_COUNT,
        block: suspend (Int) -> BaseListResponse<T>
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
