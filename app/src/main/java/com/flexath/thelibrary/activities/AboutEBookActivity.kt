package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexath.thelibrary.R
import kotlinx.android.synthetic.main.activity_about_ebook.tvAboutEBook
import kotlinx.android.synthetic.main.activity_about_ebook.tvTitleAboutEBook

class AboutEBookActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_TITLE = "Book Title"
        private const val EXTRA_DESCRIPTION = "Book Description"
        fun newIntent(context: Context,title:String,description:String): Intent {
            val intent = Intent(context, AboutEBookActivity::class.java)
            intent.putExtra(EXTRA_TITLE,title)
            intent.putExtra(EXTRA_DESCRIPTION,description)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_ebook)

        tvTitleAboutEBook.text = intent?.extras?.getString(EXTRA_TITLE,"No Title")
        tvAboutEBook.text = intent?.extras?.getString(EXTRA_DESCRIPTION,"No Description")
    }
}