package com.flexath.thelibrary.adapters.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.home.BookListViewHolder
import kotlinx.android.synthetic.main.view_holder_book_list.view.*

class BookListAdapter(private val type:Int,private val delegate: BookHomeViewHolderDelegate) : RecyclerView.Adapter<BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_book_list,parent,false)
        return BookListViewHolder(view,type,delegate)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}