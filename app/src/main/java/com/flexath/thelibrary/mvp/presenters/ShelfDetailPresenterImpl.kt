package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.mvp.views.ShelfDetailView

class ShelfDetailPresenterImpl : ViewModel() , ShelfDetailPresenter {

    private var mView:ShelfDetailView? = null
    private val mLibraryModel: LibraryModel = LibraryModelImpl

    private var mBookList:List<BookVO> = listOf()

    override fun initView(view: ShelfDetailView) {
        mView = view
    }

    override fun onUiReadyForShelfDetail(owner: LifecycleOwner, shelfId: Int) {
        mLibraryModel.getShelfById(shelfId = shelfId)?.observe(owner) {
            mBookList = it.bookList ?: listOf()
            mView?.showShelfDetail(shelfVO = it)
        }
    }

    override fun deleteShelf(shelfId: Int) {
        mLibraryModel.deleteShelf(shelfId)
    }

    override fun updateShelf(shelf: ShelfVO) {
        mLibraryModel.updateShelf(shelf)
    }

    override fun removeBook(title: String) {
        mLibraryModel.deleteBookByTitle(title)
    }

    override fun sortByTitle(): List<BookVO> {
        return mBookList.sortedBy { book ->
            book.title
        }
    }

    override fun sortByAuthor(): List<BookVO> {
        return mBookList.sortedBy { book ->
            book.author
        }
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

    override fun onTapCrossButton() {
        mView?.onTapCrossButton()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapChip(listName: String) {
        mView?.onTapChip(listName)
    }
}