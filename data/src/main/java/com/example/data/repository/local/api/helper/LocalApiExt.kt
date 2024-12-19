package com.example.data.repository.local.api.helper

import com.example.data.repository.local.api.SharedPrefApi

@Suppress("TooGenericExceptionCaught")
inline fun <R> SharedPrefApi.execute(block: SharedPrefApi.() -> R): R {
    try {
        return block()
    } catch (throwable: Throwable) {
        throw PersistenceErrorMapper.map(throwable)
    }
}
