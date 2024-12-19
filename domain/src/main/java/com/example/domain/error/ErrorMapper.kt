package com.example.domain.error


interface ErrorMapper {
    fun map(throwable: Throwable): ErrorEntity
}
