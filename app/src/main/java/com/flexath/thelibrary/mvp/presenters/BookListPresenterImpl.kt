package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.mvp.views.BookListView

class BookListPresenterImpl : ViewModel() , BookListPresenter {

    private var mView:BookListView? = null
    private val mLibraryModel: LibraryModel = LibraryModelImpl

    override fun initView(view: BookListView) {
        mView = view
    }

    override fun onUiReadyForBookList(owner: LifecycleOwner, listName: String) {
        mLibraryModel.getBookList(listName = listName, onFailure = {
            mView?.showError(it)
        })?.observe(owner) {
            mView?.showBookList(it)
        }
    }

    override fun deleteTheWholeBookList() {
        mLibraryModel.deleteTheWholeBookList()
    }

    override fun onTapBack() {
        mView?.navigateBack()
    }

    override fun onUiReady(owner: LifecycleOwner) {}

    override fun onTapBook(bookName:String,listId:Int) {
        mView?.navigateToBookDetailScreen(bookName,listId)
    }

    override fun onTapOptionButtonOnBook(book: BookVO?, mListId: Int, mListName: String) {
        mView?.onTapOptionButtonOnBook()
    }

}