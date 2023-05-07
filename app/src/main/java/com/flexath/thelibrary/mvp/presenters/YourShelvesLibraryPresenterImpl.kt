package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.mvp.views.YourShelvesLibraryView

class YourShelvesLibraryPresenterImpl : ViewModel() , YourShelvesLibraryPresenter {

    private var mView:YourShelvesLibraryView? = null

    override fun initView(view: YourShelvesLibraryView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapForwardButtonOnItem(shelfId: Int) {
        mView?.navigateToNewShelfScreen(shelfId)
    }
}