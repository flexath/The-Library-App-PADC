package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import com.bumptech.glide.Glide
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_grid_library.view.*

class LibraryBooksSmallGridViewHolder(
    itemView: View,
    private val delegate: LibraryBooksViewHolderDelegate
) : ILibraryBooksBaseViewHolder(itemView) {

    private var mBook:BookVO? = null

    init {
        setUpListeners()
    }

    private fun setUpListeners() {

        itemView.setOnClickListener {
            delegate.onTapBook(mBook?.title ?: "",mBook?.listId ?: 0)
        }

        itemView.btnOptionBookGrid.setOnClickListener {
            mBook?.let { book ->
                delegate.onTapOptionButtonOnBook(book)
            }
        }
    }

    override fun bindData(book: BookVO?) {

        mBook = book

        Glide.with(itemView.context)
            .load(book?.bookImage)
            .error(R.drawable.browser)
            .placeholder(R.drawable.img_holder)
            .into(itemView.ivCoverSmallGrid)

        itemView.tvTitleLibrarySmallGrid.text = book?.title ?: ""
        itemView.tvAuthorLibrarySmallGrid.text = book?.author ?: ""
    }
}