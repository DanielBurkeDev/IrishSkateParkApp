package com.skatdev.irishskateapp.rest;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.skatdev.irishskateapp.models.Skateparks_Model;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Callback;
import retrofit.client.OkClient;


/**
 * Created by skatgroovey on 17/09/2015.
 */
public class RetroRestAdapter {
private String baseUrl = "http://danielburkedev.com/isa";



                //making object of RestAdapter
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")

                .create();

        retrofit.RestAdapter adapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();


    }





