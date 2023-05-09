package com.flexath.thelibrary.delegates.home

import com.flexath.thelibrary.data.vos.overview.BookVO

interface BannerHomeViewHolderDelegate {
    fun onTapBookFromBanner(bookName:String,listId:Int)
    fun onTapOptionButtonFromBanner(book: BookVO?)
}