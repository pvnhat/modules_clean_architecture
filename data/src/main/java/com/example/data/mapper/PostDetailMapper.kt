package com.example.data.mapper

import com.example.data.model.PostDetail
import com.example.domain.entities.PostDetailModel
import javax.inject.Inject

class PostDetailMapper @Inject constructor(
    private val userMapper: UserMapper,
) : DataMapper<PostDetail, PostDetailModel>() {
    override fun map(data: PostDetail): PostDetailModel {
        return PostDetailModel(
            id = data.id,
            transliterated = data.transliterated,
            slug = data.slug,
            title = data.title,
            userId = data.userId,
            canonicalUrl = data.canonicalUrl,
            contents = data.contents,
            status = data.status,
            moderation = data.moderation,
            promoted = data.promoted,
            clipped = data.clipped,
            points = data.points,
            ratedValue = data.ratedValue,
            clipsCount = data.clipsCount,
            commentsCount = data.commentsCount,
            viewsCount = data.viewsCount,
            currentRevision = data.currentRevision,
            trending = data.trending,
            seriesId = data.seriesId,
            slideUrl = data.slideUrl,
            puzzleHashId = data.puzzleHashId,
            createdAt = data.createdAt,
            updatedAt = data.updatedAt,
            publishedAt = data.publishedAt,
            lastEditedAt = data.lastEditedAt,
            scheduledPublishAt = data.scheduledPublishAt,
            videoId = data.videoId,
            readingTime = data.readingTime,
            canShareSocial = data.canShareSocial,
            license = data.license,
            pin = data.pin,
        )
    }
}
