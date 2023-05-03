package com.flexath.thelibrary.data.vos.list

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.flexath.thelibrary.persistence.typeconverters.BookDetailVOTypeConverter
import com.flexath.thelibrary.persistence.typeconverters.IsbnVOTypeConverter
import com.flexath.thelibrary.persistence.typeconverters.ReviewVOTypeConverter
import com.google.gson.annotations.SerializedName

@Entity("book_list_table")
@TypeConverters(
    BookDetailVOTypeConverter::class,
    IsbnVOTypeConverter::class,
    ReviewVOTypeConverter::class
)
data class BookListResultVO(

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,

    @SerializedName("amazon_product_url")
    @ColumnInfo("amazon_product_url")
    val amazonProductUrl: String?,

    @SerializedName("asterisk")
    @ColumnInfo("asterisk")
    val asterisk: Int?,

    @SerializedName("bestsellers_date")
    @ColumnInfo("bestsellers_date")
    val bestsellersDate: String?,

    @SerializedName("book_details")
    @ColumnInfo("book_details")
    val bookDetails: List<BookDetailVO>?,

    @SerializedName("dagger")
    @ColumnInfo("dagger")
    val dagger: Int?,

    @SerializedName("display_name")
    @ColumnInfo("display_name")
    val displayName: String?,

    @SerializedName("isbns")
    @ColumnInfo("isbns")
    val isbns: List<IsbnVO>?,

    @SerializedName("list_name")
    @ColumnInfo("list_name")
    val listName: String?,

    @SerializedName("published_date")
    @ColumnInfo("published_date")
    val publishedDate: String?,

    @SerializedName("rank")
    @ColumnInfo("rank")
    val rank: Int?,

    @SerializedName("rank_last_week")
    @ColumnInfo("rank_last_week")
    val rankLastWeek: Int?,

    @SerializedName("reviews")
    @ColumnInfo("reviews")
    val reviews: List<ReviewVO>?,

    @SerializedName("weeks_on_list")
    @ColumnInfo("weeks_on_list")
    val weeksOnList: Int?
)