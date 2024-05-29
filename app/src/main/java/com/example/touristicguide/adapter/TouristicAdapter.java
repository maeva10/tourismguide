package com.example.touristicguide.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.touristicguide.R;
import com.example.touristicguide.model.TouristicSite;

import java.util.List;

public class TouristicAdapter extends RecyclerView.Adapter<TouristicAdapter.TouristicSiteViewHolder> {

    private List<TouristicSite> touristicSiteList;
    private Context context;

    public TouristicAdapter(List<TouristicSite> touristicSiteList, Context context) {
        this.touristicSiteList = touristicSiteList;
        this.context = context;
    }

    @NonNull
    @Override
    public TouristicSiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sites, parent, false);
        return new TouristicSiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TouristicSiteViewHolder holder, int position) {
        TouristicSite site = touristicSiteList.get(position);
        holder.bind(site);
    }

    @Override
    public int getItemCount() {
        return touristicSiteList.size();
    }

    public class TouristicSiteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView siteImageView;
        private TextView nameTextView;
        private TextView locationTextView;
        private TextView descriptionTextView;
        private TouristicSite currentSite;

        public TouristicSiteViewHolder(@NonNull View itemView) {
            super(itemView);
            siteImageView = itemView.findViewById(R.id.siteImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            itemView.setOnClickListener(this);
        }

        public void bind(TouristicSite site) {
            currentSite = site;
            nameTextView.setText(site.getName());
            locationTextView.setText(site.getLocation());
            descriptionTextView.setText(site.getDescription());
            siteImageView.setImageResource(site.getImageResourceId());  // Load image using resource ID
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, com.example.touristicguide.TouristicDetailActivity.class);
            intent.putExtra("name", currentSite.getName());
            intent.putExtra("location", currentSite.getLocation());
            intent.putExtra("description", currentSite.getDescription());
            intent.putExtra("type", currentSite.getType());
            intent.putExtra("latitude", currentSite.getLatitude());
            intent.putExtra("longitude", currentSite.getLongitude());
            intent.putExtra("contactInfo", currentSite.getContactInfo());
            intent.putExtra("imageResourceId", currentSite.getImageResourceId());
            context.startActivity(intent);
        }
    }
}
