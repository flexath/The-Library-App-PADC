package com.flexath.thelibrary.adapters.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BannerHomeViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.home.AudioBookBannerViewPagerViewHolder
import com.flexath.thelibrary.views.viewholders.home.EBookBannerViewPagerViewHolder
import com.flexath.thelibrary.views.viewholders.home.IBookBannerViewPagerViewHolder

class BookBannerHomeViewPagerAdapter(private var type:Int,private val delegate:BannerHomeViewHolderDelegate) : RecyclerView.Adapter<IBookBannerViewPagerViewHolder>(){

    private var mBookList:List<BookVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IBookBannerViewPagerViewHolder {
        return if(type == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_ebook_banner_home,parent,false)
            EBookBannerViewPagerViewHolder(view,delegate)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_audiobook_banner_home,parent,false)
            AudioBookBannerViewPagerViewHolder(view,delegate)
        }
    }

    override fun onBindViewHolder(holder: IBookBannerViewPagerViewHolder, position: Int) {
        when (type) {
            0 -> (holder as EBookBannerViewPagerViewHolder).bindData(mBookList[position])
            1 -> (holder as AudioBookBannerViewPagerViewHolder).bindData(mBookList[position])
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return mBookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(bookList: List<BookVO>?) {
        mBookList = bookList?.distinct() ?: listOf()
        notifyDataSetChanged()
    }
}