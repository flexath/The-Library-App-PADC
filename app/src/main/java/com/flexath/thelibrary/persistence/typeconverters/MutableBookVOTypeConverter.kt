package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MutableBookVOTypeConverter {
    @TypeConverter
    fun toString(bookList: MutableList<BookVO>?) :String {
        return Gson().toJson(bookList)
    }

    @TypeConverter
    fun toBookVO(jsonString:String) : MutableList<BookVO>? {
        val bookListType = object : TypeToken<MutableList<BookVO>?>(){}.type
        return Gson().fromJson(jsonString,bookListType)
    }
}