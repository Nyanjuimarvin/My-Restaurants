package com.moringaschool.myrestaurants;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import android.view.View;
import android.view.Window;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import butterknife.BindView;

@RunWith(AndroidJUnit4.class)
public class RestaurantsActivityImplementationTest extends TestCase {

    @Rule
    public ActivityScenarioRule<RestaurantsActivity> restaurantActivityRule = new ActivityScenarioRule<>(RestaurantsActivity.class);

    // *Window Management Class
    private View activityDecorView;

    @Before
    public void setUp(){
        restaurantActivityRule.getScenario().onActivity(new ActivityScenario.ActivityAction<RestaurantsActivity>() {
            @Override
            public void perform(RestaurantsActivity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test//Test for toast
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        String restaurantName = "Mi Mero Mole";
        onData(anything())//
                .inAdapterView(withId(R.id.listView))
                .atPosition(0)
                .perform(click());
        onView(withText(restaurantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restaurantName)));
    }
}