package com.example.data.repository.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("pagination")
    @Expose
    val pagination: Pagination? = null,

    @SerializedName("last_page")
    @Expose
    val lastPage: Int? = null
) {
    data class Pagination(
        @SerializedName("total")
        @Expose
        val total: Int? = null,

        @SerializedName("count")
        @Expose
        val count: Int? = null,

        @SerializedName("per_page")
        @Expose
        val perPage: Int? = null,

        @SerializedName("current_page")
        @Expose
        val currentPage: Int? = null,

        @SerializedName("total_pages")
        @Expose
        val totalPages: Int? = null
    )
}
