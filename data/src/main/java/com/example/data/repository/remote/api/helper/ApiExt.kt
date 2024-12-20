package com.example.data.repository.remote.api.helper

import com.example.data.repository.remote.api.AuthApi
import com.example.data.repository.remote.api.NoneAuthApi
import com.example.data.repository.remote.error.ApiErrorMapper

@Suppress("TooGenericExceptionCaught")
inline fun <R> AuthApi.execute(block: AuthApi.() -> R): R {
    try {
        return block()
    } catch (throwable: Throwable) {
        throw ApiErrorMapper.map(throwable)
    }
}

@Suppress("TooGenericExceptionCaught")
inline fun <R> NoneAuthApi.execute(block: NoneAuthApi.() -> R): R {
    try {
        return block()
    } catch (throwable: Throwable) {
        throw ApiErrorMapper.map(throwable)
    }
}
