package com.example.domain.repository

interface UserRepository {
    fun getUserToken(): String?

    fun logOut()

    fun logIn(username: String, password:String)
}
