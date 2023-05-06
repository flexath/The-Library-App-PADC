package com.flexath.thelibrary.adapters.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.delegates.library.LibraryBooksViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.home.BookListViewHolder
import com.flexath.thelibrary.views.viewholders.library.ILibraryBooksBaseViewHolder
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksLargeGridViewHolder
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksSmallGridViewHolder
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksListViewHolder

class LibraryBooksAdapter(private val spanCount: Int,private val delegate: LibraryBooksViewHolderDelegate) : RecyclerView.Adapter<ILibraryBooksBaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ILibraryBooksBaseViewHolder {

        return if(spanCount == 1) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_list_library,parent,false)
            LibraryBooksListViewHolder(view,delegate)
        } else if(spanCount == 2) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_book_list,parent,false)
            LibraryBooksLargeGridViewHolder(view,delegate)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grid_library,parent,false)
            LibraryBooksSmallGridViewHolder(view,delegate)
        }
    }

    override fun onBindViewHolder(holder: ILibraryBooksBaseViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 14
    }
}