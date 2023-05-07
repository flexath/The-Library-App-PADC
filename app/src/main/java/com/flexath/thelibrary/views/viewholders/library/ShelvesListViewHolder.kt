package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.delegates.library.YourShelvesLibraryViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_shelves_list.view.*

class ShelvesListViewHolder(itemView: View,private val delegate: YourShelvesLibraryViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {
    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.btnForwardShelvesList.setOnClickListener {
            delegate.onTapForwardButtonOnItem(1)
        }
    }
}