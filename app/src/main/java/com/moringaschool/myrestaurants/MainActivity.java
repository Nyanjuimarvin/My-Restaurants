package com.moringaschool.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Refers to the class's simple name :: Same as public static final String TAG = "MainActivity"
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        //Find Edit Text Field
        EditText locationEditText = (EditText) findViewById(R.id.locationEditText);

        //Cast View to Button
        Button findRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);

        //Add Click Listener to button
        //Set OnClick takes new onClickListener
        findRestaurantsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast
                // Simple pop-up message when button is clicked
                // toast(context,message,duration).show();
                // Toast.makeText(MainActivity.this,"Hello There",Toast.LENGTH_LONG).show();

                //Save user input and convert it from editable to a String
                String location = locationEditText.getText().toString();
                Log.d(TAG, location);

                //Intent - Provides RunTime Binding between separate components ex: different Activities
                //params :: packageContext
                Intent intent = new Intent(MainActivity.this,RestaurantsActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,location,Toast.LENGTH_LONG).show();
            }
        });
    }
}

