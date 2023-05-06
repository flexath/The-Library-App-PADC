package com.flexath.thelibrary.views.viewholders.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flexath.thelibrary.data.vos.overview.BookVO
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import kotlinx.android.synthetic.main.view_holder_ebook_home.view.*

class EBookHomeViewHolder(itemView: View,private val delegate: BookHomeViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mBookName:String? = ""
    private var mListId:Int = 0

    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            mBookName?.let { bookName ->
                delegate.onTapBook(bookName,mListId)
            }
        }

        itemView.btnOptionHome.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }

    fun bindData(bookVO: BookVO,listId:Int) {

        mBookName = bookVO.title
        mListId = listId

        Glide.with(itemView.context)
            .load(bookVO.bookImage)
            .into(itemView.ivEBookMoreLikeHome)

        itemView.tvBookTitle.text = bookVO.title
        itemView.tvBookWriter.text = bookVO.author
    }
}