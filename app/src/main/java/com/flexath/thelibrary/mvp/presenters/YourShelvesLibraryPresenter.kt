package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.delegates.library.YourShelvesLibraryViewHolderDelegate
import com.flexath.thelibrary.mvp.views.YourShelvesLibraryView

interface YourShelvesLibraryPresenter : IBasePresenter , YourShelvesLibraryViewHolderDelegate {

    fun initView(view:YourShelvesLibraryView)
}