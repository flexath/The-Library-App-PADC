package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.data.vos.overview.BuyLinkVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BuyLinkTypeConverter {
    @TypeConverter
    fun toString(buyLinkList: List<BuyLinkVO>?) :String {
        return Gson().toJson(buyLinkList)
    }

    @TypeConverter
    fun toBuyLink(jsonString:String) : List<BuyLinkVO>? {
        val buyLinkType = object : TypeToken<List<BuyLinkVO>?>(){}.type
        return Gson().fromJson(jsonString,buyLinkType)
    }
}