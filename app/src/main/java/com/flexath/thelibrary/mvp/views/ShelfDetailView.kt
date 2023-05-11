package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.overview.BookVO

interface ShelfDetailView : IBaseView {
    fun showBottomSheetDialogForShelfTitle()
    fun showBottomSheetDialogForFiltering()
    fun showBottomSheetDialogForSorting()

    fun showShelfDetail(shelfVO: ShelfVO?)

    fun navigateBackToPreviousScreen()
    fun onTapCrossButton()
    fun onTapChip(listName: String)
}