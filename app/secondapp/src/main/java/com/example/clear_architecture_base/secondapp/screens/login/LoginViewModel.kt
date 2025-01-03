package com.example.clear_architecture_base.secondapp.screens.login

import com.example.clear_architecture_base.ui.base.BaseViewModel
import com.example.clear_architecture_base.ui.base.ProcessState
import com.example.clear_architecture_base.utils.livedata.SingleLiveEvent
import com.example.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {
    val loginState = SingleLiveEvent<ProcessState<Unit>>()

    init {
        addSource(loginState)
    }

    fun login(username: String, password: String) {
        defaultExecute(
            loginUseCase,
            LoginUseCase.Input(username, password),
            loginState
        )
    }
}
