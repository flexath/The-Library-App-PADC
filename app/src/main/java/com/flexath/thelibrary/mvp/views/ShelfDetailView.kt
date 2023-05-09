package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.ShelfVO

interface ShelfDetailView : IBaseView {
    fun showBottomSheetDialogForShelfTitle()
    fun showBottomSheetDialogForFiltering()
    fun showBottomSheetDialogForSorting()

    fun showShelfDetail(shelfVO: ShelfVO?)

    fun navigateBackToPreviousScreen()
}