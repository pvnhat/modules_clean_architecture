package com.example.data.repository.remote.api.helper

import com.example.data.BuildConfig


object ApiConfig {
    const val BASIC_AUTHORIZATION = "Authorization"
    const val AUTHORIZATION_TOKEN = "X-Api-Authorization"
    const val ANDROID_PLATFORM = "android"
    const val BEARER = "Bearer"
    const val FLAVOR_DEV = "develop"
    const val FLAVOR_STG = "staging"
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
