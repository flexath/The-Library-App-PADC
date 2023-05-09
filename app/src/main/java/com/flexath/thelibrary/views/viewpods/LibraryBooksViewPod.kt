package com.flexath.thelibrary.views.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.adapters.library.LibraryBooksAdapter
import com.flexath.thelibrary.data.vos.IBookVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.viewpod_books_library.view.*

class LibraryBooksViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : NestedScrollView(context, attrs) {

    private lateinit var mDelegate:LibraryBooksViewHolderDelegate

    private lateinit var mLibraryBooksAdapter:LibraryBooksAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    fun setDelegate(spanCount: Int,delegate:LibraryBooksViewHolderDelegate) {
        mDelegate = delegate
        setUpRecyclerView(spanCount)
        if(spanCount == 1) {
            rvFilterBooksLibrary.layoutManager = LinearLayoutManager(context)
        } else if(spanCount == 2) {
            rvFilterBooksLibrary.layoutManager = GridLayoutManager(context, spanCount)
        } else {
            rvFilterBooksLibrary.layoutManager = GridLayoutManager(context, spanCount)
        }
    }

    private fun setUpRecyclerView(spanCount:Int) {
        mLibraryBooksAdapter = LibraryBooksAdapter(spanCount,mDelegate)
        rvFilterBooksLibrary.adapter = mLibraryBooksAdapter
    }

    fun setShelfDetailDelegate(spanCount: Int,delegate: LibraryBooksViewHolderDelegate) {
        mDelegate = delegate
        setUpRecyclerView(spanCount)
        rvFilterBooksLibrary.layoutManager = GridLayoutManager(context,spanCount)
    }

    fun setNewData(bookList: List<BookVO>) {
//        mLibraryBooksAdapter.setData(bookList)
    }
}