package com.flexath.thelibrary.fragments.library

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.thelibrary.R
import com.flexath.thelibrary.activities.NewShelfActivity
import com.flexath.thelibrary.adapters.library.ShelvesListAdapter
import com.flexath.thelibrary.mvp.presenters.YourShelvesLibraryPresenter
import com.flexath.thelibrary.mvp.presenters.YourShelvesLibraryPresenterImpl
import com.flexath.thelibrary.mvp.views.YourShelvesLibraryView
import kotlinx.android.synthetic.main.activity_add_to_shelves.*
import kotlinx.android.synthetic.main.fragment_your_shelves_library.*

class YourShelvesLibraryFragment : Fragment() , YourShelvesLibraryView {

    // Adapters
    private lateinit var mAdapter: ShelvesListAdapter

    // Presenters
    private lateinit var mPresenter:YourShelvesLibraryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_your_shelves_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenters()
        setUpRecyclerView()
        hideOrShowEmptyPlaceHolder()
    }

    private fun setUpPresenters() {
        mPresenter = ViewModelProvider(this)[YourShelvesLibraryPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView() {
        mAdapter = ShelvesListAdapter(mPresenter)
        rvShelvesList.adapter = mAdapter
        val linearLayoutManager = LinearLayoutManager(requireActivity())
        rvShelvesList.layoutManager = linearLayoutManager

        val divider = DividerItemDecoration(context?.applicationContext, linearLayoutManager.orientation)
        rvShelvesList.addItemDecoration(divider)
        mAdapter.notifyDataSetChanged()
    }

    private fun hideOrShowEmptyPlaceHolder() {
        if(mAdapter.itemCount == 0 ) llNoShelvesPlaceHolder.visibility = View.VISIBLE
        else llNoShelvesPlaceHolder.visibility = View.GONE
    }

    override fun navigateToNewShelfScreen(shelfId: Int) {
        startActivity(NewShelfActivity.newIntent(requireActivity(),shelfId))
    }

    override fun showError(error: String) {
        Toast.makeText(requireActivity(),error,Toast.LENGTH_SHORT).show()
    }
}