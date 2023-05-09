package com.flexath.thelibrary.data.vos.list

import com.flexath.thelibrary.data.vos.IBookVO
import com.google.gson.annotations.SerializedName

data class BookDetailVO(

    @SerializedName("age_group")
    val ageGroup: String?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("contributor")
    val contributor: String?,

    @SerializedName("contributor_note")
    val contributorNote: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("price")
    val price: String?,

    @SerializedName("primary_isbn10")
    val primaryIsbn10: String?,

    @SerializedName("primary_isbn13")
    val primaryIsbn13: String?,

    @SerializedName("publisher")
    val publisher: String?,

    @SerializedName("title")
    val title: String?
)