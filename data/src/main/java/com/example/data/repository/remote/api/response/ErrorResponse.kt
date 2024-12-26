package com.example.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @Expose
    @SerializedName("error")
    val error: Any?,

    @Expose
    @SerializedName("message", alternate = ["reason"])
    val message: String?,

    @Expose
    @SerializedName("errors")
    val errors: Errors?
) {
    data class Error(
        @Expose
        @SerializedName("code")
        val code: Int?,
        @Expose
        @SerializedName("type")
        val type: String?,
        @Expose
        @SerializedName("message")
        val message: String?
    )

    data class Errors(
        @Expose
        @SerializedName("email")
        val email: List<String>?,
        @Expose
        @SerializedName("name")
        val name: List<String>?,
        @Expose
        @SerializedName("password")
        val password: List<String>?,
        @Expose
        @SerializedName("password_confirmation")
        val passwordConfirmation: List<String>?,
        @Expose
        @SerializedName("username")
        val username: List<String>?
    )
}
