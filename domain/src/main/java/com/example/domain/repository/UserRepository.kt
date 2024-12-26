package com.example.domain.repository

import com.example.domain.entities.UserModel

@Suppress("LongParameterList", "TooManyFunctions")
interface UserRepository {
    suspend fun getUserProfile(username: String): UserModel

    fun getUserToken(): String?

    fun logOut()

    fun logIn(username: String, password:String)
}
