package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import com.bumptech.glide.Glide
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BannerHomeViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_audiobook_banner_home.view.*
import kotlinx.android.synthetic.main.view_holder_ebook_banner_home.view.*
import kotlinx.android.synthetic.main.view_holder_ebook_banner_home.view.btnOptionBannerHome

class AudioBookBannerViewPagerViewHolder(
    itemView: View,
    private val delegate: BannerHomeViewHolderDelegate
) : IBookBannerViewPagerViewHolder(itemView) {

    private var mBook:BookVO? = null

    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBookFromBanner(mBook?.title ?: "", mBook?.listId ?: 0)
        }

        itemView.btnOptionBannerHome.setOnClickListener {
            delegate.onTapOptionButtonFromBanner(mBook,0,"")
        }
    }

    override fun bindData(book: BookVO?) {
        mBook = book

        Glide.with(itemView.context)
            .load(book?.bookImage)
            .into(itemView.ivEbookBannerHomeAudio)
    }

}