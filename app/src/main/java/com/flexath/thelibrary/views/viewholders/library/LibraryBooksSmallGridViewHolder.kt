package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import com.bumptech.glide.Glide
import com.flexath.thelibrary.data.vos.IBookVO
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_grid_library.view.*
import kotlinx.android.synthetic.main.view_holder_list_library.view.*

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

    override fun bindData(book: BookVO?) {
        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivCoverSmallGrid)

        itemView.tvTitleLibrarySmallGrid.text = book?.title ?: ""
        itemView.tvAuthorLibrarySmallGrid.text = book?.author ?: ""
    }
}