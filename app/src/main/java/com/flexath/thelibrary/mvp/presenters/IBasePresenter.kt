package com.flexath.thelibrary.mvp.presenters

import androidx.lifecycle.LifecycleOwner

interface IBasePresenter {
    fun onUiReady(owner:LifecycleOwner)
}