package com.flexath.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.mvp.presenters.ShelfDetailPresenter
import com.flexath.thelibrary.mvp.presenters.ShelfDetailPresenterImpl
import com.flexath.thelibrary.mvp.views.ShelfDetailView
import com.flexath.thelibrary.views.viewpods.LibraryBooksViewPod
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_new_shelf.*
import kotlinx.android.synthetic.main.activity_shelf_detail.*
import kotlinx.android.synthetic.main.bottom_dialog_book_filter.*
import kotlinx.android.synthetic.main.bottom_dialog_book_option.*
import kotlinx.android.synthetic.main.bottom_dialog_book_sort.*
import kotlinx.android.synthetic.main.bottom_dialog_shelf_detail.*
import kotlinx.android.synthetic.main.toolbar_shelf_detail.*
import kotlinx.android.synthetic.main.viewpod_books_library.*

class ShelfDetailActivity : AppCompatActivity() , ShelfDetailView , LibraryBooksViewHolderDelegate {

    // ViewPods
    private lateinit var mViewPod: LibraryBooksViewPod

    // Presenters
    private lateinit var mPresenter: ShelfDetailPresenter

    // General
    private var shelfId:Int = 0
    private var mBookCount = 0
    private var mBookList:MutableList<BookVO> = mutableListOf()
    private var mIsChecked:Boolean = false
    private var mShelfName:String = ""

    companion object {
        private const val EXTRA_SHELF_ID = "Shelf Id"
        fun newIntent(context: Context,shelfId:Int) : Intent {
            val intent = Intent(context,ShelfDetailActivity::class.java)
            intent.putExtra(EXTRA_SHELF_ID,shelfId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shelf_detail)

        setUpPresenters()
        setUpViewPodInstances()
        setUpListeners()

        shelfId = intent?.extras?.getInt(EXTRA_SHELF_ID) ?: 0
        mPresenter.onUiReadyForShelfDetail(this,shelfId)
    }

    private fun setUpPresenters() {
        mPresenter = ViewModelProvider(this)[ShelfDetailPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPodInstances() {
        mViewPod = vpShelfDetail as LibraryBooksViewPod
        mViewPod.setDelegate(1,this)
    }

    private fun setUpListeners() {
        btnBackShelfDetail.setOnClickListener {
            mPresenter.onTapBackButton()
        }

        btnOptionShelfDetail.setOnClickListener {
            mPresenter.onTapOptionButton()
        }

        btnFilterBooks.setOnClickListener {
            mPresenter.onTapFilterButton()
        }

        btnSortByLibrary.setOnClickListener {
            mPresenter.onTapSortButton()
        }
    }

    override fun showBottomSheetDialogForShelfTitle() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_shelf_detail)
        dialog.show()

        dialog.btnRenameShelfBottomSheet.setOnClickListener {
            dialog.dismiss()
            etShelfNameShelfDetail.visibility = View.VISIBLE

            val netEtShelfName = tvShelfNameShelfDetail.text.toString()
            tvShelfNameShelfDetail.visibility = View.GONE

            etShelfNameShelfDetail.setText(netEtShelfName)

            etShelfNameShelfDetail.setOnEditorActionListener { _, actionId, _ ->
                if(actionId == EditorInfo.IME_ACTION_DONE) {
                    val etShelfName = etShelfNameShelfDetail.text.toString()
                    val shelf = ShelfVO(shelfId,etShelfName,mBookCount,mBookList,mIsChecked)
                    mPresenter.updateShelf(shelf)
                    finish()
                    true
                } else {
                    false
                }
            }
        }

        dialog.btnDeleteShelfBottomSheet.setOnClickListener {
            val alertDialog = MaterialAlertDialogBuilder(this,R.style.RoundedAlertDialog)
                .setTitle("Delete Shelf !")
                .setMessage("Are you sure ?")
                .setPositiveButton("Yes"){ alertDialog, _ ->
                    mPresenter.deleteShelf(shelfId)
                    dialog.dismiss()
                    alertDialog.dismiss()
                    finish()
                }
                .setNegativeButton("Cancel"){ alertDialog , _ ->
                    dialog.dismiss()
                    alertDialog.dismiss()
                }
                .create()

            alertDialog.show()
        }
    }

    override fun showBottomSheetDialogForFiltering() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_book_filter)
        dialog.show()

        dialog.rbList.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mViewPod.setDelegate(1,this)
                mViewPod.setNewData(mBookList)
                dialog.dismiss()
            }
        }

        dialog.rbLargeGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mViewPod.setDelegate(2,this)
                mViewPod.setNewData(mBookList)
                dialog.dismiss()
            }
        }

        dialog.rbSmallGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mViewPod.setDelegate(3,this)
                mViewPod.setNewData(mBookList)
                dialog.dismiss()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showBottomSheetDialogForSorting() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_book_sort)
        dialog.show()

        dialog.rbRecentlyOpened.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                tvSortingMethod.text = "Recent"
                dialog.dismiss()
            }
        }

        dialog.rbTitle.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                tvSortingMethod.text = "Title"
                dialog.dismiss()
            }
        }

        dialog.rbAuthor.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                tvSortingMethod.text = "Author"
                dialog.dismiss()
            }
        }
    }

    override fun showShelfDetail(shelfVO: ShelfVO?) {

        mBookCount = shelfVO?.bookCount ?: 0
        mBookList = shelfVO?.bookList ?: mutableListOf()
        mShelfName = shelfVO?.shelfName ?: ""

        tvShelfNameShelfDetail.text = shelfVO?.shelfName ?: ""

        var bookCount = "${shelfVO?.bookCount} books"
        if(shelfVO?.bookCount == 0) {
            bookCount = "0 book"
        }
        tvBookCountShelfDetail.text = bookCount

        shelfVO?.bookList?.let {
            mViewPod.setNewData(it)
        }
    }

    override fun navigateBackToPreviousScreen() {
        finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun onTapBook(bookName: String, listId: Int) {
        startActivity(BookDetailActivity.newIntent(this,bookName,listId,"ShelfDetailActivity"))
    }

    override fun onTapOptionButtonOnBook(book:BookVO) {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_book_option)
        dialog.show()

        dialog.btnAddToShelvesBottomSheetHome.visibility = View.GONE

        Glide.with(this)
            .load(book.bookImage)
            .into(dialog.ivCoverBottomSheetHome)

        dialog.tvTitleBottomSheet.text = book.title
        dialog.tvWriterBottomSheet.text = book.author

        dialog.btnRemoveFromShelvesBottomSheetHome.setOnClickListener {
            val alertDialog = MaterialAlertDialogBuilder(this,R.style.RoundedAlertDialog)
                .setTitle("Delete Book !")
                .setMessage("Are you sure ?")
                .setPositiveButton("Yes"){ alertDialog, _ ->
                    mBookList.remove(book)
                    mViewPod.setNewData(mBookList)

                    mBookCount = mBookList.size
                    tvBookCountShelfDetail.text = mBookCount.toString()

                    val shelf = ShelfVO(shelfId,mShelfName,mBookCount,mBookList,mIsChecked)
                    mPresenter.updateShelf(shelf)

                    dialog.dismiss()
                    alertDialog.dismiss()
                }
                .setNegativeButton("Cancel"){ alertDialog , _ ->
                    dialog.dismiss()
                    alertDialog.dismiss()
                }
                .create()

            alertDialog.show()
        }
    }
}