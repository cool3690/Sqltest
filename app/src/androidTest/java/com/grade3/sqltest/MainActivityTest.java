package com.grade3.sqltest;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.navigation.Navigator;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;

import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
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


        for(int i=0;i<0;i++){
            onView(withId(R.id.acc2)).perform(typeText(2+""));
        }


        onView(withId(R.id.acc2)).perform(typeText("2"),closeSoftKeyboard());
        //通過id找到edittext，在裏面輸入5並關閉輸入法
        onView(withId(R.id.acc2)).perform(clearText(),typeText("5"), closeSoftKeyboard());
        onView( withId(R.id.acc2) ).perform( closeSoftKeyboard() );
        /**/
        onView(withText("login")).perform(click());
      //  Espresso.onView(withId(R.id.Q1)).perform(typeText("wsc2"));
      //  Espresso.onView(withId(R.id.Q2)).perform(typeText("wsc2"));
        onView(withId(R.id.name)).perform(typeText("john"));

      //  Espresso.onView(withId(R.id.acc2)).perform(typeText("5"), closeSoftKeyboard());
        onView(withId(R.id.name)).perform(typeText("john"));
        pressBack();
         
        //onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.acc2)).perform(typeText("5"), closeSoftKeyboard());
    }
    /*
    @Test
    public void NextTest() {
        //通過id找到edittext，在裏面輸入2並關閉輸入法
        //intended(hasComponent(DetailActivity::Ne));
        Espresso.onView(withId(R.id.name)).perform(typeText("john"));
        Espresso.onView(isRoot()).perform(pressBack());
        .
        Espresso.onView(withId(R.id.acc2)).perform(typeText("5"), closeSoftKeyboard());

    }

     */
}
