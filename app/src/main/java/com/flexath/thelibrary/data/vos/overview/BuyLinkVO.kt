package com.flexath.thelibrary.data.vos.overview

import com.google.gson.annotations.SerializedName

data class BuyLinkVO(

    @SerializedName("name")
    val name: String?,

    @SerializedName("url")
    val url: String?
)