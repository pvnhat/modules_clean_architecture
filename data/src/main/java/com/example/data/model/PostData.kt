package com.example.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.viblo.android.data.repository.remote.api.response.BaseResponse

data class PostData(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("slug")
    @Expose
    val slug: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("system")
    @Expose
    val system: String? = null,

    @SerializedName("user_id")
    @Expose
    val userId: Int? = null,

    @SerializedName("transliterated")
    @Expose
    val transliterated: String? = null,

    @SerializedName("contents_short")
    @Expose
    val contentsShort: String? = null,

    @SerializedName("published_at")
    @Expose
    val publishedAt: String? = null,

    @SerializedName("scheduled_publish_at")
    @Expose
    val scheduledPublishAt: String? = null,

    @SerializedName("is_shared")
    @Expose
    val isShared: Boolean? = null,

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String? = null,

    @SerializedName("edited_at")
    @Expose
    val editedAt: String? = null,

    @SerializedName("translation_source")
    @Expose
    val translationSource: String? = null,

    @SerializedName("trend_at")
    @Expose
    val trendAt: String? = null,

    @SerializedName("promoted_at")
    @Expose
    val promotedAt: String? = null,

    @SerializedName("reading_time")
    @Expose
    val readingTime: Int? = null,

    @SerializedName("organization_pinned_at")
    @Expose
    val organizationPinnedAt: String? = null,

    @SerializedName("profile_pin_position")
    @Expose
    val profilePinPosition: String? = null,

    @SerializedName("points")
    @Expose
    val points: Int? = null,

    @SerializedName("views_count")
    @Expose
    val viewsCount: Int? = null,

    @SerializedName("clips_count")
    @Expose
    val clipsCount: Int? = null,

    @SerializedName("comments_count")
    @Expose
    val commentsCount: Int? = null,

    @SerializedName("rated_value")
    @Expose
    val ratedValue: Int? = null,

    @SerializedName("promoted")
    @Expose
    val promoted: Boolean? = null,

    @SerializedName("trending")
    @Expose
    val trending: Boolean? = null,

    @SerializedName("is_video")
    @Expose
    val isVideo: Boolean? = null,

    @SerializedName("thumbnail_url")
    @Expose
    val thumbnailUrl: String? = null,

    @SerializedName("user")
    @Expose
    val user: BaseResponse<UserData>? = null,

    @SerializedName("teaser")
    @Expose
    val teaser: String? = null
) : BaseData()
