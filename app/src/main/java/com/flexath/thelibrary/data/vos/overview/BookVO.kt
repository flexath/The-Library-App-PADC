package com.flexath.thelibrary.data.vos.overview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.flexath.thelibrary.data.vos.IBookVO
import com.flexath.thelibrary.persistence.typeconverters.BuyLinkTypeConverter
import com.google.gson.annotations.SerializedName

@Entity("library_table")
@TypeConverters(
    BuyLinkTypeConverter::class
)
data class BookVO(

    @SerializedName("title")
    @PrimaryKey
    val title: String,

    @SerializedName("age_group")
    @ColumnInfo("age_group")
    val ageGroup: String?,

    @SerializedName("amazon_product_url")
    @ColumnInfo("amazon_product_url")
    val amazonProductUrl: String?,

    @SerializedName("article_chapter_link")
    @ColumnInfo("article_chapter_link")
    val articleChapterLink: String?,

    @SerializedName("author")
    @ColumnInfo("author")
    val author: String?,

    @SerializedName("book_image")
    @ColumnInfo("book_image")
    var bookImage: String?,

    @SerializedName("book_image_height")
    @ColumnInfo("book_image_height")
    val bookImageHeight: Int?,

    @SerializedName("book_image_width")
    @ColumnInfo("book_image_width")
    val bookImageWidth: Int?,

    @SerializedName("book_review_link")
    @ColumnInfo("book_review_link")
    val bookReviewLink: String?,

    @SerializedName("book_uri")
    @ColumnInfo("book_uri")
    val bookUri: String?,

    @SerializedName("buy_links")
    @ColumnInfo("buy_links")
    val buyLinks: List<BuyLinkVO>?,

    @SerializedName("contributor")
    @ColumnInfo("contributor")
    val contributor: String?,

    @SerializedName("contributor_note")
    @ColumnInfo("contributor_note")
    val contributorNote: String?,

    @SerializedName("created_date")
    @ColumnInfo("created_date")
    val createdDate: String?,

    @SerializedName("description")
    @ColumnInfo("description")
    val description: String?,

    @SerializedName("first_chapter_link")
    @ColumnInfo("first_chapter_link")
    val firstChapterLink: String?,

    @SerializedName("price")
    @ColumnInfo("price")
    val price: String?,

    @SerializedName("primary_isbn10")
    @ColumnInfo("primary_isbn10")
    val primaryIsbn10: String?,

    @SerializedName("primary_isbn13")
    @ColumnInfo("primary_isbn13")
    val primaryIsbn13: String?,

    @SerializedName("publisher")
    @ColumnInfo("publisher")
    val publisher: String?,

    @SerializedName("rank")
    @ColumnInfo("rank")
    val rank: Int?,

    @SerializedName("rank_last_week")
    @ColumnInfo("rank_last_week")
    val rankLastWeek: Int?,

    @SerializedName("sunday_review_link")
    @ColumnInfo("sunday_review_link")
    val sundayReviewLink: String?,

    @SerializedName("updated_date")
    @ColumnInfo("updated_date")
    val updatedDate: String?,

    @SerializedName("weeks_on_list")
    @ColumnInfo("weeks_on_list")
    val weeksOnList: Int?,

    @ColumnInfo("list_id")
    var listId:Int?,

    @ColumnInfo("list_name")
    var listName:String?

)