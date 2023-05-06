package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO

interface BookDetailView : IBaseView {

    fun getCategoryByName(category: CategoryVO)
    fun getBookFromBookList(bookDetail: BookDetailVO)
    fun navigateToRatingAndReviewScreen()
    fun navigateToAboutEBookScreen()
}