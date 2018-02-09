package com.shanerudolf.cbmcodechalllenge.viewTest

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.MediumTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.shanerudolf.cbmcodechalllenge.MainActivity
import com.shanerudolf.cbmcodechalllenge.R
import com.shanerudolf.cbmcodechalllenge.views.DiscoveryFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by shane1 on 2/9/18.
 */
@RunWith(AndroidJUnit4::class)
@MediumTest
class DiscoveryFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun init() {
        activityRule.activity.setStartupFragment(DiscoveryFragment.newInstance())
    }

    @Test
    fun checkCurrentFragmentIsDiscoveryFragment() {
        Espresso.onView(ViewMatchers.withId(R.id.swipeView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkSwipeRightPhotoDisplay() {
        Espresso.onView(ViewMatchers.withId(R.id.swipeView))
                .perform(ViewActions.swipeRight())
        Espresso.onView(ViewMatchers.withId(R.id.photoImageView))
                .check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }

    @Test
    fun checkSwipeLeft() {
        Espresso.onView(ViewMatchers.withId(R.id.swipeView))
                .perform(ViewActions.swipeLeft())
        Espresso.onView(ViewMatchers.withId(R.id.photoImageView))
                .check(ViewAssertions.doesNotExist())
    }

    @Test
    fun checkPhotoDismissed() {
        Espresso.onView(ViewMatchers.withId(R.id.swipeView))
                .perform(ViewActions.swipeRight())
        Espresso.onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        Espresso.onView(ViewMatchers.withId(R.id.photoImageView))
                .check(ViewAssertions.doesNotExist())
    }
}