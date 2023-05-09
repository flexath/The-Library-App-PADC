package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO

interface HomeView : IBaseView {
    fun showBooksForBanner(bookList:List<BookVO>?)
    fun showFirstCategory(category:List<CategoryVO>?)
    fun showSecondCategory(category:List<CategoryVO>?)
    fun showThirdCategory(category:List<CategoryVO>?)

    fun navigateToBookDetailScreen(bookName:String,listId:Int)
    fun navigateToBookListScreen(listName:String,listId: Int)
    fun onTapOptionButtonOnBook(book: BookVO?)
}