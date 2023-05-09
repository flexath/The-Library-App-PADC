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
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.mvp.presenters.YourBooksLibraryPresenter
import com.flexath.thelibrary.mvp.presenters.YourBooksLibraryPresenterImpl
import com.flexath.thelibrary.mvp.views.YourBooksLibraryView
import com.flexath.thelibrary.views.viewpods.LibraryBooksViewPod
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.bottom_dialog_book_filter.*
import kotlinx.android.synthetic.main.bottom_dialog_book_list_option.*
import kotlinx.android.synthetic.main.bottom_dialog_book_option.*
import kotlinx.android.synthetic.main.bottom_dialog_book_sort.*
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_your_books_library.*
import kotlinx.android.synthetic.main.viewpod_books_library.*

class YourBooksLibraryFragment(private val fragment: Fragment) : Fragment() , YourBooksLibraryView , LibraryBooksViewHolderDelegate {

    // ViewPods
    private lateinit var mLibraryBooksViewPod:LibraryBooksViewPod

    // Presenters
    private lateinit var mPresenter: YourBooksLibraryPresenter

    // Generals
    private var mBookList:List<BookVO> = listOf()

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

        mPresenter.onUiReady(this)

        setUpTabLayout()
    }

    private fun setUpTabLayout() {
        fragment.tabLayoutLibrary.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    mLibraryBooksViewPod.setNewData(mBookList)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
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

    override fun showBooksInLibrary(bookList: List<BookVO>?) {
        mBookList = bookList ?: listOf()
        mLibraryBooksViewPod.setNewData(mBookList)
    }

    override fun showBottomSheetDialogForFiltering() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_filter)
        dialog.show()

        dialog.rbList.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(1,this)
                mLibraryBooksViewPod.setNewData(mBookList)
                dialog.dismiss()
            }
        }

        dialog.rbLargeGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(2,this)
                mLibraryBooksViewPod.setNewData(mBookList)
                dialog.dismiss()
            }
        }

        dialog.rbSmallGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(3,this)
                mLibraryBooksViewPod.setNewData(mBookList)
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

        dialog.btnDownloadBottomSheetHome.setOnClickListener {
            Toast.makeText(requireActivity(),"Downloading",Toast.LENGTH_SHORT).show()
        }

        dialog.btnDeleteBottomSheetHome.setOnClickListener {
            Toast.makeText(requireActivity(),"Deleted from your library",Toast.LENGTH_SHORT).show()
        }

        dialog.btnAddToLibraryBottomSheetHome.visibility = View.GONE

        dialog.btnAddToShelvesBottomSheetHome.setOnClickListener {
            startActivity(AddToShelvesActivity.newIntent(requireActivity()))
            dialog.dismiss()
        }

        dialog.btnMarkAsReadBottomSheetHome.setOnClickListener {
            Toast.makeText(requireActivity(),"Marks as read",Toast.LENGTH_SHORT).show()
        }

        dialog.btnAboutThisBookBottomSheetHome.setOnClickListener {
            Toast.makeText(requireActivity(),"About this ebook",Toast.LENGTH_SHORT).show()
        }
    }
}