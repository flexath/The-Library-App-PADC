package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.flexath.thelibrary.R

class NewShelfActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_SHELF_ID = "Shelf Id"
        fun newIntent(context: Context,shelfId:Int) : Intent {
            val intent = Intent(context,NewShelfActivity::class.java)
            intent.putExtra(EXTRA_SHELF_ID,shelfId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_shelf)
    }
}