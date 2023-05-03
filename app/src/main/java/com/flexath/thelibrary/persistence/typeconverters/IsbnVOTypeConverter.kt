package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.list.IsbnVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class IsbnVOTypeConverter {

    @TypeConverter
    fun toString(isbnList: List<IsbnVO>?): String {
        return Gson().toJson(isbnList)
    }

    @TypeConverter
    fun toIsbnVO(jsonString: String): List<IsbnVO>? {
        val isbnType = object : TypeToken<List<IsbnVO>?>() {}.type
        return Gson().fromJson(jsonString, isbnType)
    }
}