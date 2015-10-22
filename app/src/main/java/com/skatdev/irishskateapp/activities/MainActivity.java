package com.skatdev.irishskateapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.models.Skateparks_Model;

import com.skatdev.irishskateapp.rest.interfaces.SkateParks_Inter;
import com.skatdev.irishskateapp.rest.service_generator.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    private Button btn_maps;
    private Toolbar toolbar;
//    private String baseUrl = "http://skatdev.com/tst/isa";
//    private String parkname = "";
//    private ArrayList<Skateparks_Model> skateparks = new ArrayList<Skateparks_Model>();
//    private Object lats;
//    private Object longs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
//        toolbar.setLogo(R.drawable.inspect_logo_080615);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //
        btn_maps = (Button) findViewById(R.id.btn_map);
        btn_maps.setOnClickListener(new ButtonListener());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    private void getJSON() {
//
//        // Create a very simple REST adapter which points the GitHub API endpoint.
//        SkateParks_Inter skateParks_inter = ServiceGenerator.createService(SkateParks_Inter.class, baseUrl);
//
//        skateParks_inter.getSkateParks(new Callback<List<Skateparks_Model>>() {
//            @Override
//            public void success(List<Skateparks_Model> skateparks_models, Response response) {
//
//                Log.d("parkName", " " + skateparks_models.toString());
//                //loop through to get lat + long
//                for (Skateparks_Model sm : skateparks_models) {
//                    lats = sm.getmIsa_latitude();
//                    longs = sm.getmIsa_longitude();
//                    Log.d("lat and longs ", " " + lats + " " + longs);
//
////                    Object parkNames = sm.getmIsa_name();
////                    Log.d("parknames ", " " + parkNames);
//                }
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//
//                Log.e("parkName", " " + error.toString());
//            }
//
//        });
//        //////////////////////////////
//
//
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_map:
                    Toast.makeText(getApplicationContext(), "open maps",
                            Toast.LENGTH_SHORT).show();
//                    getJSON();
                    // Launch main activity
                    Intent intent = new Intent(MainActivity.this,
                            SkatePark_Map_Activity.class);
                    startActivity(intent);
                    break;

                default:
                    Toast.makeText(getApplicationContext(), "No options selected",
                            Toast.LENGTH_SHORT).show();
            }
        }
    }
}
