package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.google.AccessInfo
import com.flexath.thelibrary.data.vos.google.SearchInfo
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SearchInfoTypeConverter {
    @TypeConverter
    fun toString(searchInfo: SearchInfo?) :String {
        return Gson().toJson(searchInfo)
    }

    @TypeConverter
    fun toSearchInfo(jsonString:String) : SearchInfo? {
        val searchInfoType = object : TypeToken<SearchInfo?>(){}.type
        return Gson().fromJson(jsonString,searchInfoType)
    }
}