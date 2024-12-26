package com.example.domain.usecase.base

import com.example.domain.interactor.input.BaseInput
import com.example.domain.interactor.output.OutputObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class AsyncUseCase<Input : BaseInput, Output> {
    open val dispatchersProvider = Dispatchers.IO

    abstract suspend fun buildUseCase(input: Input): Output

    @Suppress("TooGenericExceptionCaught")
    open suspend operator fun invoke(
        input: Input,
        block: (OutputObserver<Output>.() -> Unit)? = null
    ) {
        val response = OutputObserver<Output>().apply { block?.invoke(this) }
        response()
        try {
            val result =
                withContext(dispatchersProvider) {
                    buildUseCase(input)
                }
            response(result)
        } catch (throwable: Throwable) {
            response(throwable)
        } finally {
            response.invoke(true)
        }
    }
}
