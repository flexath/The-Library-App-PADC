package com.flexath.thelibrary.adapters.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksListViewHolder

class BookSearchAdapter(private val delegate: LibraryBooksViewHolderDelegate) : RecyclerView.Adapter<LibraryBooksListViewHolder>() {

    private var mBookList:List<BookVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryBooksListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list_library,parent,false)
        return LibraryBooksListViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: LibraryBooksListViewHolder, position: Int) {
        if(mBookList.isNotEmpty()) {
            holder.bindData(mBookList[position])
        }
    }

    override fun getItemCount(): Int {
        return mBookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(bookList: List<BookVO>?) {
        mBookList = bookList ?: listOf()
        notifyDataSetChanged()
    }
}