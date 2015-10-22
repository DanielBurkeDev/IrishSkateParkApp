package com.skatdev.irishskateapp.rest;

import com.skatdev.irishskateapp.models.Skateparks_Model;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by skatgroovey on 15/09/2015.
 */
public interface SkateParks_API {
    String BASE_URL = "http://skatdev.com/tst/isa";

    @GET("/isa_skateparksdb.php")
    void getSkateParks( Callback<Skateparks_Model> cb);





}
