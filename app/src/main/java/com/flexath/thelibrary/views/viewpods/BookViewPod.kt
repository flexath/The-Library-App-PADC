package com.flexath.thelibrary.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.adapters.home.EBookHomeAdapter
import com.flexath.thelibrary.delegates.home.BookHomeViewHolderDelegate
import kotlinx.android.synthetic.main.layout_e_book_home_viewpod.view.*

class BookViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private lateinit var mEBookAdapter:EBookHomeAdapter
    private lateinit var mDelegate:BookHomeViewHolderDelegate

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setUpBookViewPod(delegate: BookHomeViewHolderDelegate) {
        this.mDelegate = delegate
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mEBookAdapter = EBookHomeAdapter(this.mDelegate)
        rvEBookHome.adapter = mEBookAdapter
        rvEBookHome.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }
}