package com.example.domain.error

abstract class ErrorEntity : Throwable() {
    abstract val originalThrowable: Throwable
}
