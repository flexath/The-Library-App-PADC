package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.delegates.home.BannerHomeViewHolderDelegate
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.mvp.views.HomeView

interface HomePresenter : IBasePresenter, BannerHomeViewHolderDelegate, BookHomeViewHolderDelegate {

    fun initView(view: HomeView)
    fun onTapGoToBookListScreen(listName:String)

}