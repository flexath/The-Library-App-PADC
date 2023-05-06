package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.mvp.views.YourBooksLibraryView

class YourBooksLibraryPresenterImpl : ViewModel() , YourBooksLibraryPresenter {

    private var mView:YourBooksLibraryView? = null

    override fun initView(view: YourBooksLibraryView) {
        mView = view
    }

    override fun onTapFilterButton() {
        mView?.showBottomSheetDialogForFiltering()
    }

    override fun onTapSortButton() {
        mView?.showBottomSheetDialogForSorting()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}