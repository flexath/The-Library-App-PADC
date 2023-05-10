package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.mvp.views.YourBooksLibraryView

interface YourBooksLibraryPresenter : IBasePresenter {

    fun initView(view:YourBooksLibraryView)

    fun deleteBookByTitle(title:String)

    fun onTapFilterButton()
    fun onTapSortButton()
}