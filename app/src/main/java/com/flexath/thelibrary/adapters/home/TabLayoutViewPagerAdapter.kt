package com.flexath.thelibrary.adapters.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.flexath.thelibrary.fragments.home.AudioBookHomeFragment
import com.flexath.thelibrary.fragments.home.EBookHomeFragment

class TabLayoutViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                EBookHomeFragment()
            }
            else -> {
                AudioBookHomeFragment()
            }
        }
    }
}