package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.mvp.views.BookSearchView

interface BookSearchPresenter : IBasePresenter {

    fun initView(view:BookSearchView)
//    fun searchBookFromGoogle(query:String)
}