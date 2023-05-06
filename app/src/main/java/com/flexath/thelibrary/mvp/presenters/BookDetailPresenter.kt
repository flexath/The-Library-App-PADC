package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.mvp.views.BookDetailView

interface BookDetailPresenter : IBasePresenter {

    fun initView(view:BookDetailView)
    fun onUiReadyForBookDetail(owner: LifecycleOwner,listName:String,listId:Int,previousPlace:String)
    fun onTapAboutEBookButton()
    fun onTapRatingAndReviewButton()
}