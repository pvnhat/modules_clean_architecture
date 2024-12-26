package com.example.data.repository.local

import com.example.data.model.UserData
import com.example.data.model.UserToken
import com.example.data.repository.local.api.SharedPrefApi
import com.example.data.repository.local.api.helper.execute
import com.example.data.repository.local.api.pref.PREF_USER_DATA
import com.example.data.repository.local.api.pref.PREF_USER_TOKEN
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val sharedPrefApi: SharedPrefApi
) {
    fun saveUserToken(userToken: UserToken) {
        sharedPrefApi.execute { put(PREF_USER_TOKEN, userToken) }
    }

    fun saveMyProfile(user: UserData) {
        sharedPrefApi.execute { put(PREF_USER_DATA, user) }
    }

    fun getSavedProfile(): UserData? {
        return sharedPrefApi.execute { get(PREF_USER_DATA, UserData::class.java) }
    }

    fun getUserToken(): String? {
        return sharedPrefApi.execute { get(PREF_USER_TOKEN, String::class.java) }
    }

    fun logOut() {
        sharedPrefApi.execute {
            removeKey(PREF_USER_TOKEN)
            removeKey(PREF_USER_DATA)
        }
    }
}
