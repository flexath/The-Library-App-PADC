package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.mvp.views.AddToShelvesView

class AddToShelvesPresenterImpl : ViewModel() , AddToShelvesPresenter {

    private var mView:AddToShelvesView? = null
    private val mLibraryModel:LibraryModel = LibraryModelImpl

    override fun initView(view: AddToShelvesView) {
        mView = view
    }

    override fun onUiReadyForAddToShelves(owner: LifecycleOwner, title: String) {
        mLibraryModel.getShelfList()?.observe(owner) {
            mView?.showShelfList(it ?: listOf())
        }

        mLibraryModel.getBookByTitle(title)?.observe(owner) {
            mView?.showBook(it)
        }
    }

    override fun onTapCloseButton() {
        mView?.closeAddToShelvesActivity()
    }

    override fun updateShelf(shelf: ShelfVO) {
        mLibraryModel.updateShelf(shelf)
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapCheckBox(shelfId: Int,checked:Boolean) {
        mView?.onClickCheckBox(shelfId,checked)
    }
}