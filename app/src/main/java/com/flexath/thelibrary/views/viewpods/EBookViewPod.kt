package com.flexath.thelibrary.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.adapters.home.EBookHomeAdapter
import kotlinx.android.synthetic.main.layout_e_book_home_viewpod.view.*

class EBookViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private lateinit var mEBookAdapter:EBookHomeAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mEBookAdapter = EBookHomeAdapter()
        rvEBookHome.adapter = mEBookAdapter
        rvEBookHome.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }
}