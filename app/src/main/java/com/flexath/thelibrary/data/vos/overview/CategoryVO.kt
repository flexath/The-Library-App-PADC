package com.flexath.thelibrary.data.vos.overview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.flexath.thelibrary.persistence.typeconverters.AnyTypeConverter
import com.flexath.thelibrary.persistence.typeconverters.BookVOTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_table")
@TypeConverters(
    BookVOTypeConverter::class,
    AnyTypeConverter::class
)
data class CategoryVO(

    @SerializedName("books")
    @ColumnInfo(name = "books")
    val books: List<BookVO>?,

    @SerializedName("display_name")
    @ColumnInfo(name = "display_name")
    val displayName: String?,

    @SerializedName("list_id")
    @PrimaryKey
    var listId: Int = 0,

    @SerializedName("list_image")
    @ColumnInfo(name = "list_image")
    val listImage: Any?,

    @SerializedName("list_image_height")
    @ColumnInfo(name = "list_image_height")
    val listImageHeight: Any?,

    @SerializedName("list_image_width")
    @ColumnInfo(name = "list_image_width")
    val listImageWidth: Any?,

    @SerializedName("list_name")
    @ColumnInfo(name = "list_name")
    val listName: String?,

    @SerializedName("list_name_encoded")
    @ColumnInfo(name = "list_name_encoded")
    val listNameEncoded: String?,

    @SerializedName("updated")
    @ColumnInfo(name = "updated")
    val updated: String?
)