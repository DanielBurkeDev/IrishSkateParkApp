package com.skatdev.irishskateapp.rest_rv;

import com.skatdev.irishskateapp.models.JSONParksResponse;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by skatgroovey on 08/07/2016.
 */
public interface RequestInterface {

//    @GET("android/jsonandroid")
@GET("isa_skateparksdb.php")
Call<JSONParksResponse> getJSON();
}