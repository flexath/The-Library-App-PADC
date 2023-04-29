package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_book_list.view.*

class BookListViewHolder(itemView: View, private val type:Int,private val delegate: BookHomeViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    init {
        isVisibleHeadphoneIcon()
        setUpListeners()
    }

    private fun isVisibleHeadphoneIcon() {
        if(type == 0) {
            itemView.btnHeadphoneBookList.visibility = View.GONE
        } else {
            itemView.btnHeadphoneBookList.visibility = View.VISIBLE
        }
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBook(1)
        }

        itemView.btnOptionBookList.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }

}