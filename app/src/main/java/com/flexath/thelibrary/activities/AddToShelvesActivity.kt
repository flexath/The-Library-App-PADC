package com.flexath.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.library.AddToShelvesAdapter
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.mvp.presenters.AddToShelvesPresenter
import com.flexath.thelibrary.mvp.presenters.AddToShelvesPresenterImpl
import com.flexath.thelibrary.mvp.views.AddToShelvesView
import kotlinx.android.synthetic.main.activity_add_to_shelves.*

class AddToShelvesActivity : AppCompatActivity() , AddToShelvesView {

    // Adapters
    private lateinit var mAdapter: AddToShelvesAdapter

    // Presenters
    private lateinit var mPresenter: AddToShelvesPresenter

    // Generals
    private var mShelfList:MutableList<ShelfVO> = mutableListOf()
    private var mBookTitle:String = ""
    private var mBook: BookVO? = null
    private var mIsChecked = false

    companion object {
        private const val EXTRA_BOOK_TITLE = "BOOK TITLE"
        fun newIntent(context: Context, title:String) : Intent {
            val intent = Intent(context,AddToShelvesActivity::class.java)
            intent.putExtra(EXTRA_BOOK_TITLE,title)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_shelves)

        mBookTitle = intent?.extras?.getString(EXTRA_BOOK_TITLE,"") ?: ""

        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUiReadyForAddToShelves(this,mBookTitle)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[AddToShelvesPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView() {
        mAdapter = AddToShelvesAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this)
        rvAddToShelves.layoutManager = linearLayoutManager
        rvAddToShelves.adapter = mAdapter

        val divider = DividerItemDecoration(this, linearLayoutManager.orientation)
        rvAddToShelves.addItemDecoration(divider)
        mAdapter.notifyDataSetChanged()
    }

    override fun showShelfList(shelfList: List<ShelfVO>) {
        mShelfList = shelfList as MutableList<ShelfVO>

        for(shelf in mShelfList) {
            for(book in shelf.bookList!!) {
                shelf.isChecked = mBookTitle == book.title
            }
        }
        mAdapter.setNewData(mShelfList)
    }

    override fun showBook(book: BookVO?) {
        mBook = book
    }

    override fun onClickCheckBox(shelfId: Int,checked:Boolean) {
        for(shelf in mShelfList) {
            if(shelfId == shelf.Id) {
                if(checked) {
                    shelf.isChecked = true
                    mBook?.let { shelf.bookList?.add(it) }
                    shelf.bookCount = shelf.bookList?.size
                    val shelfVO = ShelfVO(shelfId,shelf.shelfName,shelf.bookCount,shelf.bookList,shelf.isChecked)
                    mPresenter.updateShelf(shelfVO)
                    break
                }else {
                    shelf.isChecked = false
                    mBook?.let { shelf.bookList?.remove(it) }
                    shelf.bookCount = shelf.bookList?.size
                    val shelfVO = ShelfVO(shelf.Id,shelf.shelfName,shelf.bookCount,shelf.bookList,shelf.isChecked)
                    mPresenter.updateShelf(shelfVO)
                    break
                }

            }
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }
}