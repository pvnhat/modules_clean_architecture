package com.example.data.repository.remote.api.helper

import com.example.clear_architecture_base.data.BuildConfig

object ApiConfig {
    const val AUTHORIZATION = "Authorization"
    const val ANDROID_PLATFORM = "android"
    const val BEARER = "Bearer"
    const val FLAVOR_DEV = "develop"
    const val FLAVOR_STG = "uat"
    const val FLAVOR_PRD = "production"

    fun baseUrl(): String {
        return BuildConfig.BASE_API_URL
    }

    fun getClientId(): String {
        return ""
    }

    fun getClientSecret(): String {
        return ""
    }

    fun getBearerToken(idToken: String?): String {
        return "$BEARER $idToken"
    }
}
