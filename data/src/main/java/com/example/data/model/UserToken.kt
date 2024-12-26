package com.example.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserToken(
    @Expose
    @SerializedName("token_type")
    val tokenType: String? = null,
    @Expose
    @SerializedName("expires_in")
    val expiresIn: String? = null,
    @Expose
    @SerializedName("access_token")
    val accessToken: String? = null,
    @Expose
    @SerializedName("refresh_token")
    val refreshToken: String? = null
) : BaseData()
