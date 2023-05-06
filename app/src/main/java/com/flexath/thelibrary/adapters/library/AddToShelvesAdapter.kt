package com.flexath.thelibrary.adapters.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.views.viewholders.library.AddToShelvesViewHolder

class AddToShelvesAdapter : RecyclerView.Adapter<AddToShelvesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddToShelvesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_add_to_shelves_list,parent,false)
        return AddToShelvesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddToShelvesViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 7
    }
}