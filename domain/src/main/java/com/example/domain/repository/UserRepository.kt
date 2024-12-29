package com.example.domain.repository

interface UserRepository {
    fun getUserToken(): String?

    fun logOut()

    suspend fun logIn(username: String, password:String)
}
