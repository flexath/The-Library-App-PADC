package com.flexath.thelibrary.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.persistence.typeconverters.MutableBookVOTypeConverter

@Entity(tableName = "shelf_table")
@TypeConverters(
    MutableBookVOTypeConverter::class
)
data class ShelfVO(
    @PrimaryKey(autoGenerate = true)
    var Id:Int = 0,

    @ColumnInfo("shelf_name")
    var shelfName:String?,

    @ColumnInfo("book_count")
    var bookCount:Int? = 0,

    @ColumnInfo("book_list")
    var bookList: MutableList<BookVO>? = mutableListOf(),

    @ColumnInfo("checked")
    var isChecked:Boolean? = false
)
