package com.flexath.thelibrary.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.adapters.library.AddToShelvesAdapter
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.mvp.presenters.AddToShelvesPresenter
import com.flexath.thelibrary.mvp.presenters.AddToShelvesPresenterImpl
import com.flexath.thelibrary.mvp.views.AddToShelvesView
import kotlinx.android.synthetic.main.activity_add_to_shelves.*

class AddToShelvesActivity : AppCompatActivity() , AddToShelvesView {

    private lateinit var mAdapter:AddToShelvesAdapter
    private var mShelfList:List<ShelfVO> = listOf()

    // Presenters
    private lateinit var mPresenter:AddToShelvesPresenter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,AddToShelvesActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_shelves)

        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[AddToShelvesPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView() {
        mAdapter = AddToShelvesAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this)
        rvAddToShelves.layoutManager = linearLayoutManager
        rvAddToShelves.adapter = mAdapter

        val divider = DividerItemDecoration(this, linearLayoutManager.orientation)
        rvAddToShelves.addItemDecoration(divider)
        mAdapter.notifyDataSetChanged()
    }

    override fun showShelfList(shelfList: List<ShelfVO>) {
        mShelfList = shelfList
        mAdapter.setNewData(mShelfList)
    }

    override fun onClickCheckBox(shelfId: Int,checked:Boolean) {
        for(it in mShelfList) {
            if(shelfId == it.Id) {
                if(checked) {
                    it.isChecked = true
                    it.bookCount = 6
                    val shelf = ShelfVO(it.Id,it.shelfName,it.bookCount,it.bookList,it.isChecked)
                    mPresenter.updateShelf(shelf)
                    break
                }else {
                    it.isChecked = false
                    it.bookCount = 4
                    val shelf = ShelfVO(it.Id,it.shelfName,it.bookCount,it.bookList,it.isChecked)
                    mPresenter.updateShelf(shelf)
                    break
                }
            }
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }
}