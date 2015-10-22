package com.skatdev.irishskateapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by skatgroovey on 31/08/2015.
 */
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

    public Skateparks_Model(){

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
                ", mIsa_image='" + mIsa_image + '\'' +
                ", mIsa_comment='" + mIsa_comment + '\'' +
                ", mIsa_website='" + mIsa_website + '\'' +
                '}';
    }
}

