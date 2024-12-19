package com.example.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sun.viblo.android.data.repository.remote.api.response.BaseResponse

data class UserData(
    @SerializedName("id")
    @Expose
    val id: Int? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("username")
    @Expose
    val username: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("avatar")
    @Expose
    val avatar: String? = null,

    @SerializedName("following")
    @Expose
    val following: Boolean? = null,

    @SerializedName("reputation")
    @Expose
    val reputation: Int? = null,

    @SerializedName("followers_count")
    @Expose
    val followersCount: Int? = null,

    @SerializedName("posts_count")
    @Expose
    val postsCount: Int? = null,

    @SerializedName("answers_count")
    @Expose
    val answersCount: Int? = null,

    @SerializedName("questions_count")
    @Expose
    val questionsCount: Int? = null,

    @SerializedName("banned_at")
    @Expose
    val bannedAt: String? = null,

    @SerializedName("level_partner")
    @Expose
    val levelPartner: String? = null,

    @SerializedName("total_post_views")
    @Expose
    val totalPostViews: Int? = null,

    @SerializedName("posts_stats")
    @Expose
    val postsStats: HashMap<String, Int>? = null
) : BaseData()
