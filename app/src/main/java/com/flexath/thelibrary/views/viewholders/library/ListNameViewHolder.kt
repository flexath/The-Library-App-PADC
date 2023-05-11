package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.delegates.library.ListNameChipDelegate
import kotlinx.android.synthetic.main.view_holder_chip_list.view.*

class ListNameViewHolder(itemView: View,private val delegate: ListNameChipDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mListName:String? = null

    init {
        itemView.cbListName.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                delegate.onTapChip(mListName ?: "")
            }
        }
    }

    fun bindData(chip: String, clearPressed: Boolean) {

        mListName = chip

        itemView.cbListName.text = chip

        if(clearPressed) {
            itemView.cbListName.isChecked = false
        }
    }
}