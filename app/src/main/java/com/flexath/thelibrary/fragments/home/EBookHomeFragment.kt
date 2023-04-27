package com.flexath.thelibrary.fragments.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexath.thelibrary.R
import com.flexath.thelibrary.activities.BookListActivity
import kotlinx.android.synthetic.main.fragment_e_book_home.*

class EBookHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_e_book_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListeners()
    }

    private fun setUpListeners() {
        btnForwardMoreLikeHome.setOnClickListener {
            Intent(requireActivity(),BookListActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}