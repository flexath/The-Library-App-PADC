package com.flexath.thelibrary.mvp.presenters

import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.AddToShelvesDelegate
import com.flexath.thelibrary.mvp.views.AddToShelvesView

interface AddToShelvesPresenter : IBasePresenter,AddToShelvesDelegate {

    fun initView(view: AddToShelvesView)
    fun updateShelf(shelf:ShelfVO)
}