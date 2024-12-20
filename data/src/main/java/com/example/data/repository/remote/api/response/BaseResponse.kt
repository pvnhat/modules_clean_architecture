package com.example.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    @Expose
    val data: T,

    @SerializedName("meta")
    @Expose
    val meta: Meta? = null
)
