package com.flexath.thelibrary.data.vos.google

import com.google.gson.annotations.SerializedName

data class SaleInfo(

    @SerializedName("country")
    val country: String?,

    @SerializedName("isEbook")
    val isEbook: Boolean?,

    @SerializedName("saleability")
    val saleability: String?
)