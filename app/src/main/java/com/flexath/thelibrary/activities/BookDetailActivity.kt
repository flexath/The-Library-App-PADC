package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookRatingAndReviewAdapter
import com.flexath.thelibrary.mvp.presenters.BookDetailPresenter
import com.flexath.thelibrary.mvp.presenters.BookDetailPresenterImpl
import com.flexath.thelibrary.mvp.views.BookDetailView
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() , BookDetailView {

    private lateinit var mAdapter:BookRatingAndReviewAdapter

    // Presenter
    private lateinit var mPresenter:BookDetailPresenter

    companion object {
        private const val EXTRA_BOOK_ID = "Book Id"

        fun newIntent(context: Context,bookId:Int) : Intent {
            val intent = Intent(context,BookDetailActivity::class.java)
            intent.putExtra(EXTRA_BOOK_ID,bookId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        setUpPresenter()
        setUpReviewRecyclerView()
        setUpListeners()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[BookDetailPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpReviewRecyclerView() {
        mAdapter = BookRatingAndReviewAdapter()
        rvReview.adapter = mAdapter
        rvReview.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpListeners() {
        btnForwardBookDetail.setOnClickListener {
            mPresenter.onTapAboutEBookButton()
        }

        btnForwardRatingBookDetail.setOnClickListener {
            mPresenter.onTapRatingAndReviewButton()
        }
    }

    override fun navigateToRatingAndReviewScreen() {
        startActivity(BookRatingAndReviewActivity.newIntent(this))
    }

    override fun navigateToAboutEBookScreen() {
        startActivity(AboutEBookActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show()
    }
}