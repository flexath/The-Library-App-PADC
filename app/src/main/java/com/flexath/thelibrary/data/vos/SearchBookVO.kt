package com.flexath.thelibrary.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flexath.thelibrary.data.vos.overview.BookVO

@Entity(tableName = "search_table")
data class SearchBookVO(

    @PrimaryKey
    var title:String,

    @ColumnInfo("author")
    var author:String?,

    @ColumnInfo("description")
    var description: String?,

    @ColumnInfo("image")
    var image: String?,
)
