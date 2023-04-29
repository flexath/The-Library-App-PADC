package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.mvp.views.BookListView

class BookListPresenterImpl : ViewModel() , BookListPresenter {

    private var mView:BookListView? = null

    override fun initView(view: BookListView) {
        mView = view
    }

    override fun onTapBack() {
        mView?.navigateBack()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapBook(bookId: Int) {
        mView?.navigateToBookDetailScreen(bookId)
    }

    override fun onTapOptionButtonOnBook() {
        mView?.onTapOptionButtonOnBook()
    }

}