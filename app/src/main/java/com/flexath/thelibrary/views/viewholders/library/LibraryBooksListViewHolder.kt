package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import com.bumptech.glide.Glide
import com.flexath.thelibrary.data.vos.overview.BookVO
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

    override fun bindData(book: BookVO?) {

        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivCoverYourBooksLibrary)

        itemView.tvTitleListLibrary.text = book?.title ?: ""
        itemView.tvAuthorListLibrary.text = book?.author ?: ""

    }

}