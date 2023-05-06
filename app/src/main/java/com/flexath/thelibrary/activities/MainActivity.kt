package com.flexath.thelibrary.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.flexath.thelibrary.R
import com.flexath.thelibrary.fragments.home.HomeFragment
import com.flexath.thelibrary.fragments.library.LibraryFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpBottomNavigationView()
        setUpListeners()
    }

    private fun setUpListeners() {

    }

    private fun setUpBottomNavigationView() {
        switchFragment(HomeFragment())
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nvgHome -> {
                    switchFragment(HomeFragment())
                    true
                }
                R.id.nvgLibrary -> {
                    switchFragment(LibraryFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun switchFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }
}