package com.example.domain.usecase

import com.example.domain.interactor.input.BaseInput
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.base.AsyncUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: UserRepository,
) : AsyncUseCase<LoginUseCase.Input, Unit>() {
    data class Input(val username: String, val password: String) : BaseInput()

    override suspend fun buildUseCase(input: Input) {
        repository.logIn(input.username, input.password)
    }
}
