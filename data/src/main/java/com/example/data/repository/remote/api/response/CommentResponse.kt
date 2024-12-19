package com.sun.viblo.android.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CommentResponse {
    @SerializedName("comment")
    @Expose
    val comments: BaseResponse<PostCommentData>? = null
}
