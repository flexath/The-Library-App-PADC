package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookRatingAndReviewAdapter
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.activity_book_rating_and_review.*

class BookRatingAndReviewActivity : AppCompatActivity() {

    private lateinit var mAdapter:BookRatingAndReviewAdapter

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BookRatingAndReviewActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_rating_and_review)

        setUpReviewRecyclerView()
    }

    private fun setUpReviewRecyclerView() {
        mAdapter = BookRatingAndReviewAdapter()
        rvRatingAndReviewScreen.adapter = mAdapter
        rvRatingAndReviewScreen.layoutManager = LinearLayoutManager(this)
    }
}