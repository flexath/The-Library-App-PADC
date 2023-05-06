package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import com.flexath.thelibrary.delegates.home.BannerHomeViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_ebook_banner_home.view.*

class AudioBookBannerViewPagerViewHolder(itemView: View,private val delegate: BannerHomeViewHolderDelegate) : IBookBannerViewPagerViewHolder(itemView) {
    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            delegate.onTapBookFromBanner("",1)
        }

        itemView.btnOptionBannerHome.setOnClickListener {
            delegate.onTapOptionButtonFromBanner()
        }
    }

}