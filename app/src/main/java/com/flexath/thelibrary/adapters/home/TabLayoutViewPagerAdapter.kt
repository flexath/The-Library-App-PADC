package com.flexath.thelibrary.adapters.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.flexath.thelibrary.fragments.home.AudioBookHomeFragment
import com.flexath.thelibrary.fragments.home.EBookHomeFragment
import com.flexath.thelibrary.mvp.presenters.HomePresenter

class TabLayoutViewPagerAdapter(fragment: Fragment,private val mPresenter: HomePresenter) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                EBookHomeFragment(mPresenter)
            }
            else -> {
                AudioBookHomeFragment(mPresenter)
            }
        }
    }
}