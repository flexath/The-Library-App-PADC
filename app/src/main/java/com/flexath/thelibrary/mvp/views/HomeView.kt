package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.overview.CategoryVO

interface HomeView : IBaseView {
    fun showFirstCategory(category:List<CategoryVO>)
    fun showSecondCategory(category:List<CategoryVO>)
    fun showThirdCategory(category:List<CategoryVO>)

    fun navigateToBookDetailScreen(bookId:Int)
    fun navigateToBookListScreen(listName:String)
    fun onTapOptionButtonOnBook()
}