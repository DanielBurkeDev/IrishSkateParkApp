package com.skatdev.irishskateapp.models;

import com.google.gson.annotations.SerializedName;

public class Skateparks_Model {
    public String isa_image_path = "http://danielburkedev.com/isa/images/";

    @SerializedName("isa_skateparksid")
    private int mIsa_skateparksid;
    @SerializedName("isa_name")
    private String mIsa_name;
    @SerializedName("isa_description")
    private String mIsa_description;

    @SerializedName("isa_lights")
    private String mIsa_lights;
    @SerializedName("isa_helmets")
    private String mIsa_helmets;
    @SerializedName("isa_indoor_outdoor")
    private String mIsa_indoor_outdoor;
    @SerializedName("isa_surface")
    private String mIsa_surface;
    @SerializedName("isa_opening_hours")
    private String mIsa_opening_hours;
    @SerializedName("isa_cost")
    private String mIsa_cost;
    @SerializedName("isa_address")
    private String mIsa_address;
    @SerializedName("isa_phone")
    private String mIsa_phone;
    @SerializedName("isa_email")
    private String mIsa_email;
    @SerializedName("isa_latitude")
    private String mIsa_latitude;
    @SerializedName("isa_longitude")
    private String mIsa_longitude;
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

    public Skateparks_Model(int mIsa_skateparksid, String mIsa_name, String mIsa_description, String mIsa_lights, String mIsa_helmets, String mIsa_indoor_outdoor,
                            String mIsa_surface, String mIsa_opening_hours, String mIsa_cost, String mIsa_address, String mIsa_phone, String mIsa_email,
                            String mIsa_latitude, String mIsa_longitude, int mIsa_rating, String mIsa_image, String mIsa_comment, String mIsa_website, int mIsa_locations_id, String mIsa_location) {
        this.mIsa_skateparksid = mIsa_skateparksid;
        this.mIsa_name = mIsa_name;
        this.mIsa_description = mIsa_description;
        this.mIsa_lights = mIsa_lights;
        this.mIsa_helmets = mIsa_helmets;
        this.mIsa_indoor_outdoor = mIsa_indoor_outdoor;
        this.mIsa_surface = mIsa_surface;
        this.mIsa_opening_hours = mIsa_opening_hours;
        this.mIsa_cost = mIsa_cost;
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

    public void setmIsa_skateparksid(int mIsa_skateparksid) {
        this.mIsa_skateparksid = mIsa_skateparksid;
    }

    public String getmIsa_name() {
        return mIsa_name;
    }

    public void setmIsa_name(String mIsa_name) {
        this.mIsa_name = mIsa_name;
    }

    public String getmIsa_description() {
        return mIsa_description;
    }

    public void setmIsa_description(String mIsa_description) {
        this.mIsa_description = mIsa_description;
    }

    public String getmIsa_lights() {
        return mIsa_lights;
    }

    public void setmIsa_lights(String mIsa_lights) {
        this.mIsa_lights = mIsa_lights;
    }

    public String getmIsa_helmets() {
        return mIsa_helmets;
    }

    public void setmIsa_helmets(String mIsa_helmets) {
        this.mIsa_helmets = mIsa_helmets;
    }

    public String getmIsa_indoor_outdoor() {
        return mIsa_indoor_outdoor;
    }

    public void setmIsa_indoor_outdoor(String mIsa_indoor_outdoor) {
        this.mIsa_indoor_outdoor = mIsa_indoor_outdoor;
    }

    public String getmIsa_surface() {
        return mIsa_surface;
    }

    public void setmIsa_surface(String mIsa_surface) {
        this.mIsa_surface = mIsa_surface;
    }

    public String getmIsa_opening_hours() {
        return mIsa_opening_hours;
    }

    public void setmIsa_opening_hours(String mIsa_opening_hours) {
        this.mIsa_opening_hours = mIsa_opening_hours;
    }

    public String getmIsa_cost() {
        return mIsa_cost;
    }

    public void setmIsa_cost(String mIsa_cost) {
        this.mIsa_cost = mIsa_cost;
    }

    public String getmIsa_address() {
        return mIsa_address;
    }

    public void setmIsa_address(String mIsa_address) {
        this.mIsa_address = mIsa_address;
    }

    public String getmIsa_phone() {
        return mIsa_phone;
    }

    public void setmIsa_phone(String mIsa_phone) {
        this.mIsa_phone = mIsa_phone;
    }

    public String getmIsa_email() {
        return mIsa_email;
    }

    public void setmIsa_email(String mIsa_email) {
        this.mIsa_email = mIsa_email;
    }

    public String getmIsa_latitude() {
        return mIsa_latitude;
    }

    public void setmIsa_latitude(String mIsa_latitude) {
        this.mIsa_latitude = mIsa_latitude;
    }

    public String getmIsa_longitude() {
        return mIsa_longitude;
    }

    public void setmIsa_longitude(String mIsa_longitude) {
        this.mIsa_longitude = mIsa_longitude;
    }

    public int getmIsa_rating() {
        return mIsa_rating;
    }

    public void setmIsa_rating(int mIsa_rating) {
        this.mIsa_rating = mIsa_rating;
    }

    public String getmIsa_image() {
        return isa_image_path + mIsa_image;
    }

    public void setmIsa_image(String mIsa_image) {
        this.mIsa_image = mIsa_image;
    }

    public String getmIsa_comment() {
        return mIsa_comment;
    }

    public void setmIsa_comment(String mIsa_comment) {
        this.mIsa_comment = mIsa_comment;
    }

    public String getmIsa_website() {
        return mIsa_website;
    }

    public void setmIsa_website(String mIsa_website) {
        this.mIsa_website = mIsa_website;
    }

    public int getmIsa_locations_id() {
        return mIsa_locations_id;
    }

    public void setmIsa_locations_id(int mIsa_locations_id) {
        this.mIsa_locations_id = mIsa_locations_id;
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
                ", mIsa_lights='" + mIsa_lights + '\'' +
                ", mIsa_helmets='" + mIsa_helmets + '\'' +
                ", mIsa_indoor_outdoor='" + mIsa_indoor_outdoor + '\'' +
                ", mIsa_surface='" + mIsa_surface + '\'' +
                ", mIsa_opening_hours='" + mIsa_opening_hours + '\'' +
                ", mIsa_cost='" + mIsa_cost + '\'' +
                ", mIsa_address='" + mIsa_address + '\'' +
                ", mIsa_phone='" + mIsa_phone + '\'' +
                ", mIsa_email='" + mIsa_email + '\'' +
                ", mIsa_latitude=" + mIsa_latitude +
                ", mIsa_longitude=" + mIsa_longitude +
                ", mIsa_rating=" + mIsa_rating +
                ", mIsa_image='" + mIsa_image + '\'' +
                ", mIsa_comment='" + mIsa_comment + '\'' +
                ", mIsa_website='" + mIsa_website + '\'' +
                ", mIsa_locations_id=" + mIsa_locations_id +
                ", mIsa_location='" + mIsa_location + '\'' +
                '}';
    }
}

