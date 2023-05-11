package com.flexath.thelibrary.adapters.library

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.views.viewholders.library.ListNameViewHolder

class ListNameAdapter : RecyclerView.Adapter<ListNameViewHolder>() {

    private var mChipList:MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_chip_list,parent,false)
        return ListNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListNameViewHolder, position: Int) {
        holder.bindData(mChipList[position])
    }

    override fun getItemCount(): Int {
        return mChipList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chipList: MutableList<String>) {
        mChipList = chipList.distinct() as MutableList<String>
        notifyDataSetChanged()
    }
}