package com.flexath.thelibrary.delegates.home

import com.flexath.thelibrary.data.vos.overview.BookVO

interface BookHomeViewHolderDelegate {
    fun onTapBook(bookName:String,listId:Int)
    fun onTapOptionButtonOnBook(book: BookVO?)
}