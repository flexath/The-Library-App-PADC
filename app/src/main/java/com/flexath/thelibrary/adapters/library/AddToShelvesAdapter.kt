package com.flexath.thelibrary.adapters.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.delegates.library.AddToShelvesDelegate
import com.flexath.thelibrary.views.viewholders.library.AddToShelvesViewHolder

class AddToShelvesAdapter(private val delegate: AddToShelvesDelegate) : RecyclerView.Adapter<AddToShelvesViewHolder>() {

    private var mShelfList:List<ShelfVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddToShelvesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_add_to_shelves_list,parent,false)
        return AddToShelvesViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: AddToShelvesViewHolder, position: Int) {
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