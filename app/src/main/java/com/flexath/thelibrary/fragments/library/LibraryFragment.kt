package com.flexath.thelibrary.fragments.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexath.thelibrary.R
import com.flexath.thelibrary.activities.NewShelfActivity
import com.flexath.thelibrary.adapters.home.LibraryTabLayoutViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {

    private lateinit var mTabLayoutViewPagerAdapter: LibraryTabLayoutViewPagerAdapter

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
        setUpListeners()
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

    private fun setUpListeners() {
        tabLayoutLibrary.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    btnCreateNewShelf.visibility = View.GONE
                } else {
                    btnCreateNewShelf.visibility = View.VISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        btnCreateNewShelf.setOnClickListener {
            startActivity(NewShelfActivity.newIntent(requireActivity()))
        }
    }
}