package com.example.domain.usecase.base

import com.example.domain.interactor.input.BaseInput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<Input : BaseInput, Output> {
    open val dispatchersProvider = Dispatchers.IO

    abstract fun buildUseCase(input: Input): Flow<Output>

    open operator fun invoke(input: Input): Flow<Output> {
        return buildUseCase(input).flowOn(dispatchersProvider)
    }
}
