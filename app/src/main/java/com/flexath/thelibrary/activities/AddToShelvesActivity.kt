package com.flexath.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.library.AddToShelvesAdapter
import kotlinx.android.synthetic.main.activity_add_to_shelves.*

class AddToShelvesActivity : AppCompatActivity() {

    private lateinit var mAdapter:AddToShelvesAdapter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,AddToShelvesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_shelves)

        setUpRecyclerView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView() {
        mAdapter = AddToShelvesAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        rvAddToShelves.layoutManager = linearLayoutManager
        rvAddToShelves.adapter = mAdapter

        val divider = DividerItemDecoration(this, linearLayoutManager.orientation)
        rvAddToShelves.addItemDecoration(divider)
        mAdapter.notifyDataSetChanged()
    }
}