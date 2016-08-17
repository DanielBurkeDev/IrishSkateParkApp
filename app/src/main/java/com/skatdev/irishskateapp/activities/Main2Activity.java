package com.skatdev.irishskateapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.adapters.DataAdapter;
import com.skatdev.irishskateapp.models.JSONParksResponse;
import com.skatdev.irishskateapp.models.Skateparks_Model;
import com.skatdev.irishskateapp.rest_rv.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private ArrayList<Skateparks_Model> data;
    private DataAdapter adapter;

    private Button btn_moreinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        btn_moreinfo = (Button) findViewById(R.id.more_info);
//        btn_moreinfo.setOnClickListener(new ButtonListener());

        loadJSON();


    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://therestoredself.com/isa/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONParksResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONParksResponse>() {
            @Override
            public void onResponse(Call<JSONParksResponse> call, Response<JSONParksResponse> response) {

                JSONParksResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getParks()));

                Log.d("Test data ", data.toString());
                adapter = new DataAdapter(data, this);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<JSONParksResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }



}
