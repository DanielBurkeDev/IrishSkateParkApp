package com.skatdev.irishskateapp.models;

import com.google.gson.annotations.SerializedName;

public class Skateparks_Model {
    @SerializedName("isa_skateparksid")
    private int mIsa_skateparksid;
    @SerializedName("isa_name")
    private String mIsa_name;
    @SerializedName("isa_description")
    private String mIsa_description;
    @SerializedName("isa_address")
    private String mIsa_address;
    @SerializedName("isa_phone")
    private String mIsa_phone;
    @SerializedName("isa_email")
    private String mIsa_email;
    @SerializedName("isa_latitude")
    private double mIsa_latitude;
    @SerializedName("isa_longitude")
    private double mIsa_longitude;
    @SerializedName("isa_ratings")
    private int mIsa_rating;
    @SerializedName("isa_image")
    private String mIsa_image;
    @SerializedName("isa_comment")
    private String mIsa_comment;
    @SerializedName("isa_website")
    private String mIsa_website;
    @SerializedName("isa_locations_id")
    private int mIsa_locations_id;
    @SerializedName("isa_location")
    private String mIsa_location;
//    private int id, ratings;
//    private String name, descr, addr, phone, email, img, comment, website;
//    private double lats, longs;


    public Skateparks_Model() {
    }

    public Skateparks_Model(int mIsa_skateparksid, String mIsa_name, String mIsa_description, String mIsa_address, String mIsa_phone, String mIsa_email,
                            double mIsa_latitude, double mIsa_longitude, int mIsa_rating, String mIsa_image, String mIsa_comment, String mIsa_website, int mIsa_locations_id, String mIsa_location) {
        this.mIsa_skateparksid = mIsa_skateparksid;
        this.mIsa_name = mIsa_name;
        this.mIsa_description = mIsa_description;
        this.mIsa_address = mIsa_address;
        this.mIsa_phone = mIsa_phone;
        this.mIsa_email = mIsa_email;
        this.mIsa_latitude = mIsa_latitude;
        this.mIsa_longitude = mIsa_longitude;
        this.mIsa_rating = mIsa_rating;
        this.mIsa_image = mIsa_image;
        this.mIsa_comment = mIsa_comment;
        this.mIsa_website = mIsa_website;
        this.mIsa_locations_id = mIsa_locations_id;
        this.mIsa_location = mIsa_location;
    }

    public int getmIsa_skateparksid() {
        return mIsa_skateparksid;
    }

    public String getmIsa_name() {
        return mIsa_name;
    }

    public String getmIsa_description() {
        return mIsa_description;
    }

    public String getmIsa_address() {
        return mIsa_address;
    }

    public String getmIsa_phone() {
        return mIsa_phone;
    }

    public String getmIsa_email() {
        return mIsa_email;
    }

    public double getmIsa_latitude() {

        return mIsa_latitude;
    }

    public double getmIsa_longitude() {

        return mIsa_longitude;
    }

    public int getmIsa_rating() {
        return mIsa_rating;
    }

    public String getmIsa_image() {
        return mIsa_image;
    }

    public String getmIsa_comment() {
        return mIsa_comment;
    }

    public String getmIsa_website() {
        return mIsa_website;
    }

    public int getmIsa_locations_id() {
        return mIsa_locations_id;
    }

    public String getmIsa_location() {
        return mIsa_location;
    }

    public void setmIsa_location(String mIsa_location) {
        this.mIsa_location = mIsa_location;
    }

    @Override
    public String toString() {
        return "Skateparks_Model{" +
                "mIsa_skateparksid=" + mIsa_skateparksid +
                ", mIsa_name='" + mIsa_name + '\'' +
                ", mIsa_description='" + mIsa_description + '\'' +
                ", mIsa_address='" + mIsa_address + '\'' +
                ", mIsa_phone='" + mIsa_phone + '\'' +
                ", mIsa_email='" + mIsa_email + '\'' +
                ", mIsa_latitude=" + mIsa_latitude +
                ", mIsa_longitude=" + mIsa_longitude +
                ", mIsa_rating=" + mIsa_rating +
                ", mIsa_image=" + mIsa_image +
                ", mIsa_comment='" + mIsa_comment + '\'' +
                ", mIsa_website='" + mIsa_website + '\'' +
                ", mIsa_locations_id=" + mIsa_locations_id +
                ", mIsa_location='" + mIsa_location + '\'' +
                '}';
    }
}

