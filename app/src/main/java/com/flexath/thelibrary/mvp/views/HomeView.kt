package com.flexath.thelibrary.mvp.views

interface HomeView : IBaseView {
    fun navigateToBookDetailScreen(bookId:Int)
    fun navigateToBookListScreen()
    fun onTapOptionButtonOnBook()
}