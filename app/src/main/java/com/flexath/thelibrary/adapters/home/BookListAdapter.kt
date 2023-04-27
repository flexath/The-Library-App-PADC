package com.flexath.thelibrary.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.views.viewholders.home.BookListViewHolder

class BookListAdapter : RecyclerView.Adapter<BookListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_book_list,parent,false)
        return BookListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}