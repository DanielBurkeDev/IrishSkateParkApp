package com.skatdev.irishskateapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.models.Marker_Model;
import com.skatdev.irishskateapp.models.Skateparks_Model;
import com.skatdev.irishskateapp.rest.interfaces.SkateParks_Inter;
import com.skatdev.irishskateapp.rest.service_generator.ServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MapsActivity extends FragmentActivity {
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private HashMap<Marker, Marker_Model> mMarkersHashMap;
    private ArrayList<Marker_Model> mMyMarkersArray = new ArrayList<Marker_Model>();

    private String baseUrl = "http://skatdev.com/tst/isa";
    private String parkname = "";
    private ArrayList<Skateparks_Model> skateparks = new ArrayList<Skateparks_Model>();
    private Object lats;
    private Object longs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        getJSON();
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();

        setUpMapIfNeeded();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private void getJSON() {

        // Create a very simple REST adapter which points the GitHub API endpoint.
        SkateParks_Inter skateParks_inter = ServiceGenerator.createService(SkateParks_Inter.class, baseUrl);

        skateParks_inter.getSkateParks(new Callback<List<Skateparks_Model>>() {
            @Override
            public void success(List<Skateparks_Model> skateparks_models, Response response) {

                Log.d("parkName", " " + skateparks_models.toString());
                //loop through to get lat + long
                for (Skateparks_Model sm : skateparks_models) {
                    lats = sm.getmIsa_latitude();
                    longs = sm.getmIsa_longitude();
                    Log.d("lat and longs ", " " + lats + " " + longs);
                    createMarkers(lats, longs);
//                    Object parkNames = sm.getmIsa_name();
//                    Log.d("parknames ", " " + parkNames);
                }

            }

            @Override
            public void failure(RetrofitError error) {

                Log.e("parkName", " " + error.toString());
            }

        });
        //////////////////////////////


    }

    private void createMarkers(Object lats, Object longs) {

    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
//        mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(0, 0))
//                .title("Marker"));
       // createMarkerObjects();


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return false;
            }
        });
    }

    private void createMarkerObjects() {

        // Initialize the HashMap for Markers and MyMarker object
        mMarkersHashMap = new HashMap<Marker, Marker_Model>();

        mMyMarkersArray.add(new Marker_Model("Monkstown Skate Park", "icon1", Double.parseDouble("53.287452"), Double.parseDouble("-6.153869")));
        mMyMarkersArray.add(new Marker_Model("United States", "icon2", Double.parseDouble("33.7266622"), Double.parseDouble("-87.1469829")));
        mMyMarkersArray.add(new Marker_Model("Canada", "icon3", Double.parseDouble("51.8917773"), Double.parseDouble("-86.0922954")));
        mMyMarkersArray.add(new Marker_Model("England", "icon4", Double.parseDouble("52.4435047"), Double.parseDouble("-3.4199249")));
        mMyMarkersArray.add(new Marker_Model("Espana", "icon5", Double.parseDouble("41.8728262"), Double.parseDouble("-0.2375882")));
        mMyMarkersArray.add(new Marker_Model("Portugal", "icon6", Double.parseDouble("40.8316649"), Double.parseDouble("-4.936009")));
        mMyMarkersArray.add(new Marker_Model("Deutschland", "icon7", Double.parseDouble("51.1642292"), Double.parseDouble("10.4541194")));
        mMyMarkersArray.add(new Marker_Model("Atlantic Ocean", "icondefault", Double.parseDouble("-13.1294607"), Double.parseDouble("-19.9602353")));
        plotMarkers(mMyMarkersArray);
    }

    private void plotMarkers(ArrayList<Marker_Model> markers) {
        if (markers.size() > 0) {
            for (Marker_Model myMarker : markers) {

                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.currentlocation_icon));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }

    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        public MarkerInfoWindowAdapter() {
        }

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            View v = getLayoutInflater().inflate(R.layout.infowindow_layout, null);

            Marker_Model myMarker = mMarkersHashMap.get(marker);

            ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);

            TextView markerLabel = (TextView) v.findViewById(R.id.marker_label);

            TextView anotherLabel = (TextView) v.findViewById(R.id.another_label);
            anotherLabel.setText("A custom text");
            String lblText = anotherLabel.getText().toString();

            Log.d("label text", lblText);

            markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));

            markerLabel.setText(myMarker.getmLabel());

            return v;
        }
    }

    private int manageMarkerIcon(String markerIcon) {
        if (markerIcon.equals("icon1"))
            return R.drawable.icon1;
        else if (markerIcon.equals("icon2"))
            return R.drawable.icon2;
        else if (markerIcon.equals("icon3"))
            return R.drawable.icon3;
        else if (markerIcon.equals("icon4"))
            return R.drawable.icon4;
        else if (markerIcon.equals("icon5"))
            return R.drawable.icon5;
        else if (markerIcon.equals("icon6"))
            return R.drawable.icon6;
        else if (markerIcon.equals("icon7"))
            return R.drawable.icon7;
        else
            return R.drawable.icondefault;
    }
}
