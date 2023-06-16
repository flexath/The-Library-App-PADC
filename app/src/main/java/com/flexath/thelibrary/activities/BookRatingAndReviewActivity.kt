package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookRatingAndReviewAdapter
import kotlinx.android.synthetic.main.activity_book_rating_and_review.rvRatingAndReviewScreen
import kotlinx.android.synthetic.main.activity_book_rating_and_review.tvTitleRatingAndReview

class BookRatingAndReviewActivity : AppCompatActivity() {

    private lateinit var mAdapter:BookRatingAndReviewAdapter

    companion object {
        private const val EXTRA_TITLE = "Book Title"
        fun newIntent(context: Context,title:String): Intent {
            val intent = Intent(context, BookRatingAndReviewActivity::class.java)
            intent.putExtra(EXTRA_TITLE,title)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_rating_and_review)

        tvTitleRatingAndReview.text = intent?.extras?.getString(EXTRA_TITLE,"No Title")
        setUpReviewRecyclerView()
    }

    private fun setUpReviewRecyclerView() {
        mAdapter = BookRatingAndReviewAdapter()
        rvRatingAndReviewScreen.adapter = mAdapter
        rvRatingAndReviewScreen.layoutManager = LinearLayoutManager(this)
    }
}