package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookListAdapter
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,BookListActivity::class.java)
        }
    }

    private lateinit var mBookListAdapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setUpBookListRecyclerView()
    }

    private fun setUpBookListRecyclerView() {
        mBookListAdapter = BookListAdapter()
        rvBookList.adapter = mBookListAdapter
        rvBookList.layoutManager = GridLayoutManager(this,2)
    }
}