package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.YourShelvesLibraryViewHolderDelegate
import kotlinx.android.synthetic.main.activity_shelf_detail.view.*
import kotlinx.android.synthetic.main.view_holder_shelves_list.view.*

class ShelvesListViewHolder(itemView: View,private val delegate: YourShelvesLibraryViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mShelfId:Int = 0

    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.btnForwardShelvesList.setOnClickListener {
            delegate.onTapForwardButtonOnItem(mShelfId)
        }

        itemView.setOnClickListener {
            delegate.onTapForwardButtonOnItem(mShelfId)
        }
    }

    fun bindData(shelf: ShelfVO) {
        mShelfId = shelf.Id

        if(shelf.bookList?.size!! > 0) {
            Glide.with(itemView.context)
                .load(shelf.bookList?.get(shelf.bookList!!.lastIndex)?.bookImage)
                .error(R.drawable.browser)
                .placeholder(R.drawable.img_holder)
                .into(itemView.ivCoverShelvesList)
        }

        itemView.tvTitleShelvesList.text = shelf.shelfName

        var bookCount = "${shelf.bookCount} books"
        if(shelf.bookCount == 0) {
            bookCount = "0 book"
        }
        itemView.tvNumberOfBookShelvesList.text = bookCount
    }
}