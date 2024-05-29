package com.example.touristicguide.model;

public class TouristicSite {
    private String name;
    private String location;
    private String description;
    private String type;
    private double latitude;
    private double longitude;
    private String contactInfo;
    private int imageResourceId;  // Change from URL to resource ID

    public TouristicSite(String name, String location, String description, String type, double latitude, double longitude, String contactInfo, int imageResourceId) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.contactInfo = contactInfo;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
