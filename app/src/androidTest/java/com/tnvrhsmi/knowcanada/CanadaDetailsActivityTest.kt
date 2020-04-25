package com.tnvrhsmi.knowcanada
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class CanadaDetailsActivityTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.tnvrhsmi.knowcanada", appContext.packageName)
    }


    @get:Rule
    var mActivityRule: ActivityTestRule<CanadaDetailsActivity> = ActivityTestRule(
        CanadaDetailsActivity::class.java
    )

    @Test
    fun testFactErrorMessageDisplayed() {
        onView(withText(R.string.alert_title)).check(matches(isDisplayed()))
    }

    @Test
    fun testFactsFetched() {
        val recyclerView =
            mActivityRule.activity.findViewById(R.id.canada_details_list) as RecyclerView
        val itemCount =recyclerView.adapter!!.itemCount >0
        assertTrue(itemCount)
    }


}
