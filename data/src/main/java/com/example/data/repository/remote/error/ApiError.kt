package com.example.data.repository.remote.error

import com.example.data.repository.remote.api.response.ErrorResponse
import com.example.domain.error.ErrorEntity

sealed class ApiError : ErrorEntity() {
    data class HttpError(
        override val originalThrowable: Throwable,
        val errorResponse: ErrorResponse?
    ) : ApiError()

    data class ServerError(
        override val originalThrowable: Throwable,
        val errorResponse: ErrorResponse?
    ) : ApiError()

    data class NetworkError(override val originalThrowable: Throwable) : ApiError()

    data class ExpiredTokenError(override val originalThrowable: Throwable) : ApiError()

    data class UnexpectedError(override val originalThrowable: Throwable) : ApiError()
}
