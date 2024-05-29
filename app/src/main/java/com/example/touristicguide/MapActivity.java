package com.example.touristicguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        latitude = intent.getDoubleExtra("lat", 4.0511); // Default latitude for Douala
        longitude = intent.getDoubleExtra("long", 9.7679); // Default longitude for Douala

        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putDouble("latitude", latitude);
            bundle.putDouble("longitude", longitude);

            MapsFragment mapsFragment = new MapsFragment();
            mapsFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.map, mapsFragment)
                    .commit();
        }
    }
}
