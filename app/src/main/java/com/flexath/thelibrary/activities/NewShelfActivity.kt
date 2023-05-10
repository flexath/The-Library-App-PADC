package com.flexath.thelibrary.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.flexath.thelibrary.R
import com.flexath.thelibrary.data.vos.ShelfVO
import com.flexath.thelibrary.mvp.presenters.NewShelfPresenter
import com.flexath.thelibrary.mvp.presenters.NewShelfPresenterImpl
import kotlinx.android.synthetic.main.activity_new_shelf.*

class NewShelfActivity : AppCompatActivity() {

    private lateinit var mPresenter:NewShelfPresenter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,NewShelfActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_shelf)

        setUpPresenter()
        setUpEditTextCharacterCount()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[NewShelfPresenterImpl::class.java]
    }

    private fun setUpEditTextCharacterCount() {

        etNewShelf.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val charCount = s.toString().length
                val characterCountString = "$charCount/50"
                tvCountNewShelf.text = characterCountString
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        etNewShelf.setOnEditorActionListener { _, actionId, _ ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                val shelf = ShelfVO(shelfName = etNewShelf.text.toString())
                mPresenter.insertShelf(shelf)
                finish()
                true
            } else {
                false
            }
        }
    }
}