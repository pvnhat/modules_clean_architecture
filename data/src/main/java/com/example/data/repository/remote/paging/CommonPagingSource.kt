package com.example.data.repository.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.repository.remote.api.response.BaseListResponse
import com.example.domain.error.ErrorEntity
import com.example.clear_architecture_base.shared.utils.extensions.orZero

class CommonPagingSource<T : Any>(
    private val block: suspend (Int) -> BaseListResponse<T>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val currentPage = params.key ?: 1
            val response = block.invoke(currentPage)
            val totalPage = response.totalPages.orZero()
            val nextPage = if (currentPage + 1 <= totalPage) currentPage + 1 else null
            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (exception: ErrorEntity) {
            LoadResult.Error(exception)
        }
    }
}
