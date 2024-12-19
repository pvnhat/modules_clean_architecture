package com.sun.viblo.android.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NotificationResponse(
    @SerializedName("counter")
    @Expose
    val counter: Int? = null,
    @SerializedName("notifications")
    @Expose
    val data: BaseResponse<List<NotificationData>>
)
