package com.flexath.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.home.BookSearchAdapter
import com.flexath.thelibrary.data.models.LibraryModel
import com.flexath.thelibrary.data.models.LibraryModelImpl
import com.flexath.thelibrary.data.vos.SearchBookVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BookSearchViewHolderDelegate
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.google.android.material.tabs.TabLayout
import com.jakewharton.rxbinding4.widget.textChanges
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_book_search.*
import kotlinx.android.synthetic.main.toolbar_search_activity.*
import java.util.concurrent.TimeUnit

class BookSearchActivity : AppCompatActivity(), LibraryBooksViewHolderDelegate {

    // Adapters
    private lateinit var mAdapter:BookSearchAdapter

    // Model
    private val mModel:LibraryModel = LibraryModelImpl

    // Generals
    private val mTabTitleList = listOf("Ebooks","Audiobooks")
    private var mBookList:List<BookVO> = listOf()

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, BookSearchActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_search)

//        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        etSearch.requestFocus()
//        inputMethodManager.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT)

        setUpTabLayoutWithViewPager()
        setUpRecyclerView()

        setUpListeners()
    }

    private fun setUpTabLayoutWithViewPager() {
        mTabTitleList.forEach {
            tabLayoutSearch.newTab().apply {
                text = it
                tabLayoutSearch.addTab(this)
            }
        }
    }

    @SuppressLint("CheckResult")
    private fun setUpListeners() {
        tabLayoutSearch.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                mAdapter.setData(mBookList)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        etSearch.textChanges()
            .debounce(500L,TimeUnit.MILLISECONDS)
            .flatMap {
                mModel.searchBookFromGoogle(it.toString())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ bookList ->
                mBookList = bookList
                mAdapter.setData(bookList)
                mModel.deleteSearchBookList()
                for(book in bookList) {
                    val title = book.title
                    val author = book.author
                    val description = book.description
                    val image = book.bookImage
                    val searchBook = SearchBookVO(title,author,description,image)
                    mModel.insertBookIntoSearchTable(searchBook)
                }
            },{
                Toast.makeText(this,it.localizedMessage, Toast.LENGTH_SHORT).show()
            })
    }

    private fun setUpRecyclerView() {
        mAdapter = BookSearchAdapter(this)
        rvSearch.adapter = mAdapter
        rvSearch.layoutManager = LinearLayoutManager(this)
    }

    override fun onTapBook(bookName: String, listId: Int) {
        startActivity(BookDetailActivity.newIntent(this,bookName,listId,"BookSearchActivity"))
    }

    override fun onTapOptionButtonOnBook(book: BookVO) {

    }
}