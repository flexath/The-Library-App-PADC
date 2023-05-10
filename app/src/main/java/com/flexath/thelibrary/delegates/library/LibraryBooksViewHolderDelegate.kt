package com.flexath.thelibrary.delegates.library

import com.flexath.thelibrary.data.vos.overview.BookVO

interface LibraryBooksViewHolderDelegate {
    fun onTapBook(bookName:String,listId:Int)
    fun onTapOptionButtonOnBook(book:BookVO)
}