package com.flexath.thelibrary.adapters.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.delegates.library.ListNameChipDelegate
import com.flexath.thelibrary.views.viewholders.library.ListNameViewHolder

class ListNameAdapter(private val delegate: ListNameChipDelegate) : RecyclerView.Adapter<ListNameViewHolder>() {

    private var mChipList:MutableList<String> = mutableListOf()
    private var mClearPressed:Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_chip_list,parent,false)
        return ListNameViewHolder(view, delegate)
    }

    override fun onBindViewHolder(holder: ListNameViewHolder, position: Int) {
        holder.bindData(mChipList[position],mClearPressed)
    }

    override fun getItemCount(): Int {
        return mChipList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(chipList: MutableList<String>) {
        if(chipList.isNotEmpty()) {
            mChipList = chipList.distinct() as MutableList<String>
            notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearChipPress(clearPressed: Boolean) {
        mClearPressed = clearPressed
        notifyDataSetChanged()
    }
}