package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_ebook_home.view.*

class EBookHomeViewHolder(itemView: View,private val delegate: BookHomeViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBook(1)
        }

        itemView.btnOptionHome.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }
}