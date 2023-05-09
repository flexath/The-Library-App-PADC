package com.flexath.thelibrary.adapters.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.flexath.thelibrary.fragments.library.YourBooksLibraryFragment
import com.flexath.thelibrary.fragments.library.YourShelvesLibraryFragment

class LibraryTabLayoutViewPagerAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                YourBooksLibraryFragment(fragment)
            }
            else -> {
                YourShelvesLibraryFragment()
            }
        }
    }

}