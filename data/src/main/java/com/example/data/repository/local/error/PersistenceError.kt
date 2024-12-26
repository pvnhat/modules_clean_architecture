package com.example.data.repository.local.error

import com.example.domain.error.ErrorEntity

sealed class PersistenceError : ErrorEntity() {
    data class SharedPrefError(override val originalThrowable: Throwable) : PersistenceError()
}
