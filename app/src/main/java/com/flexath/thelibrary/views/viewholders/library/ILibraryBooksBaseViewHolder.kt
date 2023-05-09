package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.data.vos.IBookVO
import com.flexath.thelibrary.data.vos.overview.BookVO

abstract class ILibraryBooksBaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(book: BookVO?)
}