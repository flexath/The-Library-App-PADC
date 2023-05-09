package com.flexath.thelibrary.mvp.views

import com.flexath.thelibrary.data.vos.ShelfVO

interface AddToShelvesView : IBaseView {

    fun showShelfList(shelfList:List<ShelfVO>)

    fun onClickCheckBox(shelfId:Int,checked:Boolean)
}