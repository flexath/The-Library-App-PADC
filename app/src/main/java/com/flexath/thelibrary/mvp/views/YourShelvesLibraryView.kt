package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.ShelfVO

interface YourShelvesLibraryView : IBaseView {

    fun showShelfList(shelfList:List<ShelfVO>)
    fun navigateToShelfDetailScreen(shelfId:Int)
}