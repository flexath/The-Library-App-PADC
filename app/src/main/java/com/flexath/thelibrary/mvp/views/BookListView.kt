package com.flexath.thelibrary.mvp.views

interface BookListView : IBaseView {
    fun navigateToBookDetailScreen(bookId:Int)
    fun onTapOptionButtonOnBook()
    fun navigateBack()
}