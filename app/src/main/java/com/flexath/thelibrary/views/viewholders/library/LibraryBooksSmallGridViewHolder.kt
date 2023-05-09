package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import com.flexath.thelibrary.data.vos.IBookVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_grid_library.view.*

class LibraryBooksSmallGridViewHolder(
    itemView: View,
    private val delegate: LibraryBooksViewHolderDelegate
) : ILibraryBooksBaseViewHolder(itemView) {

    init {
        setUpListeners()
    }

    private fun setUpListeners() {

        itemView.setOnClickListener {
            delegate.onTapBook("HAPPY PLACE",1)
        }

        itemView.btnOptionBookGrid.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }

    override fun bindData(iBookVO: BookVO) {

    }
}