package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.mvp.views.BookDetailView

interface BookDetailPresenter : IBasePresenter {

    fun initView(view:BookDetailView)
    fun onUiReadyForBookDetail(owner: LifecycleOwner,listName:String,listId:Int,previousPlace:String)

    fun insertBookIntoLibrary(book:BookVO?)

    fun onTapBackButton()
    fun onTapAboutEBookButton()
    fun onTapRatingAndReviewButton()
}