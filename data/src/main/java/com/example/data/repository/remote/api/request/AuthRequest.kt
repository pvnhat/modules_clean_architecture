package com.example.data.repository.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.example.data.repository.remote.api.helper.ApiConfig

data class AuthRequest(
    @Expose
    @SerializedName("username")
    val username: String? = null,
    @Expose
    @SerializedName("password")
    val password: String? = null,
    @Expose
    @SerializedName("grant_type")
    val grantType: String? = null,
    @Expose
    @SerializedName("refresh_token")
    val refreshToken: String? = null,
    @Expose
    @SerializedName("provider")
    val provider: String? = null,
    @Expose
    @SerializedName("service")
    val service: String? = null,
    @Expose
    @SerializedName("token")
    val token: String? = null,
    @Expose
    @SerializedName("client_id")
    val clientId: String = ApiConfig.getClientId(),
    @Expose
    @SerializedName("client_secret")
    val clientSecret: String = ApiConfig.getClientSecret()
)

enum class GrantType(val value: String) {
    SOCIAL("social"),
    PASSWORD("password"),
    REFRESH_TOKEN("refresh_token")
}

enum class SSOType(val value: String) {
    FACEBOOK("facebook"),
    GOOGLE("google"),
    GITHUB("github")
}
