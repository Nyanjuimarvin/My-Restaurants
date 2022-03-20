package com.moringaschool.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                //Intent - Provides RunTime Binding between separate components ex: different Activities
                //params :: packageContext
                Intent intent = new Intent(MainActivity.this,RestaurantsActivity.class);
                startActivity(intent);
            }
        });
    }
}

