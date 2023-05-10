package com.flexath.thelibrary.views.viewholders.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.AddToShelvesDelegate
import kotlinx.android.synthetic.main.view_holder_add_to_shelves_list.view.*

class AddToShelvesViewHolder(itemView: View,private val delegate: AddToShelvesDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mShelf:ShelfVO? = null

    init {
        setUpListeners()
    }

    private fun setUpListeners() {

    }

    fun bindData(shelf: ShelfVO) {
        mShelf = shelf

        itemView.tvTitleAddToShelves.text = shelf.shelfName ?: ""

        var bookCount = "${shelf.bookCount} books"
        if(shelf.bookCount == 0) {
            bookCount = "0 book"
        }
        itemView.tvNumberOfBooksAddToShelves.text = bookCount

        itemView.cbAddToShelves.isChecked = shelf.isChecked ?: false

        itemView.cbAddToShelves.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                delegate.onTapCheckBox(mShelf?.Id ?: 0,true)
            } else {
                delegate.onTapCheckBox(mShelf?.Id ?: 0,false)
            }
        }
    }
}