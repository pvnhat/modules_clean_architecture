package com.sun.viblo.android.data.repository.remote.api

import com.example.data.model.UserToken
import com.example.data.repository.remote.api.request.AuthRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface AccountApi {
    @POST("api/password/forgot")
    suspend fun sendForgotPasswordEmail(@Body request: ResendEmailRequest)

    @POST("api/password/reset")
    suspend fun changePassword(@Body request: ChangePasswordRequest)

    @GET("api/activations/{activationToken}/agree")
    suspend fun verifyAccountEmail(
        @Header("X-Platform") platform: String,
        @Path("activationToken") activationToken: String
    )

    @POST("api/activations/send")
    suspend fun resendActivationEmail(@Body request: ResendEmailRequest)

    @POST("oauth/token")
    suspend fun requestAuthentication(@Body request: AuthRequest): UserToken

    @POST("api/register")
    suspend fun register(@Body request: RegisterRequest): RegisterData
}
