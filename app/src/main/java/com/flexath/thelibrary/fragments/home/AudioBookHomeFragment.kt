package com.flexath.thelibrary.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flexath.thelibrary.R
import com.flexath.thelibrary.mvp.presenters.HomePresenter
import com.flexath.thelibrary.views.viewpods.BookViewPod
import kotlinx.android.synthetic.main.fragment_audio_book_home.*
import kotlinx.android.synthetic.main.fragment_e_book_home.*

class AudioBookHomeFragment(private val mPresenter: HomePresenter) : Fragment() {

    private lateinit var mAudioBookViewPod: BookViewPod

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_audio_book_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPodInstances()
        setUpListeners()
    }

    private fun setUpViewPodInstances() {
        mAudioBookViewPod = vpAudioBook as BookViewPod
        mAudioBookViewPod.setUpBookViewPod(mPresenter)
    }

    private fun setUpListeners() {
        btnForwardAudioBookHome.setOnClickListener {
            mPresenter.onTapGoToBookListScreen()
        }
    }
}