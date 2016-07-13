package com.skatdev.irishskateapp.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.models.Skateparks_Model;
import com.skatdev.irishskateapp.rest.interfaces.SkateParks_Inter;
import com.skatdev.irishskateapp.rest.service_generator.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SkatePark_Map_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String baseUrl = "http://therestoredself.com/isa";
    private String parkname = "";

    private List skateparks_models;
    private int id, ratings;
    private String name, descr, addr, phone, email, img, comment, website;
    private double lats, longs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_skate_park__map);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        Log.d("onMapReady ", " arrived at onMapReady");
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //call rest api
      // getJSON();

        //        // Add a marker in Sydney and move the camera
//        LatLng sp1 = new LatLng(lats, longs);
//        mMap.addMarker(new MarkerOptions()
//                .position(sp1)
//                .title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sp1));

//        //gets lat longs from model via loop
//        ArrayList<Skateparks_Model> latlongs = new ArrayList<Skateparks_Model>();
//        for(int i = 0 ; i < latlongs.size() ; i++ ) {
//
//            createMarkers(latlongs.get(i).getmIsa_latitude(), latlongs.get(i).getmIsa_longitude());
//            Log.d("marker latlongs ", " " + latlongs.toString());
//        }


    }

    private void getJSON() {

        // Create a very simple REST adapter which points the API endpoint.
        SkateParks_Inter skateParks_inter = ServiceGenerator.createService(SkateParks_Inter.class, baseUrl);

        skateParks_inter.getSkateParks(new Callback<List<Skateparks_Model>>() {
            @Override
            public void success(List<Skateparks_Model> skateparks_models, Response response) {

                Log.d("skatd", "parkName: " + skateparks_models.toString());

                ArrayList<Skateparks_Model> skateparks = new ArrayList<>();

                //loop through to get lat + long
                for (Skateparks_Model sm : skateparks_models) {
                    id = sm.getmIsa_skateparksid();
                    name = sm.getmIsa_name();
                    descr = sm.getmIsa_description();
                    addr = sm.getmIsa_description();
                    phone = sm.getmIsa_phone();
                    email = sm.getmIsa_email();
                    lats = sm.getmIsa_latitude();
                    longs = sm.getmIsa_longitude();
                    ratings = sm.getmIsa_rating();
                  //  img = sm.getmIsa_image();
                    comment = sm.getmIsa_comment();
                    website = sm.getmIsa_website();

                    // createMarkers(lats, longs);
                    Log.d("skatd", "marker latlongs: " + lats + " " + longs);


                    // createMarkers(lats, longs);
//                    Object parkNames = sm.getmIsa_name();
//                    Log.d("parknames ", " " + parkNames);

                    //   skateparks.add(new Skateparks_Model(id, name, descr, addr, phone, email, lats, longs, ratings, img, comment, website));
                    //   Log.d("skatd", "skateparks arraylist:  " + skateparks.toString());
                    createMarkersList(id, name, descr, addr, phone, email, lats, longs, ratings, img, comment, website);
                }


            }

            @Override
            public void failure(RetrofitError error) {

                Log.e("skatd", "parkNameErr: " + error.toString());
            }

        });
        //////////////////////////////


    }

//    private void createMarkers(double latitude, double longitude){
//
//         mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(latitude, longitude))
//                .anchor(0.5f, 0.5f));
//
//
//        CameraPosition cameraPosition = new CameraPosition.Builder().target(
//                new LatLng(53.287452, -6.153869)).zoom(8).build();
//
//        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//    }

    private void createMarkersList(int id, String name, String descr, String addr, String phone, String email, double lats, double longs, int ratings, String img, String comment, String website) {

        Log.d("skatd", "createmarker lat longs: " + lats + " " + longs);

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(lats, longs))
                .title(name)
                .snippet(descr)
                .anchor(0.5f, 0.5f));



        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(53.287452, -6.153869)).zoom(8).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
