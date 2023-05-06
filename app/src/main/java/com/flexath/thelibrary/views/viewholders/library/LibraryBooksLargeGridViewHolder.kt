package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_book_list.view.*
import kotlinx.android.synthetic.main.view_holder_list_library.view.*

class LibraryBooksLargeGridViewHolder(
    itemView: View,
    private val delegate: LibraryBooksViewHolderDelegate
) : ILibraryBooksBaseViewHolder(itemView) {
    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBook("HAPPY PLACE", 1)
        }

        itemView.btnOptionBookList.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }
}