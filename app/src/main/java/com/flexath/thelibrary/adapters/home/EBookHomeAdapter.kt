package com.flexath.thelibrary.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.home.EBookHomeViewHolder

class EBookHomeAdapter(private val delegate: BookHomeViewHolderDelegate) : RecyclerView.Adapter<EBookHomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EBookHomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_ebook_home,parent,false)
        return EBookHomeViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: EBookHomeViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

}