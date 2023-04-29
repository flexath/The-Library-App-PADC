package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexath.thelibrary.R

class BookDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_BOOK_ID = "Book Id"

        fun newIntent(context: Context,bookId:Int) : Intent {
            val intent = Intent(context,BookDetailActivity::class.java)
            intent.putExtra(EXTRA_BOOK_ID,bookId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
    }
}