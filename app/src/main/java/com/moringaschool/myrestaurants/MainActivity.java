package com.moringaschool.myrestaurants;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.moringaschool.myrestaurants.databinding.ActivityMainBinding;
import com.moringaschool.myrestaurants.databinding.ActivityRestaurantsBinding;


public class MainActivity extends AppCompatActivity {

      ActivityMainBinding mainBinding;

    //Refers to the class's simple name :: Same as public static final String TAG = "MainActivity"
    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        //Add Click Listener to button
        //Set OnClick takes new onClickListener as Arg
        mainBinding.findRestaurantsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Toast
                // Simple pop-up message when button is clicked
                // toast(context,message,duration).show();

                //Save user input and convert it from editable to a String
                String location = mainBinding.locationEditText.getText().toString();
                Log.d(TAG, location);//d Send debug log message

                //Intent - Provides RunTime Binding between separate components ex: different Activities
                Intent intent = new Intent(MainActivity.this,RestaurantsActivity.class);//params :: packageContext
                intent.putExtra("location",location);//putExtra()-> Pass Data Between Activities
                startActivity(intent);
                Toast.makeText(MainActivity.this,location,Toast.LENGTH_LONG).show();
            }
        });
    }
}

