package com.flexath.thelibrary.views.viewholders.home

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BannerHomeViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_ebook_banner_home.view.*

class EBookBannerViewPagerViewHolder(itemView: View,private val delegate: BannerHomeViewHolderDelegate) : IBookBannerViewPagerViewHolder(itemView) {

    private var mBook:BookVO? = null

    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBookFromBanner(mBook?.title ?: "", mBook?.listId ?: 0)
        }

        itemView.btnOptionBannerHome.setOnClickListener {
            mBook?.let { it1 -> delegate.onTapOptionButtonFromBanner(it1) }
        }
    }

    override fun bindData(book: BookVO?) {
        mBook = book

        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivEbookBannerHome)
    }
}