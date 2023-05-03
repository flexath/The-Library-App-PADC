package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.mvp.views.BookDetailView

class BookDetailPresenterImpl : ViewModel() , BookDetailPresenter {

    private var mView:BookDetailView? = null

    override fun initView(view: BookDetailView) {
        mView = view
    }

    override fun onTapAboutEBookButton() {
        mView?.navigateToAboutEBookScreen()
    }

    override fun onTapRatingAndReviewButton() {
        mView?.navigateToRatingAndReviewScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}