package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.mvp.views.YourBooksLibraryView

interface YourBooksLibraryPresenter : IBasePresenter {

    fun initView(view:YourBooksLibraryView)

    fun deleteBookByTitle(title:String)
    fun sortByTitle() : List<BookVO>?
    fun sortByAuthor() : List<BookVO>?

    fun onTapFilterButton()
    fun onTapSortButton()
}