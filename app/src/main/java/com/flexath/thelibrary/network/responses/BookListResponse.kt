package com.flexath.thelibrary.network.responses

import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.google.gson.annotations.SerializedName

data class BookListResponse(

    @SerializedName("copyright")
    val copyright: String?,

    @SerializedName("last_modified")
    val lastModified: String?,

    @SerializedName("num_results")
    val numResults: Int?,

    @SerializedName("results")
    val results: List<BookListResultVO>?,

    @SerializedName("status")
    val status: String?
)