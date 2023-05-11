package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.overview.BookVO

interface YourBooksLibraryView : IBaseView {

    fun showBooksInLibrary(bookList:List<BookVO>?)
    fun showBookListByListName(bookList: List<BookVO>?)

    fun showBottomSheetDialogForFiltering()
    fun showBottomSheetDialogForSorting()

    fun onTapChip(listName: String)
    fun onTapCrossButton()
}