package com.sun.viblo.android.domain.usecase.base

import com.example.domain.interactor.input.BaseInput

abstract class SyncUseCase<Input : BaseInput, Output> {
    abstract fun buildUseCase(input: Input): Output

    open operator fun invoke(input: Input): Output {
        return buildUseCase(input)
    }
}
