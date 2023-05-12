package com.flexath.thelibrary.uitests.search

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.flexath.thelibrary.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.flexath.thelibrary.R
import com.flexath.thelibrary.uitests.utils.first

@RunWith(AndroidJUnit4ClassRunner::class)
class SearchTest {

    companion object {
        const val TEST_BOOK_QUERY = "kotlin"
    }

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun onTapSearchBar_goToBookSearchActivity() {

        onView(withId(R.id.btnSearchHome))
            .perform(click())

        onView(withId(R.id.etSearch))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etSearch))
            .perform(typeText(TEST_BOOK_QUERY), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.tabLayoutSearch))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvResultFromGooglePlay))
            .check(matches(isDisplayed()))

        Thread.sleep(3000L)

        onView(withId(R.id.rvSearch))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvTitleListLibrary)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvAuthorListLibrary)))
            .check(matches(isDisplayed()))
    }
}