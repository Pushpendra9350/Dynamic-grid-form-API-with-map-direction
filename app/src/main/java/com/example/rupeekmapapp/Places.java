package com.example.rupeekmapapp;

public class Places {

    private String id;
    private String name;
    private String imageurl;
    private String longitude;
    private String latitude;
    private String address;

    public Places() {
    }

    public Places(String id, String name, String imageurl, String longitude, String latitude, String address) {
        this.id = id;
        this.name = name;
        this.imageurl = imageurl;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
