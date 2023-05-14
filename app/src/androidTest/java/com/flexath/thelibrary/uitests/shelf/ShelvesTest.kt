package com.flexath.thelibrary.uitests.shelf

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.idling.CountingIdlingResource
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.toolbar_new_shelf.*
import kotlinx.android.synthetic.main.toolbar_shelf_detail.*
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4ClassRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ShelvesTest {

    companion object {
        const val TEST_SHELF_NAME = "Android Development"
        const val TEST_NEW_SHELF_NAME = "ios Development"
    }

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    // From ChatGPT
    @Before
    fun setUp() {
        // Register the DialogIdlingResource with Espresso
        IdlingRegistry.getInstance().register(DialogIdlingResource.getIdlingResource())
    }

    // From ChatGPT
    @After
    fun tearDown() {
        // Unregister the DialogIdlingResource
        IdlingRegistry.getInstance().unregister(DialogIdlingResource.getIdlingResource())
    }

    @Test
    fun a_onTapCreateShelfButton_goToNewShelfActivity() {

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
    fun b_onTapBookOption_goToAddToShelves() {

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
    fun c_onTapShelf_goToShelfDetail() {
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

        onView(isRoot()).perform(click())

        // Verify recyclerview in viewpod
        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpShelfDetail))
            )
        ).check(matches(isDisplayed()))

        Thread.sleep(500L)

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleBookList)))
            .check(matches(isDisplayed()))
        onView(first<View>(withId(R.id.tvAuthorBookList)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvTitleBookList)))
            .check(matches(withText("HAPPY PLACE")))

        onView(first<View>(withId(R.id.tvAuthorBookList)))
            .check(matches(withText("Emily Henry")))

        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Filter button
        onView(withId(R.id.rbSmallGrid)).perform(click())

        onView(isRoot()).perform(click())

        // Verify recyclerview in viewpod
        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpShelfDetail))
            )
        ).check(matches(isDisplayed()))

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleLibrarySmallGrid)))
            .check(matches(isDisplayed()))
        onView(first<View>(withId(R.id.tvAuthorLibrarySmallGrid)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvTitleLibrarySmallGrid)))
            .check(matches(withText("HAPPY PLACE")))

        onView(first<View>(withId(R.id.tvAuthorLibrarySmallGrid)))
            .check(matches(withText("Emily Henry")))


        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Filter button
        onView(withId(R.id.rbList)).perform(click())

        onView(isRoot()).perform(click())

    }

    @Test
    fun d_goToShelfDetail_changeAndDeleteShelfName() {

        // Go to Shelf Detail
        onView(withId(R.id.nvgLibrary)).perform(click())

        onView(withId(R.id.rvChipList))
            .perform(ViewActions.swipeLeft())

        Thread.sleep(500L)

        onView(withId(R.id.rvShelvesList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ShelvesListViewHolder>(0, click()))

        Thread.sleep(500L)

        // Click on option button
        onView(withId(R.id.btnOptionShelfDetail)).perform(click())

        onView(withId(R.id.btnRenameShelfBottomSheet)).perform(click())

        onView(withId(R.id.tvShelfNameShelfDetail))
            .check(matches(isNotClickable()))

        onView(withId(R.id.etShelfNameShelfDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.etShelfNameShelfDetail))
            .perform(ViewActions.clearText())

        onView(withId(R.id.etShelfNameShelfDetail))
            .perform(typeText(TEST_NEW_SHELF_NAME),ViewActions.closeSoftKeyboard())

        onView(withId(R.id.etShelfNameShelfDetail))
            .check(matches(withText(TEST_NEW_SHELF_NAME)))

        onView(withId(R.id.btnBackShelfDetail)).perform(click())



        Thread.sleep(500L)

        onView(withId(R.id.rvShelvesList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ShelvesListViewHolder>(0, click()))

        Thread.sleep(500L)

        // Click on option button
        onView(withId(R.id.btnOptionShelfDetail)).perform(click())

        onView(withId(R.id.btnDeleteShelfBottomSheet)).perform(click())

        // From ChatGPT
        onView(withText("Yes"))
            .perform(click())
    }

    // From ChatGPT
    fun testAlertDialog() {
        // Create the AlertDialog
        val alertDialog = MaterialAlertDialogBuilder(ApplicationProvider.getApplicationContext(), R.style.RoundedAlertDialog)
            .setTitle("Delete Shelf!")
            .setMessage("Are you sure?")
            .setPositiveButton("Yes") { _, _ ->
                // Positive button click logic
            }
            .setNegativeButton("Cancel") { _, _ ->
                // Negative button click logic
            }
            .create()

        // Show the AlertDialog
        alertDialog.show()

        // Increment the DialogIdlingResource to indicate that a dialog is shown
        DialogIdlingResource.increment()

        // Wait for the dialog to appear and become idle
        Espresso.onView(ViewMatchers.withText("Delete Shelf!")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Decrement the DialogIdlingResource to indicate that the dialog is idle
        DialogIdlingResource.decrement()
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

// From ChatGPT
object DialogIdlingResource {
    private const val RESOURCE = "DIALOG"

    private val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        if (!idlingResource.isIdleNow) {
            idlingResource.decrement()
        }
    }

    fun getIdlingResource(): CountingIdlingResource {
        return idlingResource
    }
}

