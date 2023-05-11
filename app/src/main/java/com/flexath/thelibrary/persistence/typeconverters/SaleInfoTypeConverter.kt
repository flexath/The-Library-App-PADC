package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.google.AccessInfo
import com.flexath.thelibrary.data.vos.google.SaleInfo
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SaleInfoTypeConverter {
    @TypeConverter
    fun toString(saleInfo: SaleInfo?) :String {
        return Gson().toJson(saleInfo)
    }

    @TypeConverter
    fun toSaleInfo(jsonString:String) : SaleInfo? {
        val saleInfoType = object : TypeToken<SaleInfo?>(){}.type
        return Gson().fromJson(jsonString,saleInfoType)
    }
}