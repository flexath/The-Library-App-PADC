package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_chip_list.view.*

class ListNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindData(chip: String) {
        itemView.cbListName.text = chip
    }
}