package com.flexath.thelibrary.views.viewholders.home

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.data.vos.list.BookListResultVO
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.library.ILibraryBooksBaseViewHolder
import kotlinx.android.synthetic.main.view_holder_book_list.view.*

class BookListViewHolder(itemView: View, private val type:Int,private val delegate: BookHomeViewHolderDelegate) :
    ILibraryBooksBaseViewHolder(itemView) {

    private var mBookName:String? = null
    private var mId:Int = 0

    init {
        isVisibleHeadphoneIcon()
        setUpListeners()
    }

    private fun isVisibleHeadphoneIcon() {
        if(type == 0) {
            itemView.btnHeadphoneBookList.visibility = View.GONE
        } else {
            itemView.btnHeadphoneBookList.visibility = View.VISIBLE
        }
    }

    private fun setUpListeners() {
        itemView.setOnClickListener {
            mBookName?.let { bookName ->
                delegate.onTapBook(bookName,mId)
            }
        }

        itemView.btnOptionBookList.setOnClickListener {
            delegate.onTapOptionButtonOnBook()
        }
    }

    fun bindData(bookList: BookListResultVO) {

        mBookName = bookList.bookDetails?.get(0)?.title
        mId = bookList.id

        itemView.tvTitleBookList.text = bookList.bookDetails?.get(0)?.title ?: ""
        itemView.tvAuthorBookList.text = bookList.bookDetails?.get(0)?.author ?: ""
    }

}