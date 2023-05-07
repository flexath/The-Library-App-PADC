package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_list_library.view.*

class BookSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.ivDownloadDoneListLibrary.visibility = View.GONE
        itemView.btnOptionListLibrary.visibility = View.GONE
    }
}