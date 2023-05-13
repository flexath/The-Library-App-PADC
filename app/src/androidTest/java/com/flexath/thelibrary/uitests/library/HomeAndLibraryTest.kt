@file:Suppress("DEPRECATION")

package com.flexath.thelibrary.uitests.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.GeneralClickAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Tap
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
import com.flexath.thelibrary.views.viewholders.library.ListNameViewHolder
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.allOf
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4ClassRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class HomeAndLibraryTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun a_tapOnFirstCategory_goToBookDetail() {

        // First Category
        onView(withId(R.id.tvFirstTitleHome))
            .check(matches(isDisplayed()))

        onView(withId(R.id.vpEBookFirstHome))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvBookTitle)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvBookWriter)))
            .check(matches(isDisplayed()))

        Thread.sleep(1000L)

        // click on item in recyclerview
        onView(allOf(withId(R.id.rvEBookHome), isDescendantOfA(withId(R.id.vpEBookFirstHome))))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        // Verify views in BookDetail
        onView(withId(R.id.tvTitleBookDetail))
            .check(matches(withText("HAPPY PLACE")))

        onView(withId(R.id.tvWriterBookDetail))
            .check(matches(withText("Emily Henry")))

        onView(withId(R.id.tvBookInfoBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.ivCoverBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBookTypeBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBookTypeBottomSheet))
            .check(matches(isDisplayed()))

        onView(withId(R.id.llButtonsBookDetails))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBooksThatYouBuyBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvAboutThisEBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvRatingAndReviewBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.vpRatingAndReview))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvReview))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnBackBookDetail)).perform(click())
    }

    @Test
    fun b_tapOnSecondCategory_goToBookDetail() {

        onView(withId(R.id.scrollView))
            .perform(ViewActions.swipeUp())

        // First Category
        onView(withId(R.id.tvSecondTitleHome))
            .check(matches(isDisplayed()))

        onView(withId(R.id.vpEBookForYou))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvBookTitle)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvBookWriter)))
            .check(matches(isDisplayed()))

        Thread.sleep(1000L)

        // click on item in recyclerview
        onView(allOf(withId(R.id.rvEBookHome), isDescendantOfA(withId(R.id.vpEBookForYou))))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        // Verify views in BookDetail
        onView(withId(R.id.tvTitleBookDetail))
            .check(matches(withText("THE WAGER")))

        onView(withId(R.id.tvWriterBookDetail))
            .check(matches(withText("David Grann")))

        onView(withId(R.id.tvBookInfoBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.ivCoverBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBookTypeBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBookTypeBottomSheet))
            .check(matches(isDisplayed()))

        onView(withId(R.id.llButtonsBookDetails))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBooksThatYouBuyBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvAboutThisEBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvRatingAndReviewBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.vpRatingAndReview))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvReview))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnBackBookDetail)).perform(click())
    }

    @Test
    fun c_tapOnThirdCategory_goToBookDetail() {

        onView(withId(R.id.scrollView))
            .perform(ViewActions.swipeUp())

        // Third Category
        onView(withId(R.id.tvThirdTitleHome))
            .check(matches(isDisplayed()))

        onView(withId(R.id.vpEBookOnYourWishlist))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvBookTitle)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvBookWriter)))
            .check(matches(isDisplayed()))

        Thread.sleep(1000L)

        // click on item in recyclerview
        onView(allOf(withId(R.id.rvEBookHome), isDescendantOfA(withId(R.id.vpEBookOnYourWishlist))))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        // Verify views in BookDetail
        onView(withId(R.id.tvTitleBookDetail))
            .check(matches(withText("THE BODY KEEPS THE SCORE")))

        onView(withId(R.id.tvWriterBookDetail))
            .check(matches(withText("Bessel van der Kolk")))

        onView(withId(R.id.tvBookInfoBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.ivCoverBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBookTypeBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBookTypeBottomSheet))
            .check(matches(isDisplayed()))

        onView(withId(R.id.llButtonsBookDetails))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvBooksThatYouBuyBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvAboutThisEBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.tvRatingAndReviewBookDetail))
            .check(matches(isDisplayed()))

        onView(withId(R.id.vpRatingAndReview))
            .check(matches(isDisplayed()))

        onView(withId(R.id.rvReview))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btnBackBookDetail)).perform(click())

    }

    @Test
    fun d_afterTappingThreeItems_isVisibleBannerViewPager() {
        Thread.sleep(1000L)

        onView(withId(R.id.viewPagerEBookBannerHome))
            .check(matches(isDisplayed()))
    }

    @Test
    fun e_onTapLibraryTab_isVisibleViewPod() {

        // Click on library tab
        onView(withId(R.id.nvgLibrary)).perform(click())

        Thread.sleep(500L)

        // Verify TabLayout in library tab
        onView(withId(R.id.tabLayoutLibrary))
            .check(matches(isDisplayed()))

        // Verify Viewpod
        onView(withId(R.id.vpBooksLibrary))
            .check(matches(isDisplayed()))

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleListLibrary)))
            .check(matches(isDisplayed()))

        onView(first<View>(withId(R.id.tvAuthorListLibrary)))
            .check(matches(isDisplayed()))


        // Verify chip name
        onView(first<View>(withId(R.id.cbListName)))
            .check(matches(withText("Hardcover Fiction")))

        // Scroll right
        onView(withId(R.id.rvChipList))
            .perform(RecyclerViewActions.scrollToPosition<ListNameViewHolder>(2))

        // Verify chip name
        onView(first<View>(withId(R.id.cbListName)))
            .check(matches(withText("Hardcover Nonfiction")))


        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Filter button
        onView(withId(R.id.rbList)).perform(click())

        onView(isRoot()).perform(click())

        // Verify recyclerview in viewpod
        onView(allOf(withId(R.id.rvFilterBooksLibrary), isDescendantOfA(withId(R.id.vpBooksLibrary))))
            .check(matches(isDisplayed()))

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleListLibrary)))
            .check(matches(isDisplayed()))
        onView(first<View>(withId(R.id.tvAuthorListLibrary)))
            .check(matches(isDisplayed()))


        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on List Large Grid button
        onView(withId(R.id.rbLargeGrid)).perform(click())

        onView(isRoot()).perform(click())

        // Verify recyclerview in viewpod
        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpBooksLibrary))
            )
        )
            .check(matches(isDisplayed()))

        // Verify Title and Author by List Filtering
        onView(first<View>(withId(R.id.tvTitleBookList)))
            .check(matches(isDisplayed()))
        onView(first<View>(withId(R.id.tvAuthorBookList)))
            .check(matches(isDisplayed()))


        // Click on Filter button
        onView(withId(R.id.btnFilterBooks)).perform(click())

        // CLick on Small Grid Filter button
        onView(withId(R.id.rbSmallGrid)).perform(click())

        onView(isRoot()).perform(click())

        // Verify recyclerview in viewpod
        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpBooksLibrary))
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

        onView(isRoot()).perform(click())

        // Click on first chip
        onView(withId(R.id.rvChipList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ListNameViewHolder>(0, click()))

        // Scroll left
        onView(withId(R.id.rvChipList))
            .perform(RecyclerViewActions.scrollToPosition<ListNameViewHolder>(0))

        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpBooksLibrary))
            )
        )
            .check(matches(isDisplayed()))

        // Click on second chip
        onView(withId(R.id.rvChipList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ListNameViewHolder>(1, click()))


        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpBooksLibrary))
            )
        )
            .check(matches(isDisplayed()))

        // Click on third chip
        onView(withId(R.id.rvChipList))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ListNameViewHolder>(2, click()))


        onView(
            allOf(
                withId(R.id.rvFilterBooksLibrary),
                isDescendantOfA(withId(R.id.vpBooksLibrary))
            )
        ).check(matches(isDisplayed()))

        // Click on clear button for chips
        onView(withId(R.id.btnClearChip)).perform(click())

        // From ChatGPT ( Verify Item count is 3 )
        val actualItemCount = getItemCount(R.id.rvChipList)
        assertEquals(3, actualItemCount)

        onView(first<View>(withId(R.id.cbListName)))
            .check(matches(isNotChecked()))
    }
}

// From ChatGPT
fun getItemCount(recyclerViewId: Int): Int {
    val recyclerView = onView(withId(recyclerViewId))
    val itemCount = IntArray(1)

    recyclerView.check(matches(isDisplayed()))
    recyclerView.check { view, _ ->
        val rv = view as RecyclerView
        itemCount[0] = rv.adapter?.itemCount ?: 0
    }

    return itemCount[0]
}