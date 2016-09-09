package com.skatdev.irishskateapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.skatdev.irishskateapp.DB.DBHandler;
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

public class Main2Activity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private DBHandler db;

    private RecyclerView recyclerView;
    private ArrayList<Skateparks_Model> data;
    private ArrayList<Skateparks_Model> parks;
    private DataAdapter adapter;
    private Toolbar toolbar;
    private Button btn_moreinfo;

    private String name, description, address, phone, email, str_latitude, str_longitude,
            str_ratings, image, comment, website, location;
    private double dbl_latitude, dbl_longitude;
    private int int_ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initViews();
        // SQLite database handler
        db = new DBHandler(getApplicationContext());
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        btn_moreinfo = (Button) findViewById(R.id.more_info);
//        btn_moreinfo.setOnClickListener(new ButtonListener());

        loadJSON();


    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://danielburkedev.com/isa/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONParksResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONParksResponse>() {
            @Override
            public void onResponse(Call<JSONParksResponse> call, Response<JSONParksResponse> response) {

                JSONParksResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getParks()));

                String test = new Gson().toJson(data);

                Log.d("Test data JSon ", "" + test);
                Log.d("Test data ", "" + data.toString());
                Log.d("Test data ", "" + String.valueOf(data));

                adapter = new DataAdapter(data, this);
                recyclerView.setAdapter(adapter);


                int count = data.size();
                Log.d("Test size ", "" + count);


                addParksToDB(data);

            }

            @Override
            public void onFailure(Call<JSONParksResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void addParksToDB(ArrayList<Skateparks_Model> data) {


            for (int x = 0; x < data.size(); x++) {
                //System.out.println(data.get(x).getmIsa_name());

                name = data.get(x).getmIsa_name();
                System.out.println(name);
                description = data.get(x).getmIsa_description();
                System.out.println(description);
                address = data.get(x).getmIsa_address();
                System.out.println(address);
                phone = data.get(x).getmIsa_phone();
                System.out.println(phone);
                email = data.get(x).getmIsa_email();
                System.out.println(email);
                dbl_latitude = data.get(x).getmIsa_latitude();
                str_latitude = String.valueOf(dbl_latitude);
                System.out.println(str_latitude);
                dbl_longitude = data.get(x).getmIsa_longitude();
                str_longitude = String.valueOf(dbl_longitude);
                System.out.println(str_longitude);
                int_ratings = data.get(x).getmIsa_rating();
                str_ratings = String.valueOf(int_ratings);
                System.out.println(str_ratings);
                image = data.get(x).getmIsa_image();
                System.out.println(image);
                comment = data.get(x).getmIsa_comment();
                System.out.println(comment);
                website = data.get(x).getmIsa_website();
                System.out.println(website);
                location = data.get(x).getmIsa_location();
                System.out.println(location);

                db.addParks(name, description, address, phone, email, str_latitude, str_longitude,
                        str_ratings, image, comment, website, location);
            }





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        final ArrayList<Skateparks_Model>  filteredModelList = filter(data, newText.trim());

        Log.d("skatd", "test filteredlist" + filteredModelList.toString());

        adapter.setFilter(filteredModelList);

        return true;
    }

    private ArrayList<Skateparks_Model> filter(ArrayList<Skateparks_Model> models, String query) {
        query = query.toLowerCase();

        final ArrayList<Skateparks_Model> filteredModelList = new ArrayList<>();
        for (Skateparks_Model model : models) {
            final String text = model.getmIsa_location().toLowerCase();

            Log.d("skatd","case test " + text + " " + query);

            if (text.contains(query)) {

                filteredModelList.add(model);
                Log.d("skatd", "filteredModelList" + filteredModelList.toString() );
            }
        }
        return filteredModelList;
    }
}
