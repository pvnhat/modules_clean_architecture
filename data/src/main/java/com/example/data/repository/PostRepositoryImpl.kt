package com.example.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.data.mapper.PostDetailMapper
import com.example.data.mapper.PostMapper
import com.example.data.repository.remote.PostRemoteDataSource
import com.example.domain.entities.PostDetailModel
import com.example.domain.entities.PostModel
import com.example.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource,
    private val postMapper: PostMapper,
    private val postDetailMapper: PostDetailMapper,
) : PostRepository {
    override fun getNewestPosts(limit: Int): Flow<PagingData<PostModel>> {
        return remoteDataSource.getNewestPosts(limit).map { pager ->
            pager.map {
                postMapper.map(it)
            }
        }
    }

    override suspend fun getPostDetail(slug: String): PostDetailModel {
        val post = remoteDataSource.getPostDetail(slug)
        return postDetailMapper.map(post)
    }
}
