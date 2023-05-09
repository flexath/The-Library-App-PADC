package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.mvp.views.NewShelfView

class NewShelfPresenterImpl : ViewModel() , NewShelfPresenter {

//    private var mView:NewShelfView? = null
    private val mLibraryModel: LibraryModel = LibraryModelImpl

    override fun initView(view: NewShelfView) {
//        mView = view
    }

    override fun insertShelf(shelf: ShelfVO) {
        mLibraryModel.insertShelf(shelf)
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}