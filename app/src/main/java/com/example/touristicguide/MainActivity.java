package com.example.touristicguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.touristicguide.adapter.TouristicAdapter;
import com.example.touristicguide.model.TouristicSite;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView touristicRecyclerView;
    private TouristicAdapter touristicAdapter;
    private TextView mapView, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.map);
        home = findViewById(R.id.home);
        touristicRecyclerView = findViewById(R.id.recyclerview);
        touristicRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<TouristicSite> touristicSiteList = new ArrayList<>();
        touristicSiteList.add(new TouristicSite("Mount Cameroon", "Buea, Cameroon", "Mount Cameroon, also known as Mongo ma Ndemi (Mountain of Greatness), is the highest mountain in West Africa.", "Natural Site", 4.2214, 9.1700, "contact@mountcameroon.com", R.drawable.mount_cam));
        touristicSiteList.add(new TouristicSite("Waza National Park", "Far North, Cameroon", "Waza National Park is one of Cameroon’s most visited parks, offering a chance to see a variety of wildlife.", "National Park", 11.3061, 14.7492, "contact@wazapark.com", R.drawable.waza));
        touristicSiteList.add(new TouristicSite("Douala", "Littoral, Cameroon", "Douala is the largest city and economic capital of Cameroon, known for its vibrant culture and nightlife.", "City", 4.0503, 9.7679, "contact@douala.com", R.drawable.douala));
        touristicSiteList.add(new TouristicSite("Yaoundé", "Central, Cameroon", "Yaoundé is the capital city of Cameroon, featuring several museums, monuments, and administrative buildings.", "City", 3.8480, 11.5021, "contact@yaounde.com", R.drawable.yaounde));
        touristicSiteList.add(new TouristicSite("Kribi", "South, Cameroon", "Kribi is a coastal town known for its beautiful beaches, seafood, and the Chutes de la Lobé waterfall.", "Beach", 2.9388, 9.9071, "contact@kribi.com", R.drawable.kribi));

        touristicAdapter = new TouristicAdapter(touristicSiteList, this);
        touristicRecyclerView.setAdapter(touristicAdapter);

        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }
}
