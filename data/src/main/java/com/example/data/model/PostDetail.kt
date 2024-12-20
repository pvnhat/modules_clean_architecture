package com.example.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.example.data.repository.remote.api.response.BaseResponse

data class PostDetail(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("transliterated")
    @Expose
    val transliterated: String? = null,

    @SerializedName("slug")
    @Expose
    val slug: String? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("user_id")
    @Expose
    val userId: Int? = null,

    @SerializedName("canonical_url")
    @Expose
    val canonicalUrl: String? = null,

    @SerializedName("contents")
    @Expose
    val contents: String? = null,

    @SerializedName("status")
    @Expose
    val status: String? = null,

    @SerializedName("moderation")
    @Expose
    val moderation: String? = null,

    @SerializedName("promoted")
    @Expose
    val promoted: Boolean? = null,

    @SerializedName("clipped")
    @Expose
    val clipped: Boolean? = null,

    @SerializedName("points")
    @Expose
    val points: Int? = null,

    @SerializedName("rated_value")
    @Expose
    val ratedValue: Int? = null,

    @SerializedName("clips_count")
    @Expose
    val clipsCount: Int? = null,

    @SerializedName("comments_count")
    @Expose
    val commentsCount: Int? = null,

    @SerializedName("views_count")
    @Expose
    val viewsCount: Int? = null,

    @SerializedName("current_revision")
    @Expose
    val currentRevision: String? = null,

    @SerializedName("trending")
    @Expose
    val trending: Boolean? = null,

    @SerializedName("series_id")
    @Expose
    val seriesId: Int? = null,

    @SerializedName("slide_url")
    @Expose
    val slideUrl: String? = null,

    @SerializedName("puzzle_hash_id")
    @Expose
    val puzzleHashId: String? = null,

    @SerializedName("created_at")
    @Expose
    val createdAt: String? = null,

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String? = null,

    @SerializedName("published_at")
    @Expose
    val publishedAt: String? = null,

    @SerializedName("last_edited_at")
    @Expose
    val lastEditedAt: String? = null,

    @SerializedName("scheduled_publish_at")
    @Expose
    val scheduledPublishAt: String? = null,

    @SerializedName("video_id")
    @Expose
    val videoId: String? = null,

    @SerializedName("reading_time")
    @Expose
    val readingTime: Int? = null,

    @SerializedName("can_share_social")
    @Expose
    val canShareSocial: Boolean? = null,

    @SerializedName("license")
    @Expose
    val license: String? = null,

    @SerializedName("pin")
    @Expose
    val pin: String? = null,

    @SerializedName("summary")
    @Expose
    val summary: String? = null,

    @SerializedName("user")
    @Expose
    val user: BaseResponse<UserData>? = null,
) : BaseData()
