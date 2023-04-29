package com.flexath.thelibrary.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexath.thelibrary.R
import com.flexath.thelibrary.mvp.presenters.HomePresenter
import com.flexath.thelibrary.views.viewpods.BookViewPod
import kotlinx.android.synthetic.main.fragment_e_book_home.*

class EBookHomeFragment(private val mPresenter: HomePresenter) : Fragment() {

    private lateinit var mMoreLikeViewPod: BookViewPod
    private lateinit var mEBookForYouViewPod: BookViewPod
    private lateinit var mOnYourWishlistViewPod: BookViewPod

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_e_book_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPodInstances()
        setUpListeners()
    }

    private fun setUpViewPodInstances() {
        mMoreLikeViewPod = vpEBookMoreLike as BookViewPod
        mMoreLikeViewPod.setUpBookViewPod(mPresenter)

        mEBookForYouViewPod = vpEBookForYou as BookViewPod
        mEBookForYouViewPod.setUpBookViewPod(mPresenter)

        mOnYourWishlistViewPod = vpEBookOnYourWishlist as BookViewPod
        mOnYourWishlistViewPod.setUpBookViewPod(mPresenter)
    }

    private fun setUpListeners() {
        btnForwardMoreLikeHome.setOnClickListener {
            mPresenter.onTapGoToBookListScreen()
        }
    }
}