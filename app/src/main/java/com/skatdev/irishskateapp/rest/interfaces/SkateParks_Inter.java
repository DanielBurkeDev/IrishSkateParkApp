package com.skatdev.irishskateapp.rest.interfaces;

import com.skatdev.irishskateapp.models.Skateparks_Model;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by skatgroovey on 25/09/2015.
 */
public interface SkateParks_Inter {

    @GET("/isa_skateparksdb.php")
    void getSkateParks( Callback<List<Skateparks_Model>> cb);
}
