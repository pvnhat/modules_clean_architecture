
package com.example.clear_architecture_base.ui.base

object Loading : Status()
object Success : Status()
object Error : Status()
sealed class Status

data class ProcessState<out T>(
    val status: Status,
    val data: T? = null,
    val throwable: Throwable? = null
) {
    val isLoading = status is Loading
    val isSuccess = status is Success
    val isError = status is Error
    val isFinish: Boolean
        get() = isError || isSuccess

    companion object {
        fun <T> success(data: T? = null): ProcessState<T> {
            return ProcessState(Success, data)
        }

        fun <T> error(throwable: Throwable?): ProcessState<T> {
            return ProcessState(Error, throwable = throwable)
        }

        fun <T> loading(): ProcessState<T> {
            return ProcessState(Loading)
        }
    }
}
