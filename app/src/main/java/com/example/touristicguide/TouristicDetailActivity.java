package com.example.touristicguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TouristicDetailActivity extends AppCompatActivity {

    private ImageView siteImageView;
    private TextView nameTextView;
    private TextView locationTextView;
    private TextView descriptionTextView;
    private TextView typeTextView;
    private TextView latitudeTextView;
    private TextView longitudeTextView;
    private TextView contactInfoTextView;
    Button go_to_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        siteImageView = findViewById(R.id.siteImageView);
        nameTextView = findViewById(R.id.nameTextView);
        locationTextView = findViewById(R.id.locationTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        typeTextView = findViewById(R.id.typeTextView);
        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);
        contactInfoTextView = findViewById(R.id.contactInfoTextView);
        go_to_map = findViewById(R.id.gomap);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String location = intent.getStringExtra("location");
            String description = intent.getStringExtra("description");
            String type = intent.getStringExtra("type");
            double latitude = intent.getDoubleExtra("latitude", 0);
            double longitude = intent.getDoubleExtra("longitude", 0);
            String contactInfo = intent.getStringExtra("contactInfo");
            int imageResourceId = intent.getIntExtra("imageResourceId", 0);

            nameTextView.setText(name);
            locationTextView.setText(location);
            descriptionTextView.setText(description);
            typeTextView.setText(type);
            latitudeTextView.setText(String.valueOf(latitude));
            longitudeTextView.setText(String.valueOf(longitude));
            contactInfoTextView.setText(contactInfo);
            siteImageView.setImageResource(imageResourceId);
            go_to_map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TouristicDetailActivity.this, MapActivity.class);
                    intent.putExtra("long", longitude);
                    intent.putExtra("lat", latitude);
                    startActivity(intent);
                }
            });
        }
    }
}
