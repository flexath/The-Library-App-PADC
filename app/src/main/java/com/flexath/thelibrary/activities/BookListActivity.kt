package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookListAdapter
import com.flexath.thelibrary.mvp.presenters.BookListPresenter
import com.flexath.thelibrary.mvp.presenters.BookListPresenterImpl
import com.flexath.thelibrary.mvp.views.BookListView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.layout_book_type_toolbar.*

class BookListActivity : AppCompatActivity() , BookListView {

    private lateinit var mBookListAdapter: BookListAdapter
    private lateinit var mPresenter:BookListPresenter

    companion object {
        private const val EXTRA_BOOK_TYPE = "Book Type"

        fun newIntent(context: Context,type:Int) : Intent {
            val intent = Intent(context,BookListActivity::class.java)
            intent.putExtra(EXTRA_BOOK_TYPE,type)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setUpPresenter()
        setUpListeners()
        setUpBookListRecyclerView()
    }

    private fun setUpPresenter() {
        mPresenter =  ViewModelProvider(this)[BookListPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpListeners() {
        btnBackBookList.setOnClickListener {
            mPresenter.onTapBack()
        }
    }

    private fun setUpBookListRecyclerView() {
        val type = intent.getIntExtra(EXTRA_BOOK_TYPE,0)
        mBookListAdapter = BookListAdapter(type,mPresenter)
        rvBookList.adapter = mBookListAdapter
        rvBookList.layoutManager = GridLayoutManager(this,2)
    }

    override fun navigateToBookDetailScreen(bookId: Int) {
        startActivity(BookDetailActivity.newIntent(this,bookId))
    }

    override fun onTapOptionButtonOnBook() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.layout_book_list_option_bottom_dialog)
        dialog.show()
    }

    override fun navigateBack() {
        finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show()
    }
}