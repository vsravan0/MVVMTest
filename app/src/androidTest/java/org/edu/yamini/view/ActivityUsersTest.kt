package org.edu.yamini.view

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.action.ViewActions.click
import androidx.test.filters.LargeTest
import org.edu.yamini.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class ActivityUsersTest {

    private lateinit var scenario : ActivityScenario<ActivityUsers>


    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(ActivityUsers::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun loadUsers() {
        Espresso.onView(ViewMatchers.withId(R.id.id_btn_loadusers)).perform(click())
        Thread.sleep(2000)
    }
}