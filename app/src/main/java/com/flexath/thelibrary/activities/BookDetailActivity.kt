package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexath.thelibrary.R

class BookDetailActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,BookDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)
    }
}