package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.flexath.thelibrary.R
import kotlinx.android.synthetic.main.activity_book_search.*

class BookSearchActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,BookSearchActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_search)

//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//
//        etSearch.requestFocus()
//        imm.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT)

    }
}