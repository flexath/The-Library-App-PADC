package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.list.BookListResultVO

interface BookListView : IBaseView {

    fun showBookList(bookList:List<BookListResultVO>)

    fun navigateToBookDetailScreen(bookId:Int)
    fun onTapOptionButtonOnBook()
    fun navigateBack()
}