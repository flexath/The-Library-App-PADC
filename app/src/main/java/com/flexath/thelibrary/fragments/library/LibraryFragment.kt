package com.flexath.thelibrary.fragments.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.LibraryTabLayoutViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {

    private lateinit var mTabLayoutViewPagerAdapter:LibraryTabLayoutViewPagerAdapter

    private val libraryTabList = listOf("Your books", "Your shelves")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpTabLayout()
    }

    private fun setUpTabLayout() {

        mTabLayoutViewPagerAdapter = LibraryTabLayoutViewPagerAdapter(this)
        viewPagerLibrary.adapter = mTabLayoutViewPagerAdapter

        TabLayoutMediator(tabLayoutLibrary, viewPagerLibrary) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Your books"
                }
                else -> {
                    tab.text = "Your shelves"
                }
            }
        }.attach()
    }
}