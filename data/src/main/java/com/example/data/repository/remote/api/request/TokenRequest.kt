package com.example.data.repository.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TokenRequest(
    @Expose
    @SerializedName("refresh_token")
    val refreshToken: String
)
