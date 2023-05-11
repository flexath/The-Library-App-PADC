package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flexath.thelibrary.data.vos.overview.BookVO
import kotlinx.android.synthetic.main.view_holder_list_library.view.*

class BookSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.ivDownloadDoneListLibrary.visibility = View.GONE
        itemView.btnOptionListLibrary.visibility = View.GONE
    }

    fun bindData(book: BookVO) {
//        Glide.with(itemView.context)
//            .load(book.bookImage)
//            .into(itemView.ivCoverYourBooksLibrary)

        itemView.tvTitleListLibrary.text = book.title
        itemView.tvAuthorListLibrary.text = book.author
    }
}