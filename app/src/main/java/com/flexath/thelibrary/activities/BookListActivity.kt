package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookListAdapter
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.mvp.presenters.BookListPresenter
import com.flexath.thelibrary.mvp.presenters.BookListPresenterImpl
import com.flexath.thelibrary.mvp.views.BookListView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.toolbar_book_list.*
import java.util.*

class BookListActivity : AppCompatActivity() , BookListView {

    // Adapters
    private lateinit var mBookListAdapter: BookListAdapter

    // Presenters
    private lateinit var mPresenter:BookListPresenter

    // General
    private lateinit var mListName:String

    companion object {
        private const val EXTRA_LIST_NAME = "Category Name"
        private const val EXTRA_BOOK_TYPE = "Book Type"
        private const val EXTRA_LIST_ID = "Category Id"

        fun newIntent(context: Context,listName:String,type:Int,listId: Int) : Intent {
            val intent = Intent(context,BookListActivity::class.java)
            intent.putExtra(EXTRA_LIST_NAME,listName)
            intent.putExtra(EXTRA_BOOK_TYPE,type)
            intent.putExtra(EXTRA_LIST_ID,listId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        setUpPresenter()
        setUpListeners()

        setUpBookListRecyclerView()

        mListName = intent.extras?.getString(EXTRA_LIST_NAME,"") ?: ""
        tvTitleToolbarBookList.text = mListName

        mPresenter.onUiReadyForBookList(this,
            mListName.lowercase(Locale.ROOT).replace(' ','-',ignoreCase = true))
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
        val type = intent.getIntExtra(EXTRA_LIST_NAME,0)
        mBookListAdapter = BookListAdapter(type,mPresenter)
        rvBookList.adapter = mBookListAdapter
        rvBookList.layoutManager = GridLayoutManager(this,2)
    }

    override fun showBookList(bookList: List<BookListResultVO>) {
        mBookListAdapter.setData(bookList)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.deleteTheWholeBookList()
    }

    override fun navigateToBookDetailScreen(bookName:String,listId:Int) {
        startActivity(BookDetailActivity.newIntent(this,bookName,listId,"BookListActivity"))
    }

    override fun onTapOptionButtonOnBook() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_book_option)
        dialog.show()
    }

    override fun navigateBack() {
        finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show()
    }
}