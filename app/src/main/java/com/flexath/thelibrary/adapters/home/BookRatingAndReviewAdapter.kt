package com.flexath.thelibrary.adapters.home

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.thelibrary.R
import com.flexath.thelibrary.views.viewholders.home.BookRatingAndReviewViewHolder

class BookRatingAndReviewAdapter : RecyclerView.Adapter<BookRatingAndReviewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookRatingAndReviewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_review_book_detail,parent,false)
        return BookRatingAndReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookRatingAndReviewViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }
}