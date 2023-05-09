package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookRatingAndReviewAdapter
import com.flexath.thelibrary.data.vos.list.BookDetailVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import com.flexath.thelibrary.mvp.presenters.BookDetailPresenter
import com.flexath.thelibrary.mvp.presenters.BookDetailPresenterImpl
import com.flexath.thelibrary.mvp.views.BookDetailView
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() , BookDetailView {

    // Adapters
    private lateinit var mAdapter: BookRatingAndReviewAdapter

    // Presenter
    private lateinit var mPresenter: BookDetailPresenter

    // General
    private lateinit var mBookName:String

    companion object {
        private const val EXTRA_BOOK_NAME = "Book Name"
        private const val EXTRA_LIST_ID = "List Id"
        private const val EXTRA_PREVIOUS_PLACE = "Previous Place"

        fun newIntent(context: Context, bookName:String, listId:Int,previousPlace:String) : Intent {
            val intent = Intent(context,BookDetailActivity::class.java)
            intent.putExtra(EXTRA_BOOK_NAME,bookName)
            intent.putExtra(EXTRA_LIST_ID,listId)
            intent.putExtra(EXTRA_PREVIOUS_PLACE,previousPlace)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        setUpPresenter()
        setUpReviewRecyclerView()
        setUpListeners()

        mBookName = intent?.extras?.getString(EXTRA_BOOK_NAME,"") ?: ""
        val listId = intent?.extras?.getInt(EXTRA_LIST_ID,0) ?: 0
        val previousPlace = intent?.extras?.getString(EXTRA_PREVIOUS_PLACE,"") ?: ""

        mPresenter.onUiReadyForBookDetail(this,mBookName,listId,previousPlace)
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

    override fun getCategoryByName(category: CategoryVO) {
        for(book in category.books!!) {
            if(mBookName == book.title) {
                bindData(book)
                book.listId = category.listId
                book.listName = category.listName ?: ""
                mPresenter.insertBookIntoLibrary(book)
                break
            }
        }
    }

    override fun getBookFromBookList(bookDetail: BookDetailVO) {
        tvTitleBookDetail.text = bookDetail.title
        tvWriterBookDetail.text = bookDetail.author
        tvBookInfoBookDetail.text = bookDetail.description
    }

    private fun bindData(book: BookVO) {
        Glide.with(this)
            .load(book.bookImage)
            .into(ivCoverBookDetail)

        tvTitleBookDetail.text = book.title
        tvWriterBookDetail.text = book.author
        tvBookInfoBookDetail.text = book.description

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