package com.flexath.thelibrary.fragments.library

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
    private var mListNameList:MutableList<String> = mutableListOf()

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

        setUpTabLayout()
        mPresenter.onUiReady(this)
    }

    private fun setUpTabLayout() {
        fragment.tabLayoutLibrary.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    mLibraryBooksViewPod.setNewData(mBookList)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                mLibraryBooksViewPod.setNewData(mBookList)
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
                mLibraryBooksViewPod.setNewData(mBookList)
            }
        })
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(requireActivity())[YourBooksLibraryPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPodInstances() {
        mLibraryBooksViewPod = vpBooksLibrary as LibraryBooksViewPod
        mLibraryBooksViewPod.setDelegate(1,this)
        mLibraryBooksViewPod.setDelegateForChip(mPresenter)
    }

    private fun setUpListeners() {
        btnFilterBooks.setOnClickListener {
            mPresenter.onTapFilterButton()
        }

        btnSortByLibrary.setOnClickListener {
            mPresenter.onTapSortButton()
        }

        btnClearChip.setOnClickListener {
            mPresenter.onTapCrossButton()
        }

    }

    override fun showBooksInLibrary(bookList: List<BookVO>?) {
        mBookList = bookList ?: listOf()
        mLibraryBooksViewPod.setNewData(mBookList)

        for(book in bookList!!) {
            mListNameList.add(book.listName ?: "")
        }
        mLibraryBooksViewPod.setChipData(mListNameList)
    }

    override fun showBookListByListName(bookList: List<BookVO>?) {
        mLibraryBooksViewPod.setNewData(bookList)
    }

    override fun showBottomSheetDialogForFiltering() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_filter)

        dialog.rbList.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(1,this)
                mLibraryBooksViewPod.setNewData(mBookList)
            }
        }

        dialog.rbLargeGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(2,this)
                mLibraryBooksViewPod.setNewData(mBookList)
            }
        }

        dialog.rbSmallGrid.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                mLibraryBooksViewPod.setDelegate(3,this)
                mLibraryBooksViewPod.setNewData(mBookList)
            }
        }

        dialog.show()
    }


    @SuppressLint("SetTextI18n")
    override fun showBottomSheetDialogForSorting() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_sort)
        dialog.show()

        dialog.rbRecentlyOpened.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                tvSortingMethod.text = "Recent"
                mLibraryBooksViewPod.setNewData(mBookList)
            }
        }

        dialog.rbTitle.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                tvSortingMethod.text = "Title"
                mLibraryBooksViewPod.setNewData(mPresenter.sortByTitle())
            }
        }

        dialog.rbAuthor.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                tvSortingMethod.text = "Author"
                mLibraryBooksViewPod.setNewData(mPresenter.sortByAuthor())
            }
        }
    }

    override fun onTapChip(listName: String) {
        mPresenter.onUiReadyForListName(this,listName)
    }

    override fun onTapCrossButton() {
        mLibraryBooksViewPod.setNewData(mBookList)
        mLibraryBooksViewPod.clearChipPress(true)
    }

    override fun showError(error: String) {
        Toast.makeText(requireActivity(),error,Toast.LENGTH_SHORT).show()
    }

    override fun onTapBook(bookName: String, listId: Int) {
        startActivity(BookDetailActivity.newIntent(requireActivity(),bookName,listId,""))
    }

    override fun onTapOptionButtonOnBook(book: BookVO) {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_option)
        dialog.show()

        Glide.with(requireActivity())
            .load(book.bookImage)
            .into(dialog.ivCoverBottomSheetHome)

        dialog.tvTitleBottomSheet.text = book.title
        dialog.tvWriterBottomSheet.text = book.author


        dialog.btnDownloadBottomSheetHome.setOnClickListener {
            Toast.makeText(requireActivity(),"Downloading",Toast.LENGTH_SHORT).show()
        }

        dialog.btnDeleteBottomSheetHome.setOnClickListener {
            val alertDialog = MaterialAlertDialogBuilder(requireActivity(),R.style.RoundedAlertDialog)
                .setTitle("Delete Book !")
                .setMessage("Are you sure ?")
                .setPositiveButton("Yes") { alertDialog , _ ->
                    mPresenter.deleteBookByTitle(book.title)
                    Toast.makeText(requireActivity(),"Book's removed",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    alertDialog.dismiss()
                }
                .setNegativeButton("Cancel") { alertDialog , _ ->
                    alertDialog.dismiss()
                }.create()

            alertDialog.show()
        }

        dialog.btnAddToLibraryBottomSheetHome.visibility = View.GONE

        dialog.btnAddToShelvesBottomSheetHome.setOnClickListener {
            startActivity(AddToShelvesActivity.newIntent(requireActivity(),book.title))
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