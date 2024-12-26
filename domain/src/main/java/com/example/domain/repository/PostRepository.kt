package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.entities.PostDetailModel
import com.example.domain.entities.PostModel
import kotlinx.coroutines.flow.Flow

@Suppress("TooManyFunctions")
interface PostRepository {
    fun getNewestPosts(limit: Int): Flow<PagingData<PostModel>>

    suspend fun getPostDetail(slug: String): PostDetailModel
}
