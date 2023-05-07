package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookSearchAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_book_search.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar_search_activity.*

class BookSearchActivity : AppCompatActivity() {

    // Adapters
    private lateinit var mAdapter:BookSearchAdapter

    private val mTabTitleList = listOf("Ebooks","Audiobooks")

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BookSearchActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_search)

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        etSearchActivity.requestFocus()
        inputMethodManager.showSoftInput(etSearchActivity, InputMethodManager.SHOW_IMPLICIT)

        setUpTabLayoutWithViewPager()
        setUpListeners()
        setUpRecyclerView()
    }

    private fun setUpTabLayoutWithViewPager() {
        mTabTitleList.forEach {
            tabLayoutSearch.newTab().apply {
                text = it
                tabLayoutSearch.addTab(this)
            }
        }
    }

    private fun setUpListeners() {
        tabLayoutSearch.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                if(tab?.position == 0) {

                } else {

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun setUpRecyclerView() {
        mAdapter = BookSearchAdapter()
        rvSearch.adapter = mAdapter
        rvSearch.layoutManager = LinearLayoutManager(this)
    }
}