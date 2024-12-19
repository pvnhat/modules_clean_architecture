package com.sun.viblo.android.domain.usecase

import com.sun.viblo.android.data.repository.remote.api.request.AuthRequest
import com.example.domain.interactor.input.BaseInput
import com.sun.viblo.android.domain.usecase.base.AsyncUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AccountRepository,
    private val notificationRepository: NotificationRepository
) : AsyncUseCase<LoginUseCase.Input, Unit>() {
    data class Input(val loginRequest: AuthRequest) : BaseInput()

    override suspend fun buildUseCase(input: Input) {
        repository.login(input.loginRequest)
        val fcmToken = notificationRepository.getFCMToken()
        notificationRepository.updateFCMToken(fcmToken)
    }
}
