package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.mvp.views.HomeView

class HomePresenterImpl : ViewModel(), HomePresenter  {

    private var mView:HomeView? = null
    private val mLibraryModel:LibraryModel = LibraryModelImpl

    override fun initView(view: HomeView) {
        mView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mLibraryModel.getBookOverview { error ->
            mView?.showError(error)
        }?.observe(owner) {
            mView?.showFirstCategory(it ?: listOf())
        }

        mLibraryModel.getBookOverview { error ->
            mView?.showError(error)
        }?.observe(owner) {
            mView?.showSecondCategory(it ?: listOf())
        }

        mLibraryModel.getBookOverview { error ->
            mView?.showError(error)
        }?.observe(owner) {
            mView?.showThirdCategory(it ?: listOf())
        }
    }

    override fun onTapBookFromBanner(bookName:String,listId:Int) {
        mView?.navigateToBookDetailScreen(bookName,listId)
    }

    override fun onTapBook(bookName:String,listId:Int) {
        mView?.navigateToBookDetailScreen(bookName,listId)
    }

    override fun onTapOptionButtonFromBanner() {
        mView?.onTapOptionButtonOnBook()
    }

    override fun onTapOptionButtonOnBook() {
        mView?.onTapOptionButtonOnBook()
    }

    override fun onTapGoToBookListScreen(listName:String, listInt: Int) {
        mView?.navigateToBookListScreen(listName,listInt)
    }
}