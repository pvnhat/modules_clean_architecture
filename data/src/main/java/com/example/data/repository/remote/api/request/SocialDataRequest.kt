package com.sun.viblo.android.data.repository.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SocialDataRequest(
    @Expose
    @SerializedName("provider")
    val provider: String,
    @Expose
    @SerializedName("provider_id")
    val providerId: String,
    @Expose
    @SerializedName("name")
    val name: String? = null,
    @Expose
    @SerializedName("username")
    val username: String? = null,
    @Expose
    @SerializedName("profile_url")
    val profileUrl: String? = null,
    @Expose
    @SerializedName("email")
    val email: String? = null,
    @Expose
    @SerializedName("profile_picture")
    val profilePicture: String? = null
)
