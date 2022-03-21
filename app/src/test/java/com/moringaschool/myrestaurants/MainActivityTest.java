package com.moringaschool.myrestaurants;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)

public class MainActivityTest{

    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent(){
        TextView textView = mainActivity.findViewById(R.id.appNameTextView);
        assertTrue("MyRestaurants".equals(textView.getText().toString()));
    }

    //Shadow test

    @Test
    public void secondActivityStarted(){//Verify whether a second activity is started on button click using shadow class
        mainActivity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(mainActivity, RestaurantsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(mainActivity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}