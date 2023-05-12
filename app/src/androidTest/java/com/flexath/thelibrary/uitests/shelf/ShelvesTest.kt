package com.flexath.thelibrary.uitests.shelf

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.flexath.thelibrary.R
import com.flexath.thelibrary.activities.MainActivity
import com.flexath.thelibrary.uitests.utils.first
import com.flexath.thelibrary.views.viewholders.library.LibraryBooksListViewHolder
import com.flexath.thelibrary.views.viewholders.library.ListNameViewHolder
import com.flexath.thelibrary.views.viewholders.library.ShelvesListViewHolder
import kotlinx.android.synthetic.main.toolbar_new_shelf.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ShelvesTest {

    companion object {
        const val TEST_SHELF_NAME = "Android Development"
    }

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun onTapCreateShelfButton_goToNewShelfActivity() {

        onView(withId(R.id.nvgLibrary)).perform(click())

        onView(withId(R.id.rvChipList))
            .perform(ViewActions.swipeLeft())

        onView(withId(R.id.btnCreateNewShelf))
            .check(matches(isDisplayed()))

        onView(withId(R.id.llNoShelvesPlaceHolder))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnCreateNewShelf))
            .perform(click())

        onView(withId(R.id.tvTitleNewShelf))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etNewShelf))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etNewShelf))
            .perform(ViewActions.typeText(TEST_SHELF_NAME), ViewActions.closeSoftKeyboard())

        onView(withId(R.id.btnBackNewShelf)).perform(click())

        Thread.sleep(500L)

        onView(withId(R.id.rvShelvesList))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onTapBookOption_goToAddToShelves() {

        onView(withId(R.id.nvgLibrary)).perform(click())

        // From ChatGPT
        onView(withId(R.id.rvFilterBooksLibrary))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, MyViewAction.clickOnSameView()))

        onView(withId(R.id.btnAddToShelvesBottomSheetHome)).perform(click())

        onView(withId(R.id.tvTitleToolbar))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvAddToShelves))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.cbAddToShelves)))
            .perform(click())

        onView(withId(R.id.btnCloseAddToShelves)).perform(click())

        onView(withId(R.id.rvChipList))
            .perform(ViewActions.swipeLeft())

        onView(first<View>(withId(R.id.tvNumberOfBookShelvesList)))
            .check(matches(withText("1 books")))

        Thread.sleep(500L)

        // Second book added into shelf
        onView(withId(R.id.rvShelvesList))
            .perform(ViewActions.swipeRight())

        Thread.sleep(500L)

        // From ChatGPT
        onView(withId(R.id.rvFilterBooksLibrary))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, MyViewAction.clickOnSameView()))

        Thread.sleep(300L)

        onView(withId(R.id.btnAddToShelvesBottomSheetHome)).perform(click())

        onView(withId(R.id.tvTitleToolbar))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvAddToShelves))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.cbAddToShelves)))
            .perform(click())

        onView(withId(R.id.btnCloseAddToShelves)).perform(click())

        onView(withId(R.id.rvChipList))
            .perform(ViewActions.swipeLeft())

        onView(first<View>(withId(R.id.tvNumberOfBookShelvesList)))
            .check(matches(withText("2 books")))


        Thread.sleep(500L)

        // Third book added into shelf
        onView(withId(R.id.rvShelvesList))
            .perform(ViewActions.swipeRight())

        Thread.sleep(500L)

        // From ChatGPT
        onView(withId(R.id.rvFilterBooksLibrary))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, MyViewAction.clickOnSameView()))

        Thread.sleep(300L)

        onView(withId(R.id.btnAddToShelvesBottomSheetHome)).perform(click())

        onView(withId(R.id.tvTitleToolbar))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvAddToShelves))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.cbAddToShelves)))
            .perform(click())

        onView(withId(R.id.btnCloseAddToShelves)).perform(click())

        onView(withId(R.id.rvChipList))
            .perform(ViewActions.swipeLeft())

        onView(first<View>(withId(R.id.tvNumberOfBookShelvesList)))
            .check(matches(withText("3 books")))

        Thread.sleep(500L)
    }

    @Test
    fun onTapShelf_goToShelfDetail() {
        // Go to Shelf Detail
        onView(withId(R.id.nvgLibrary)).perform(click())

        onView(withId(R.id.rvChipList))
            .perform(ViewActions.swipeLeft())

        Thread.sleep(500L)

        onView(withId(R.id.rvShelvesList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ShelvesListViewHolder>(0, click()))

        Thread.sleep(500L)

        onView(allOf(withId(R.id.rvFilterBooksLibrary), isDescendantOfA(withId(R.id.vpShelfDetail))))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvTitleListLibrary)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvAuthorListLibrary)))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvShelfNameShelfDetail))
            .check(matches(withText("Android Development")))

        onView(withId(R.id.tvBookCountShelfDetail))
            .check(matches(withText("3 books")))



        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Filter button
        onView(withId(R.id.rbLargeGrid)).perform(click())

        // Verify recyclerview in viewpod
        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpShelfDetail))
            )
        )
            .check(matches(isDisplayed()))

        Thread.sleep(500L)

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleBookList)))
            .check(matches(isDisplayed()))
        onView(first<View>(withId(R.id.tvAuthorBookList)))
            .check(matches(isDisplayed()))


        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Filter button
        onView(withId(R.id.rbSmallGrid)).perform(click())

        // Verify recyclerview in viewpod
        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpShelfDetail))
            )
        )
            .check(matches(isDisplayed()))

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleLibrarySmallGrid)))
            .check(matches(isDisplayed()))
        onView(first<View>(withId(R.id.tvAuthorLibrarySmallGrid)))
            .check(matches(isDisplayed()))


        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Filter button
        onView(withId(R.id.rbList)).perform(click())

        Thread.sleep(500L)


        // Click on option button
        onView(withId(R.id.btnOptionShelfDetail)).perform(click())

        onView(withId(R.id.btnRenameShelfBottomSheet)).perform(click())

        onView(withId(R.id.tvShelfNameShelfDetail))
            .check(matches(isNotClickable()))

        onView(withId(R.id.etShelfNameShelfDetail))
            .check(matches(isDisplayed()))
    }
}


class MyViewAction {
    companion object {
        fun clickOnSameView(): ViewAction {
            return object : ViewAction {
                override fun getConstraints(): Matcher<View> {
                    return allOf(isDisplayed(), isAssignableFrom(View::class.java))
                }

                override fun getDescription(): String {
                    return "Click on the desired view"
                }

                override fun perform(uiController: UiController?, view: View?) {
                    // Perform the click action on the desired view
                    view?.findViewById<View>(R.id.btnOptionListLibrary)?.performClick()
                }
            }
        }
    }
}
