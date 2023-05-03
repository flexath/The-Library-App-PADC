package com.flexath.thelibrary.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import com.flexath.thelibrary.mvp.presenters.HomePresenter
import com.flexath.thelibrary.views.viewpods.BookViewPod
import kotlinx.android.synthetic.main.fragment_e_book_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class EBookHomeFragment(private val mPresenter: HomePresenter,private val mCategoryList: List<CategoryVO>) : Fragment() {

//    private lateinit var mFirstViewPod: BookViewPod
//    private lateinit var mSecondViewPod: BookViewPod
//    private lateinit var mThirdViewPod: BookViewPod
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_e_book_home, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        setUpViewPodInstances()
//        setUpListeners()
//
//        setUpCategoryTitle()
//        setAllTheData()
//    }
//
//    private fun setUpViewPodInstances() {
//        mFirstViewPod = vpEBookFirstHome as BookViewPod
//        mFirstViewPod.setUpBookViewPod(mPresenter)
//
//        mSecondViewPod = vpEBookForYou as BookViewPod
//        mSecondViewPod.setUpBookViewPod(mPresenter)
//
//        mThirdViewPod = vpEBookOnYourWishlist as BookViewPod
//        mThirdViewPod.setUpBookViewPod(mPresenter)
//    }
//
//    private fun setUpListeners() {
//        btnForwardMoreLikeHome.setOnClickListener {
//            mPresenter.onTapGoToBookListScreen()
//        }
//    }
//
//    private fun setUpCategoryTitle() {
//        tvFirstTitleHome.text = mCategoryList[0].displayName
//        tvSecondTitleHome.text = mCategoryList[1].displayName
//        tvThirdTitleHome.text = mCategoryList[2].displayName
//    }
//
//    private fun setAllTheData() {
//        mFirstViewPod.setNewDataForFirstCategory(mCategoryList[0])
//        mSecondViewPod.setNewDataForSecondCategory(mCategoryList[1])
//        mThirdViewPod.setNewDataForThirdCategory(mCategoryList[2])
//    }
}