package com.flexath.thelibrary.adapters.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.home.EBookHomeViewHolder

class EBookHomeAdapter(private val delegate: BookHomeViewHolderDelegate) : RecyclerView.Adapter<EBookHomeViewHolder>() {

    private var mCategory:CategoryVO? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EBookHomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_ebook_home,parent,false)
        return EBookHomeViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: EBookHomeViewHolder, position: Int) {
        mCategory?.books?.get(position)?.let {
            holder.bindData(it)
        }
    }

    override fun getItemCount(): Int {
        return mCategory?.books?.size ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(categoryVO: CategoryVO) {
        mCategory = categoryVO
        notifyDataSetChanged()
    }


}