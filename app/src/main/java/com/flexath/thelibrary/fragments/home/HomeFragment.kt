package com.flexath.thelibrary.fragments.home

import android.content.res.Resources
import android.os.Bundle
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
import com.flexath.thelibrary.adapters.home.TabLayoutViewPagerAdapter
import com.flexath.thelibrary.mvp.presenters.HomePresenter
import com.flexath.thelibrary.mvp.presenters.HomePresenterImpl
import com.flexath.thelibrary.mvp.views.HomeView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(),HomeView {

    private var mBannerAdapter: BookBannerHomeViewPagerAdapter? = null
    private lateinit var mTabLayoutViewPagerAdapter: TabLayoutViewPagerAdapter

    private lateinit var mPresenter:HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpListeners()
        setUpTabLayoutWithViewPager()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(requireActivity())[HomePresenterImpl::class.java]
        mPresenter.initView(this@HomeFragment)
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
                RecyclerView.OVER_SCROLL_NEVER // Remove the scroll effect
        }
    }

    private fun setUpTabLayoutWithViewPager() {
        mTabLayoutViewPagerAdapter = TabLayoutViewPagerAdapter(this,mPresenter)
        viewPagerEbookHome.adapter = mTabLayoutViewPagerAdapter

        TabLayoutMediator(tabLayoutHome,viewPagerEbookHome) { tab , position ->
            when (position) {
                0 -> {
                    tab.text = "Ebooks"
                }
                else -> {
                    tab.text = "Audiobooks"
                }
            }
        }.attach()
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
    }

    override fun navigateToBookDetailScreen(bookId: Int) {
        startActivity(BookDetailActivity.newIntent(requireActivity(),bookId))
    }

    override fun navigateToBookListScreen() {
        startActivity(BookListActivity.newIntent(requireActivity(),tabLayoutHome.selectedTabPosition))
    }

    override fun onTapOptionButtonOnBook() {
        val dialog = BottomSheetDialog(requireActivity())
        dialog.setContentView(R.layout.layout_book_option_bottom_dialog)
        dialog.show()
    }

    override fun showError(error: String) {
        Toast.makeText(requireActivity(),error,Toast.LENGTH_SHORT).show()
    }
}