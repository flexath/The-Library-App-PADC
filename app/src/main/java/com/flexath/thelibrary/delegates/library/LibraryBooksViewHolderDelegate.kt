package com.flexath.thelibrary.delegates.library

interface LibraryBooksViewHolderDelegate {
    fun onTapBook(bookName:String,listId:Int)
    fun onTapOptionButtonOnBook()
}