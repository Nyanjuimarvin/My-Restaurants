package com.moringaschool.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.myrestaurants.databinding.ActivityRestaurantsBinding;

public class RestaurantsActivity extends AppCompatActivity {

    ActivityRestaurantsBinding restaurantsBinding;
    //Hard ListView Array
    private final String[] restaurants = new String[] {"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantsBinding = ActivityRestaurantsBinding.inflate(getLayoutInflater());
        View view = restaurantsBinding.getRoot();
        setContentView(view);

        TextView textview = (TextView) findViewById(R.id.locationTextView);
        ListView listView = (ListView) findViewById(R.id.listView);

        //Array Adapter : Args(current context,android layout,list)
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,restaurants);
        listView.setAdapter(adapter);

        //onItemClickListener -> Display toast text when listItem from listView is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView) view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        textview.setText(String.format("Here Are Restaurants Near: %s",location));

    }
}