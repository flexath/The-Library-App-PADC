package com.flexath.thelibrary.adapters.home

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import com.flexath.thelibrary.fragments.home.AudioBookHomeFragment
import com.flexath.thelibrary.fragments.home.EBookHomeFragment
import com.flexath.thelibrary.mvp.presenters.HomePresenter

class TabLayoutViewPagerAdapter(fragment: Fragment,private val mPresenter: HomePresenter) : FragmentStateAdapter(fragment) {

    private var mCategoryList:List<CategoryVO>? = null

    init {
        mCategoryList?.let { setData(it) }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                EBookHomeFragment(mPresenter,mCategoryList ?: listOf())
            }
            else -> {
                AudioBookHomeFragment(mPresenter)
            }
        }
    }

    fun setData(categoryList: List<CategoryVO>) {
        mCategoryList = categoryList
    }
}