package com.sun.viblo.android.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostCommentResponse {
    @SerializedName("comments")
    @Expose
    val comments: BaseResponse<List<PostCommentData>>? = null
}
