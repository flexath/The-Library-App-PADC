package com.flexath.thelibrary.network.responses

import com.flexath.thelibrary.data.vos.google.GoogleBookVO
import com.google.gson.annotations.SerializedName

data class BookGoogleResponse(

    @SerializedName("items")
    val items: List<GoogleBookVO>?,

    @SerializedName("kind")
    val kind: String?,

    @SerializedName("totalItems")
    val totalItems: Int?
)