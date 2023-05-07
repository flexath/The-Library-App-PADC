package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_list_library.view.*

class LibraryBooksListViewHolder(
    itemView: View,
    private val delegate: LibraryBooksViewHolderDelegate
) : ILibraryBooksBaseViewHolder(itemView) {

    init {
        setUpListeners()
        itemView.ivDownloadDoneListLibrary.visibility = View.VISIBLE
        itemView.btnOptionListLibrary.visibility = View.VISIBLE
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBook("HAPPY PLACE", 1)
        }

        itemView.btnOptionListLibrary.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }

}