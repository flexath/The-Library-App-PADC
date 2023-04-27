package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter  {

    private var mView:HomeView?  = null

    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapAudioBook(bookId: Int) {
        mView?.navigateToBookDetailScreen(bookId)
    }

    override fun onTapEBook(bookId: Int) {
        mView?.navigateToBookDetailScreen(bookId)
    }
}