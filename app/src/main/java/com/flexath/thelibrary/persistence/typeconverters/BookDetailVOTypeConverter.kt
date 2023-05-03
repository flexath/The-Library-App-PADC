package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BookDetailVOTypeConverter {

    @TypeConverter
    fun toString(bookDetailList: List<BookDetailVO>?): String {
        return Gson().toJson(bookDetailList)
    }

    @TypeConverter
    fun toBookDetailVO(jsonString: String): List<BookDetailVO>? {
        val bookDetailType = object : TypeToken<List<BookDetailVO>?>() {}.type
        return Gson().fromJson(jsonString, bookDetailType)
    }
}