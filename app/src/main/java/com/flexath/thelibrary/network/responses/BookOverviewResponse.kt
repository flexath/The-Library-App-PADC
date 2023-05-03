package com.flexath.thelibrary.network.responses

import com.flexath.thelibrary.data.vos.overview.BookOverviewResultVO
import com.google.gson.annotations.SerializedName

data class BookOverviewResponse(

    @SerializedName("copyright")
    val copyright: String?,

    @SerializedName("num_results")
    val numResults: Int?,

    @SerializedName("results")
    val results: BookOverviewResultVO?,

    @SerializedName("status")
    val status: String?
)