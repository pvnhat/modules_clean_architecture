package com.sun.viblo.android.domain.usecase

import com.example.domain.repository.UserRepository
import com.sun.viblo.android.domain.usecase.base.EmptyInput
import com.sun.viblo.android.domain.usecase.base.SyncUseCase
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val repository: UserRepository
) : SyncUseCase<EmptyInput, Unit>() {
    override fun buildUseCase(input: EmptyInput) {
        return repository.logOut()
    }
}
