package com.flexath.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.mvp.presenters.ShelfDetailPresenter
import com.flexath.thelibrary.mvp.presenters.ShelfDetailPresenterImpl
import com.flexath.thelibrary.mvp.views.ShelfDetailView
import com.flexath.thelibrary.views.viewpods.LibraryBooksViewPod
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_shelf_detail.*
import kotlinx.android.synthetic.main.bottom_dialog_book_filter.*
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
        mViewPod.setShelfDetailDelegate(3,this)
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
                dialog.dismiss()
            }
        }

        dialog.rbLargeGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mViewPod.setDelegate(2,this)
                dialog.dismiss()
            }
        }

        dialog.rbSmallGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mViewPod.setDelegate(3,this)
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

    override fun onTapOptionButtonOnBook() {
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(R.layout.bottom_dialog_book_option)
        dialog.show()
    }
}