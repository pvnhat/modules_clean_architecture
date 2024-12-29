package com.example.clear_architecture_base.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import java.lang.IllegalStateException

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    @get:LayoutRes
    abstract val fragmentLayout: Int
    abstract val viewModel: VM

    private var _binding: VB? = null
    protected val binding
        get() = _binding ?: throw IllegalStateException("ViewDataBinding is not bound")

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, fragmentLayout, container, false)
        setupBindingVariables(binding)
        binding.executePendingBindings()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        initData()
        handleEvents()
        observes()
    }

    protected open fun setupViews() {}

    protected open fun initData() {}

    protected open fun handleEvents() {}

    protected open fun observes() {}

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    @CallSuper
    open fun setupBindingVariables(binding: VB) {
        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
        }
    }

    open fun handleError(throwable: Throwable?) {
        //  appErrorHandler.proceed(this, throwable)
    }

    /**
     * Simple default observe the process state.
     * [liveData]: the process state need to be observed.
     * [doOnSuccess]: action when process is successful.
     * [doOnFinish]: action when process is ended with either error or success.
     */
    protected fun <T> defaultObserve(
        liveData: LiveData<ProcessState<T>>,
        doOnError: (() -> Unit)? = null,
        doOnFinish: (() -> Unit)? = null,
        doOnSuccess: (T?) -> Unit
    ) {
        liveData.observe(viewLifecycleOwner) { state ->
            if (state.isError) {
                handleError(state.throwable)
                doOnError?.invoke()
                doOnFinish?.invoke()
            }
            if (state.isSuccess) {
                doOnSuccess(state.data)
                doOnFinish?.invoke()
            }
        }
    }

    protected fun <T> observeWithError(
        liveData: LiveData<ProcessState<T>>,
        doOnError: ((throwable: Throwable?) -> Unit)? = null,
        doOnFinish: (() -> Unit)? = null,
        doOnSuccess: (T?) -> Unit
    ) {
        liveData.observe(viewLifecycleOwner) { state ->
            if (state.isError) {
                doOnError?.invoke(state.throwable) ?: handleError(state.throwable)
                doOnFinish?.invoke()
            }
            if (state.isSuccess) {
                doOnSuccess(state.data)
                doOnFinish?.invoke()
            }
        }
    }

    fun showSnackBarError(@StringRes errorRes: Int) {
        //activity.showSnackbar(getString(errorRes))
    }

    companion object {
        val TAG: String = this::class.java.simpleName
    }
}
