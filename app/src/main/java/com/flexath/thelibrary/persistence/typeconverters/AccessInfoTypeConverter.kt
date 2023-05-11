package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.google.AccessInfo
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AccessInfoTypeConverter {
    @TypeConverter
    fun toString(accessInfo: AccessInfo?) :String {
        return Gson().toJson(accessInfo)
    }

    @TypeConverter
    fun toAccessInfo(jsonString:String) : AccessInfo? {
        val accessInfoType = object : TypeToken<AccessInfo?>(){}.type
        return Gson().fromJson(jsonString,accessInfoType)
    }
}