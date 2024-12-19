package com.example.domain.entities

data class PostModel(
    val id: Int? = null,
    val title: String? = null,
    val slug: String? = null,
    val url: String? = null,
    val system: String? = null,
    val userId: Int? = null,
    val transliterated: String? = null,
    val contentsShort: String? = null,
    val publishedAt: String? = null,
    val scheduledPublishAt: String? = null,
    val isShared: Boolean? = null,
    val updatedAt: String? = null,
    val editedAt: String? = null,
    val translationSource: String? = null,
    val trendAt: String? = null,
    val promotedAt: String? = null,
    val readingTime: Int? = null,
    val organizationPinnedAt: String? = null,
    val profilePinPosition: String? = null,
    val points: Int? = null,
    val viewsCount: Int? = null,
    val clipsCount: Int? = null,
    val commentsCount: Int? = null,
    val ratedValue: Int? = null,
    val promoted: Boolean? = null,
    val trending: Boolean? = null,
    val isVideo: Boolean? = null,
    val thumbnailUrl: String? = null,
    val user: UserModel? = null,
    val isPinnedPost: Boolean? = false,
    val organizationName: String? = null,
    val teaser: String? = null
) : BaseModel() {

    companion object {
        private const val POST_ANNOUNCEMENT = "announcements"
    }
}
