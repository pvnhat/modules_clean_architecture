package com.example.clear_architecture_base.ui.base

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.plus

abstract class BaseViewModel : ViewModel() {
    val exception = MediatorLiveData<Throwable>()
    val loading = MediatorLiveData<Boolean>().apply { value = false }
    val isRefreshing = MutableLiveData<Boolean>().apply { value = false }

    init {
        // turn off [loading] when [exception] has value
        loading.addSource(exception) { loading.value = it == null }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        exception.postValue(throwable)
    }

    protected val scope = viewModelScope.plus(exceptionHandler)

    /**
     * Track the [loading] state, in most cases use for showing center loading.
     * if there is another loading or is refreshing then no need to show center loading indicator.
     */
    protected fun <T> addSource(vararg liveDatas: LiveData<out ProcessState<T>>) {
        liveDatas.forEach { liveData ->
            loading.addSource(liveData) {
                if (isRefreshing.value == true) {
                    loading.value = false
                    isRefreshing.value = (isRefreshing.value ?: false) &&
                        liveDatas.all { it.value?.isFinish ?: true }.not()
                } else {
                    val processing = liveDatas.any { it.value?.isLoading == true } &&
                        !hasOtherLoading() &&
                        !(isRefreshing.value ?: false)
                    loading.value = processing
                    if (!processing) {
                        isRefreshing.value = false
                    }
                }
            }
        }
    }

    /**
     * When it set true, the center loading will be hidden.
     * Ex: [#LoadMore] indicator
     */
    open fun hasOtherLoading() = false
}
