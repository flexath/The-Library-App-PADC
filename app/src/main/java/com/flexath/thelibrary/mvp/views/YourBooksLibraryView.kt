package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.overview.BookVO

interface YourBooksLibraryView : IBaseView {

    fun showBooksInLibrary(bookList:List<BookVO>?)

    fun showBottomSheetDialogForFiltering()
    fun showBottomSheetDialogForSorting()
}