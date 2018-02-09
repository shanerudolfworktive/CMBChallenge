package com.shanerudolf.cbmcodechalllenge.viewTest

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.MediumTest
import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import com.shanerudolf.cbmcodechalllenge.MainActivity
import android.support.test.rule.ActivityTestRule
import com.shanerudolf.cbmcodechalllenge.R
import org.junit.Rule
import org.junit.Test


/**
 * Created by shane1 on 2/9/18.
 */
@RunWith(AndroidJUnit4::class)
@MediumTest
class LandingFragmentTest {

    @get:Rule val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkButtonDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.startButton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkDiscoveryFragmentDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.startButton))
                .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.swipeView))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkTitleDisplayed() {
        Espresso.onView(ViewMatchers.withText(R.string.landingFragmentDescription))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}