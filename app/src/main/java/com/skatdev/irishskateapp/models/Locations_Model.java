package com.skatdev.irishskateapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by skatgroovey on 29/08/2016.
 */
public class Locations_Model {
    @SerializedName("isa_locations_id")
    private int mIsa_locations_id;
    @SerializedName("isa_location")
    private String mIsa_location;

    public Locations_Model(int mIsa_locations_id, String mIsa_location) {
        this.mIsa_locations_id = mIsa_locations_id;
        this.mIsa_location = mIsa_location;
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
        return "Locations_Model{" +
                "mIsa_locations_id=" + mIsa_locations_id +
                ", mIsa_location='" + mIsa_location + '\'' +
                '}';
    }


}
