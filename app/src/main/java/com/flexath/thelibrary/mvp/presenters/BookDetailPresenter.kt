package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.mvp.views.BookDetailView

interface BookDetailPresenter : IBasePresenter {

    fun initView(view:BookDetailView)
    fun onTapAboutEBookButton()
    fun onTapRatingAndReviewButton()
}