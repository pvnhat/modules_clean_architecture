package com.example.data.repository.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.error.ErrorEntity
import com.example.data.repository.remote.api.response.BaseResponse

class CommonPagingSource<T : Any>(
    private val block: suspend (Int) -> BaseResponse<List<T>>
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val page = params.key ?: 1
            val response = block.invoke(page)
            val totalPage = response.meta?.pagination?.totalPages ?: 0
            val nextPage = if (page + 1 <= totalPage) page + 1 else null
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
