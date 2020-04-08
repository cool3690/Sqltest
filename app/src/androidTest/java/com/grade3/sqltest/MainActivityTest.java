package com.grade3.sqltest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        //通過id找到edittext，在裏面輸入2並關閉輸入法
        for(int i=0;i<3;i++){
            Espresso.onView(withId(R.id.acc)).perform(typeText("2"));
        }
        Espresso.onView( withId(R.id.acc) ).perform( closeSoftKeyboard() );
        Espresso.onView(withText("login")).perform(click());

        // Espresso.pressBack();
    }
    public void NextTest() {
        //通過id找到edittext，在裏面輸入2並關閉輸入法
        //intended(hasComponent(DetailActivity::Ne));
        Espresso.onView(withId(R.id.textView2)).perform(typeText("wsc2"));
        Espresso.onView(withId(R.id.textView2)).perform(typeText("wsc2"));
    }
}
