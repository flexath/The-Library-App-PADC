package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BookSearchViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_list_library.view.*

class BookSearchViewHolder(itemView: View, delegate: BookSearchViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mBook:BookVO? = null

    init {
        itemView.ivDownloadDoneListLibrary.visibility = View.GONE
        itemView.btnOptionListLibrary.visibility = View.GONE

        itemView.setOnClickListener {
            delegate.onTapBook(mBook?.title ?: "")
        }
    }

    fun bindData(book: BookVO) {
//        Glide.with(itemView.context)
//            .load(book.bookImage)
//            .into(itemView.ivCoverYourBooksLibrary)

        mBook = book

        itemView.tvTitleListLibrary.text = book.title
        itemView.tvAuthorListLibrary.text = book.author
    }
}