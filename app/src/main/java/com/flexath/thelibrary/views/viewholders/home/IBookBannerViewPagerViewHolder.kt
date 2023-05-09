package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.data.vos.overview.BookVO

abstract class IBookBannerViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(book: BookVO?)
}