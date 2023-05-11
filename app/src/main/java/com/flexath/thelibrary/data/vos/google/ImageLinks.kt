package com.flexath.thelibrary.data.vos.google

import com.google.gson.annotations.SerializedName

data class ImageLinks(

    @SerializedName("smallThumbnail")
    val smallThumbnail: String?,

    @SerializedName("thumbnail")
    val thumbnail: String?
)