package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BookVOTypeConverter {
    @TypeConverter
    fun toString(bookList: List<BookVO>?) :String {
        return Gson().toJson(bookList)
    }

    @TypeConverter
    fun toBookVO(jsonString:String) : List<BookVO>? {
        val bookListType = object : TypeToken<List<BookVO>?>(){}.type
        return Gson().fromJson(jsonString,bookListType)
    }
}