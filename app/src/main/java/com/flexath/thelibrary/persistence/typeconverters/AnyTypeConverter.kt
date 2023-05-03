package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AnyTypeConverter {
    @TypeConverter
    fun toString(any: Any?) :String {
        return Gson().toJson(any)
    }

    @TypeConverter
    fun toAny(jsonString:String) : Any? {
        val anyType = object : TypeToken<Any?>(){}.type
        return Gson().fromJson(jsonString,anyType)
    }
}