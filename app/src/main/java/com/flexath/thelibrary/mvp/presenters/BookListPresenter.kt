package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.mvp.views.BookListView

interface BookListPresenter : IBasePresenter , BookHomeViewHolderDelegate {

    fun initView(view:BookListView)
    fun onUiReadyForBookList(owner: LifecycleOwner,listName:String)
    fun deleteTheWholeBookList()
    fun onTapBack()
}