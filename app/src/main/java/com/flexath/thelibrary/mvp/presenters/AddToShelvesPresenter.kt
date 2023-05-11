package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.AddToShelvesDelegate
import com.flexath.thelibrary.mvp.views.AddToShelvesView

interface AddToShelvesPresenter : IBasePresenter,AddToShelvesDelegate {

    fun initView(view: AddToShelvesView)
    fun onUiReadyForAddToShelves(owner: LifecycleOwner,title:String)

    fun onTapCloseButton()

    fun updateShelf(shelf:ShelfVO)
}