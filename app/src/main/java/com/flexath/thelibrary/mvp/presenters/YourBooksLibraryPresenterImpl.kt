package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.mvp.views.YourBooksLibraryView

class YourBooksLibraryPresenterImpl : ViewModel() , YourBooksLibraryPresenter {

    private var mView:YourBooksLibraryView? = null
    private val mLibraryModel: LibraryModel = LibraryModelImpl

    override fun initView(view: YourBooksLibraryView) {
        mView = view
    }

    override fun deleteBookByTitle(title: String) {
        mLibraryModel.deleteBookByTitle(title)
    }

    override fun onTapFilterButton() {
        mView?.showBottomSheetDialogForFiltering()
    }

    override fun onTapSortButton() {
        mView?.showBottomSheetDialogForSorting()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mLibraryModel.getAllBooksFromLibrary()?.observe(owner) {
            mView?.showBooksInLibrary(it ?: listOf())
        }
    }
}