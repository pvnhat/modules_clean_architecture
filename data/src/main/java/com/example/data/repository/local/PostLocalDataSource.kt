package com.example.data.repository.local

import com.example.data.repository.local.api.SharedPrefApi
import com.example.data.repository.local.api.helper.execute
import com.example.data.repository.local.api.pref.PREF_READING_MODE
import com.example.data.repository.local.api.pref.PREF_SESSION_ID
import javax.inject.Inject

class PostLocalDataSource @Inject constructor(
    private val sharedPrefApi: SharedPrefApi
) {
    fun saveAppSessionID(id: String) {
        sharedPrefApi.execute { put(PREF_SESSION_ID, id) }
    }

    fun getAppSessionID(): String? {
        return sharedPrefApi
            .get(PREF_SESSION_ID, String::class.java)
    }
}
