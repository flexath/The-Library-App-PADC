package com.flexath.thelibrary.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.views.viewholders.home.BookSearchViewHolder

class BookSearchAdapter : RecyclerView.Adapter<BookSearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list_library,parent,false)
        return BookSearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookSearchViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}