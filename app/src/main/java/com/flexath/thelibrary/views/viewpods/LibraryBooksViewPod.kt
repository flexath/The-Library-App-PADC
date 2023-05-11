package com.flexath.thelibrary.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.adapters.library.LibraryBooksAdapter
import com.flexath.thelibrary.adapters.library.ListNameAdapter
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.viewpod_books_library.view.*

class LibraryBooksViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : NestedScrollView(context, attrs) {

    private lateinit var mDelegate:LibraryBooksViewHolderDelegate

    private lateinit var mLibraryBooksAdapter:LibraryBooksAdapter
    private lateinit var mListNameAdapter:ListNameAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpRecyclerViewForChipList()
    }

    fun setDelegate(spanCount: Int,delegate:LibraryBooksViewHolderDelegate) {
        mDelegate = delegate
        setUpRecyclerViewForBooks(spanCount)
        when (spanCount) {
            1 -> {
                rvFilterBooksLibrary.layoutManager = LinearLayoutManager(context)
            }
            2 -> {
                rvFilterBooksLibrary.layoutManager = GridLayoutManager(context, spanCount)
            }
            else -> {
                rvFilterBooksLibrary.layoutManager = GridLayoutManager(context, spanCount)
            }
        }
    }

    private fun setUpRecyclerViewForBooks(spanCount:Int) {
        mLibraryBooksAdapter = LibraryBooksAdapter(spanCount,mDelegate)
        rvFilterBooksLibrary.adapter = mLibraryBooksAdapter
    }

    private fun setUpRecyclerViewForChipList() {
        mListNameAdapter = ListNameAdapter()
        rvChipList.adapter = mListNameAdapter
        rvChipList.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }

    fun setNewData(bookList: List<BookVO>?) {
        mLibraryBooksAdapter.setData(bookList)
    }

    fun setChipData(chipList: MutableList<String>) {
        mListNameAdapter.setData(chipList)
    }
}