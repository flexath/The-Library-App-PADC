package com.flexath.thelibrary.persistence.typeconverters

import androidx.room.TypeConverter
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.list.IsbnVO
import com.flexath.thelibrary.data.vos.list.ReviewVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReviewVOTypeConverter {

    @TypeConverter
    fun toString(reviewList: List<ReviewVO>?): String {
        return Gson().toJson(reviewList)
    }

    @TypeConverter
    fun toReviewVO(jsonString: String): List<ReviewVO>? {
        val reviewType = object : TypeToken<List<ReviewVO>?>() {}.type
        return Gson().fromJson(jsonString, reviewType)
    }
}