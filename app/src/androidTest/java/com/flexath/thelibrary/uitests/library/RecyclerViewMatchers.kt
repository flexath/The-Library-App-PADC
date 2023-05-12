package com.flexath.thelibrary.uitests.library

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

object RecyclerViewMatchers {
    fun hasViewInPosition(position: Int, targetViewId: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description?) {
                description?.appendText("hasViewInPosition")
            }

            override fun matchesSafely(view: View?): Boolean {
                val recyclerView = view as? RecyclerView
                val viewHolder = recyclerView?.findViewHolderForAdapterPosition(position)
                val targetView = viewHolder?.itemView?.findViewById<View>(targetViewId)
                return targetView != null
            }
        }
    }
}

