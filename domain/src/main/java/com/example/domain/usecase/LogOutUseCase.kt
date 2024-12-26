package com.example.domain.usecase

import com.example.domain.repository.UserRepository
import com.example.domain.usecase.base.EmptyInput
import com.example.domain.usecase.base.SyncUseCase
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val repository: UserRepository
) : SyncUseCase<EmptyInput, Unit>() {
    override fun buildUseCase(input: EmptyInput) {
        return repository.logOut()
    }
}
