package com.example.shared.utils.extensions

fun Int?.orZero() = this ?: 0

fun Long?.orZero() = this ?: 0

fun Float?.orZero() = this ?: 0F

fun Double?.orZero() = this ?: 0.0
