package com.moringaschool.myrestaurants;

//Static espresso
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityImplementationTest extends TestCase {

    @Rule//Launch activity before each test
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);


    //onView - interaction with the view
    //withId - ViewMatcher :Find view by Id
    //typeText - viewAction - Type provided text
    //matches - viewAssertion - validate specific properties of view
    @Test
    public void validateEditText() {
        onView(withId(R.id.locationEditText)).perform(typeText("Sovngarde"))
                .check(matches(withText("Sovngarde")));
    }

    @Test
    public void locationIsSentToRestaurantsActivity() {
        String location = "Nairobi";

        //Close keyboard as the user would and pause for sometime to make sure it is closed
        onView(withId(R.id.locationEditText)).perform(typeText(location)).perform(closeSoftKeyboard());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.findRestaurantsButton)).perform(click());
        onView(withId(R.id.locationTextView)).check(matches
                (withText(String.format("Here Are Restaurants Near: %s",location))));
    }
}