package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.ListNameChipDelegate
import com.flexath.thelibrary.mvp.views.YourBooksLibraryView
import com.google.android.material.bottomsheet.BottomSheetDialog

interface YourBooksLibraryPresenter : IBasePresenter , ListNameChipDelegate {

    fun initView(view:YourBooksLibraryView)
    fun onUiReadyForListName(owner: LifecycleOwner,listName:String)

    fun deleteBookByTitle(title:String)
    fun sortByTitle() : List<BookVO>?
    fun sortByAuthor() : List<BookVO>?

    fun onTapFilterButton()
    fun onTapSortButton()
    fun onTapCrossButton()
}