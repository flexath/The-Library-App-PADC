package com.flexath.thelibrary.adapters.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.YourShelvesLibraryViewHolderDelegate
import com.flexath.thelibrary.views.viewholders.library.ShelvesListViewHolder

class ShelvesListAdapter(private val delegate: YourShelvesLibraryViewHolderDelegate) : RecyclerView.Adapter<ShelvesListViewHolder>() {

    private var mShelfList:List<ShelfVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_shelves_list,parent,false)
        return ShelvesListViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: ShelvesListViewHolder, position: Int) {
        holder.bindData(mShelfList[position])
    }

    override fun getItemCount(): Int {
        return mShelfList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(shelfList: List<ShelfVO>) {
        mShelfList = shelfList
        notifyDataSetChanged()
    }
}