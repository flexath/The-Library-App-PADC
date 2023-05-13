package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.SearchBookVO
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO

interface BookDetailView : IBaseView {

    fun getCategoryByName(category: CategoryVO)
    fun getBookFromBookList(bookDetail: BookDetailVO)
    fun getAllBooksFromLibrary(bookList:List<BookVO>)


    fun navigateToRatingAndReviewScreen()
    fun navigateToAboutEBookScreen()
    fun navigateBackToHome()
    fun showSearchBook(bookList: List<SearchBookVO>)
}