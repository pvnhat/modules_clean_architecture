package com.sun.viblo.android.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UploadImageResponse(
    @SerializedName("data")
    @Expose
    val data: ImageMetaData? = null
)
