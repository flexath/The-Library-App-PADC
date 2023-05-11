package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.google.VolumeInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class VolumeInfoTypeConverter {
    @TypeConverter
    fun toString(volumeInfo: VolumeInfo?) :String {
        return Gson().toJson(volumeInfo)
    }

    @TypeConverter
    fun toVolumeInfo(jsonString:String) : VolumeInfo? {
        val volumeInfoType = object : TypeToken<VolumeInfo?>(){}.type
        return Gson().fromJson(jsonString,volumeInfoType)
    }
}