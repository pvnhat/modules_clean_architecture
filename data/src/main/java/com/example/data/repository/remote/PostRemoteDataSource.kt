package com.example.data.repository.remote

import androidx.paging.PagingData
import com.example.data.model.PostData
import com.example.data.model.PostDetail
import com.example.data.repository.remote.api.AuthApi
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.api.helper.execute
import com.example.data.repository.remote.paging.CommonPager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Suppress("TooManyFunctions", "LargeClass")
class PostRemoteDataSource @Inject constructor(
    private val authApi: AuthApi,
    private val noneAuthApi: NoneAuthApi
) {

    fun getNewestPosts(limit: Int): Flow<PagingData<PostData>> {
        return CommonPager<PostData>().execute(block = { page ->
            noneAuthApi.execute { getNewestPosts(page, limit = limit) }
        })
    }

    suspend fun getPostDetail(slug: String): PostDetail {
        return authApi.execute {
            getPostDetail(slug)
        }
    }
}
