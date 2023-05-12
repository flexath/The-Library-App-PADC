package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.mvp.views.NewShelfView

interface NewShelfPresenter : IBasePresenter {

    fun initView(view: NewShelfView)
    fun insertShelf(shelf:ShelfVO)

    fun onTapBackButton()
}