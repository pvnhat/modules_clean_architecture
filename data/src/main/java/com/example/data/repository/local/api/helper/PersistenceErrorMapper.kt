package com.example.data.repository.local.api.helper

import com.example.data.repository.local.error.PersistenceError
import com.example.domain.error.ErrorEntity
import com.example.domain.error.ErrorMapper

object PersistenceErrorMapper : ErrorMapper {
    override fun map(throwable: Throwable): ErrorEntity {
        // TODO: handle other error if needed
        return PersistenceError.SharedPrefError(throwable)
    }
}
