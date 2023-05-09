package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.flexath.thelibrary.mvp.views.ShelfDetailView

interface ShelfDetailPresenter : IBasePresenter {

    fun initView(view: ShelfDetailView)
    fun onUiReadyForShelfDetail(owner: LifecycleOwner,shelfId:Int)

    fun deleteShelf(shelfId: Int)

    fun onTapBackButton()
    fun onTapOptionButton()
    fun onTapFilterButton()
    fun onTapSortButton()
}