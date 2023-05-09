package com.flexath.thelibrary.adapters.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.IBookVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.home.BookListViewHolder
import com.flexath.thelibrary.views.viewholders.library.ILibraryBooksBaseViewHolder
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksLargeGridViewHolder
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksSmallGridViewHolder
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksListViewHolder

class LibraryBooksAdapter(private val spanCount: Int,private val delegate: LibraryBooksViewHolderDelegate) : RecyclerView.Adapter<ILibraryBooksBaseViewHolder>() {

    private var mBookList:List<BookVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ILibraryBooksBaseViewHolder {

        return when (spanCount) {
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list_library,parent,false)
                LibraryBooksListViewHolder(view,delegate)
            }
            2 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_book_list,parent,false)
                LibraryBooksLargeGridViewHolder(view,delegate)
            }
            3 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grid_library,parent,false)
                LibraryBooksSmallGridViewHolder(view,delegate)
            }
            else -> throw IllegalArgumentException("Invalid!!")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ILibraryBooksBaseViewHolder, position: Int) {
        when (holder.itemViewType) {
            1 -> (holder as LibraryBooksListViewHolder).bindData(mBookList[position])
            2 -> (holder as LibraryBooksLargeGridViewHolder).bindData(mBookList[position])
            3 -> (holder as LibraryBooksSmallGridViewHolder).bindData(mBookList[position])
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return mBookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(bookList: List<BookVO>) {
        mBookList = bookList
        notifyDataSetChanged()
    }
}