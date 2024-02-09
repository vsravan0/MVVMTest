package org.edu.yamini.view

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.edu.yamini.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ActivityLoginTest {

    private lateinit var scenario  : ActivityScenario<ActivityLogin>


    @Before
    fun setUp() {
        scenario = launch(ActivityLogin::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED) // onStart
    }

    @Test
    fun testLogin() {
        val unm ="yamini"
        val pwd ="yamini123"
        //Espresso.onView(ViewMatchers.withId(R.id.id_et_unm)).perform(ViewActions.typeText(unm))
        onView(withId(R.id.id_et_unm)).perform(ViewActions.typeText(unm))
        onView(withId(R.id.id_et_pwd)).perform(ViewActions.typeText(pwd))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.id_btn_login)).perform(ViewActions.click())

        onView(withText(unm)).check(matches(isDisplayed()))
        onView(withText(pwd)).check(matches(isDisplayed()))



        Thread.sleep(3000)

    }

}