package com.flexath.thelibrary.fragments.home

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.flexath.thelibrary.R
import com.flexath.thelibrary.activities.BookDetailActivity
import com.flexath.thelibrary.activities.BookListActivity
import com.flexath.thelibrary.adapters.home.BookBannerHomeViewPagerAdapter
import com.flexath.thelibrary.data.vos.overview.CategoryVO
import com.flexath.thelibrary.mvp.presenters.HomePresenter
import com.flexath.thelibrary.mvp.presenters.HomePresenterImpl
import com.flexath.thelibrary.mvp.views.HomeView
import com.flexath.thelibrary.views.viewpods.BookViewPod
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeView {

    // ViewPods
    private lateinit var mFirstViewPod: BookViewPod
    private lateinit var mSecondViewPod: BookViewPod
    private lateinit var mThirdViewPod: BookViewPod

    //Adapters
    private var mBannerAdapter: BookBannerHomeViewPagerAdapter? = null
//    private lateinit var mTabLayoutViewPagerAdapter: TabLayoutViewPagerAdapter

    // Presenters
    private lateinit var mPresenter:HomePresenter

    // General
    private val homeTabList = listOf("Ebooks","Audiobooks")
    private var mFirstListId:Int = 0
    private var mSecondListId:Int = 0
    private var mThirdListId:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpTabLayout()
        setUpBannerViewPager(0)
        setUpViewPodInstances()
        setUpListeners()

        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(requireActivity())[HomePresenterImpl::class.java]
        mPresenter.initView(this)
    }

    private fun setUpViewPodInstances() {
        mFirstViewPod = vpEBookFirstHome as BookViewPod
        mFirstViewPod.setUpBookViewPod(mPresenter)

        mSecondViewPod = vpEBookForYou as BookViewPod
        mSecondViewPod.setUpBookViewPod(mPresenter)

        mThirdViewPod = vpEBookOnYourWishlist as BookViewPod
        mThirdViewPod.setUpBookViewPod(mPresenter)
    }

    private fun setUpBannerViewPager(type: Int) {
        setUpBannerViewPagerPadding()

        setUpBannerRecyclerView(type)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((20 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPagerEBookBannerHome.setPageTransformer(compositePageTransformer)
    }

    private fun setUpBannerRecyclerView(type:Int) {
        mBannerAdapter = BookBannerHomeViewPagerAdapter(type,mPresenter)
        viewPagerEBookBannerHome.adapter = mBannerAdapter
    }

    private fun setUpBannerViewPagerPadding() {
        viewPagerEBookBannerHome?.apply {
            clipChildren = false  // No clipping the left and right items
            clipToPadding = false  // Show the viewpager in full width without clipping the padding
            offscreenPageLimit = 3  // Render the left and right items
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_IF_CONTENT_SCROLLS // Remove the scroll effect
        }
    }

    private fun setUpTabLayout() {
//        mTabLayoutViewPagerAdapter = TabLayoutViewPagerAdapter(this,mPresenter)
//        viewPagerEbookHome.adapter = mTabLayoutViewPagerAdapter
//
//        TabLayoutMediator(tabLayoutHome,viewPagerEbookHome) { tab , position ->
//            when (position) {
//                0 -> {
//                    tab.text = "Ebooks"
//                }
//                else -> {
//                    tab.text = "Audiobooks"
//                }
//            }
//        }.attach()

        homeTabList.forEach {
            tabLayoutHome.newTab().apply {
                text = it
                tabLayoutHome.addTab(this)
            }
        }
    }

    private fun setUpListeners() {
        tabLayoutHome.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                setUpBannerViewPager(tab?.position ?: 0)

                if(tab?.position == 0) {
                    val layoutParams: ViewGroup.LayoutParams = viewPagerEBookBannerHome.layoutParams
                    layoutParams.width = 700
                    layoutParams.height = 700
                    viewPagerEBookBannerHome.layoutParams = layoutParams
                } else {
                    val layoutParams: ViewGroup.LayoutParams = viewPagerEBookBannerHome.layoutParams
                    layoutParams.width = 450
                    layoutParams.height = 700
                    viewPagerEBookBannerHome.layoutParams = layoutParams
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        btnForwardFirstHome.setOnClickListener {
            mPresenter.onTapGoToBookListScreen(tvFirstTitleHome.text.toString(),mFirstListId)
        }

        btnForwardSecondHome.setOnClickListener {
            mPresenter.onTapGoToBookListScreen(tvSecondTitleHome.text.toString(),mSecondListId)
        }

        btnForwardThirdHome.setOnClickListener {
            mPresenter.onTapGoToBookListScreen(tvThirdTitleHome.text.toString(),mThirdListId)
        }
    }

    override fun showFirstCategory(category: List<CategoryVO>?) {
        if(category?.size != 0) {
            tvFirstTitleHome.text = category?.get(0)?.listName ?: ""
            mFirstListId = category?.get(0)?.listId ?: 0
            category?.get(0)?.let {
                mFirstViewPod.setNewData(it)
            }
        }
    }

    override fun showSecondCategory(category: List<CategoryVO>?) {
        if(category?.size != 0) {
            tvSecondTitleHome.text = category?.get(1)?.listName ?: ""
            mSecondListId = category?.get(1)?.listId ?: 0
            category?.get(1)?.let { mSecondViewPod.setNewData(it) }
        }
    }

    override fun showThirdCategory(category: List<CategoryVO>?) {
        if(category?.size != 0) {
            tvThirdTitleHome.text = category?.get(2)?.listName ?: ""
            mThirdListId = category?.get(2)?.listId ?: 0
            category?.get(2)?.let { mThirdViewPod.setNewData(it) }
        }
    }

    override fun navigateToBookDetailScreen(bookName:String,listId:Int) {
        startActivity(BookDetailActivity.newIntent(requireContext(),bookName,listId,"HomeFragment"))
    }

    override fun navigateToBookListScreen(listName:String,listId:Int) {
        startActivity(BookListActivity.newIntent(requireActivity(),listName,tabLayoutHome.selectedTabPosition,listId))
    }

    override fun onTapOptionButtonOnBook() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.bottom_dialog_book_option)
        dialog.show()
    }

    override fun showError(error: String) {
        Toast.makeText(requireActivity(),error,Toast.LENGTH_SHORT).show()
    }
}