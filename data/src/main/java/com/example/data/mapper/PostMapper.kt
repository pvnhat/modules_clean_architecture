package com.example.data.mapper

import com.example.data.model.PostData
import com.example.domain.entities.PostModel
import javax.inject.Inject

class PostMapper @Inject constructor(
    private val userMapper: UserMapper,
) : DataMapper<PostData, PostModel>() {
    override fun map(data: PostData): PostModel {
        return PostModel(
            id = data.id,
            title = data.title,
            slug = data.slug,
            url = data.url,
            system = data.system,
            userId = data.userId,
            transliterated = data.transliterated,
            contentsShort = data.contentsShort,
            publishedAt = data.publishedAt,
            scheduledPublishAt = data.scheduledPublishAt,
            isShared = data.isShared,
            updatedAt = data.updatedAt,
            editedAt = data.editedAt,
            translationSource = data.translationSource,
            trendAt = data.trendAt,
            promotedAt = data.promotedAt,
            readingTime = data.readingTime,
            organizationPinnedAt = data.organizationPinnedAt,
            profilePinPosition = data.profilePinPosition,
            points = data.points,
            viewsCount = data.viewsCount,
            clipsCount = data.clipsCount,
            commentsCount = data.commentsCount,
            ratedValue = data.ratedValue,
            promoted = data.promoted,
            trending = data.trending,
            isVideo = data.isVideo,
            thumbnailUrl = data.thumbnailUrl,
            user = userMapper.nullableMap(data.user?.data),
            teaser = data.teaser
        )
    }
}
