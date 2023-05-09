package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.mvp.views.ShelfDetailView

class ShelfDetailPresenterImpl : ViewModel() , ShelfDetailPresenter {

    private var mView:ShelfDetailView? = null
    private val mLibraryModel: LibraryModel = LibraryModelImpl

    override fun initView(view: ShelfDetailView) {
        mView = view
    }

    override fun onUiReadyForShelfDetail(owner: LifecycleOwner, shelfId: Int) {
        mLibraryModel.getShelfById(shelfId = shelfId)?.observe(owner) {
            mView?.showShelfDetail(shelfVO = it)
        }
    }

    override fun deleteShelf(shelfId: Int) {
        mLibraryModel.deleteShelf(shelfId)
    }

    override fun onTapBackButton() {
        mView?.navigateBackToPreviousScreen()
    }

    override fun onTapOptionButton() {
        mView?.showBottomSheetDialogForShelfTitle()
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