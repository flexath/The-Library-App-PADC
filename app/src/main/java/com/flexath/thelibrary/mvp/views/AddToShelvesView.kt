package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.overview.BookVO

interface AddToShelvesView : IBaseView {

    fun showShelfList(shelfList:List<ShelfVO>)
    fun showBook(book:BookVO?)

    fun closeAddToShelvesActivity()

    fun onClickCheckBox(shelfId:Int,checked:Boolean)
}