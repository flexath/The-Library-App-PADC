package com.flexath.thelibrary.fragments.library

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.flexath.thelibrary.R
import com.flexath.thelibrary.activities.AddToShelvesActivity
import com.flexath.thelibrary.activities.BookDetailActivity
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.mvp.presenters.YourBooksLibraryPresenter
import com.flexath.thelibrary.mvp.presenters.YourBooksLibraryPresenterImpl
import com.flexath.thelibrary.mvp.views.YourBooksLibraryView
import com.flexath.thelibrary.views.viewpods.LibraryBooksViewPod
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_dialog_book_filter.*
import kotlinx.android.synthetic.main.bottom_dialog_book_option.*
import kotlinx.android.synthetic.main.bottom_dialog_book_sort.*
import kotlinx.android.synthetic.main.fragment_your_books_library.*
import kotlinx.android.synthetic.main.viewpod_books_library.*

class YourBooksLibraryFragment : Fragment() , YourBooksLibraryView , LibraryBooksViewHolderDelegate {

    private lateinit var mLibraryBooksViewPod:LibraryBooksViewPod
    private lateinit var mPresenter: YourBooksLibraryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_your_books_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpViewPodInstances()
        setUpListeners()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(requireActivity())[YourBooksLibraryPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPodInstances() {
        mLibraryBooksViewPod = vpBooksLibrary as LibraryBooksViewPod
        mLibraryBooksViewPod.setDelegate(1,this)
    }

    private fun setUpListeners() {
        btnFilterBooks.setOnClickListener {
            mPresenter.onTapFilterButton()
        }

        btnSortByLibrary.setOnClickListener {
            mPresenter.onTapSortButton()
        }
    }

    override fun showBottomSheetDialogForFiltering() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_filter)
        dialog.show()

        dialog.rbList.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(1,this)
                dialog.dismiss()
            }
        }

        dialog.rbLargeGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(2,this)
                dialog.dismiss()
            }
        }

        dialog.rbSmallGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(3,this)
                dialog.dismiss()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun showBottomSheetDialogForSorting() {
        val dialog = BottomSheetDialog(requireActivity())
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

    override fun showError(error: String) {
        Toast.makeText(requireActivity(),error,Toast.LENGTH_SHORT).show()
    }

    override fun onTapBook(bookName: String, listId: Int) {
        startActivity(BookDetailActivity.newIntent(requireActivity(),bookName,listId,""))
    }

    override fun onTapOptionButtonOnBook() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_option)
        dialog.show()

        dialog.btnDownloadBottomSheet.setOnClickListener {
            Toast.makeText(requireActivity(),"Downloading",Toast.LENGTH_SHORT).show()
        }

        dialog.btnDeleteBottomSheet.setOnClickListener {
            Toast.makeText(requireActivity(),"Deleted from your library",Toast.LENGTH_SHORT).show()
        }

        dialog.btnAddToLibraryBottomSheet.setOnClickListener {
            Toast.makeText(requireActivity(),"Added to your library",Toast.LENGTH_SHORT).show()
        }

        dialog.btnAddToShelvesBottomSheet.setOnClickListener {
            startActivity(AddToShelvesActivity.newIntent(requireActivity()))
            dialog.dismiss()
        }

        dialog.btnMarkAsReadBottomSheet.setOnClickListener {
            Toast.makeText(requireActivity(),"Marks as read",Toast.LENGTH_SHORT).show()
        }

        dialog.btnAboutThisBookBottomSheet.setOnClickListener {
            Toast.makeText(requireActivity(),"About this ebook",Toast.LENGTH_SHORT).show()
        }
    }
}