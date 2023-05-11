package com.flexath.thelibrary.data.vos.google

import com.google.gson.annotations.SerializedName

data class Epub(

    @SerializedName("acsTokenLink")
    val acsTokenLink: String?,

    @SerializedName("isAvailable")
    val isAvailable: Boolean?
)