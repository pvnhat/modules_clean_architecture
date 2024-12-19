package com.example.data.repository.remote.api.helper


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

    fun getAccountBaseUrl(): String {
        return BuildConfig.BASE_ACCOUNT_URL
    }

    fun getClientId(): String {
        return BuildConfig.CLIENT_ID
    }

    fun getClientSecret(): String {
        return BuildConfig.CLIENT_SECRET
    }

    fun getBearerToken(idToken: String?): String {
        return "$BEARER $idToken"
    }
}
