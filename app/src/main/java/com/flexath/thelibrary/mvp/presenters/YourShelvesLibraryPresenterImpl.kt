package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.mvp.views.YourShelvesLibraryView

class YourShelvesLibraryPresenterImpl : ViewModel() , YourShelvesLibraryPresenter {

    private var mView:YourShelvesLibraryView? = null
    private val mLibraryModel: LibraryModel = LibraryModelImpl

    override fun initView(view: YourShelvesLibraryView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mLibraryModel.getShelfList()?.observe(owner) {
            mView?.showShelfList(it)
        }
    }

    override fun onTapForwardButtonOnItem(shelfId: Int) {
        mView?.navigateToShelfDetailScreen(shelfId)
    }
}