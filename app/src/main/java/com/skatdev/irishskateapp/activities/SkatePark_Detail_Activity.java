package com.skatdev.irishskateapp.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skatdev.irishskateapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class SkatePark_Detail_Activity extends AppCompatActivity {

    private ImageView imv_image;
    private TextView tv_park_detail_name, tv_park_detail_address, tv_park_detail_phone, tv_park_detail_location,
            tv_park_detail_lights, tv_park_detail_helmets, tv_park_detail_indoor_outdoor, tv_park_detail_surface,
            tv_park_detail_cost, tv_park_detail_opening_hours, getTv_park_detail_email, getTv_park_detail_website;
    private Toolbar toolbar;
    private String lats, longs, label, detail_image;
    private double dbl_lats, dbl_longs;
    private Button btn_showmap;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skate_park__detail_);
        initViews();
        Log.d("DetailActivity", "image string " + detail_image);
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imv_image = (ImageView) findViewById(R.id.park_detail_img);
        tv_park_detail_name = (TextView) findViewById(R.id.park_detail_name);
        tv_park_detail_address = (TextView) findViewById(R.id.park_detail_address);
        tv_park_detail_phone = (TextView) findViewById(R.id.park_detail_phone);
        tv_park_detail_location =(TextView) findViewById(R.id.park_detail_location);
        tv_park_detail_lights =(TextView) findViewById(R.id.park_detail_lights);
        tv_park_detail_helmets =(TextView) findViewById(R.id.park_detail_helmets);
        tv_park_detail_indoor_outdoor =(TextView) findViewById(R.id.park_indoor_outdoor);
        tv_park_detail_surface =(TextView) findViewById(R.id.park_detail_surface);
        tv_park_detail_opening_hours =(TextView) findViewById(R.id.park_opening_hours);
        tv_park_detail_cost =(TextView) findViewById(R.id.park_detail_cost);
        getTv_park_detail_email =(TextView) findViewById(R.id.park_detail_email);
        getTv_park_detail_website =(TextView) findViewById(R.id.park_detail_website);

        btn_showmap = (Button) findViewById(R.id.park_detail_openmap);
        btn_showmap.setOnClickListener(new ButtonListener());

        //set text on the detailed view of item selected from recyclerview
        tv_park_detail_name.setText(getIntent().getStringExtra("park_detail_name"));
        tv_park_detail_address.setText(getIntent().getStringExtra("park_detail_address"));
        tv_park_detail_phone.setText(getIntent().getStringExtra("park_detail_phone"));
        tv_park_detail_location.setText(getIntent().getStringExtra("park_detail_location"));
        tv_park_detail_lights.setText(getIntent().getStringExtra("park_detail_lights"));
        tv_park_detail_helmets.setText(getIntent().getStringExtra("park_detail_helmets"));
        tv_park_detail_indoor_outdoor.setText(getIntent().getStringExtra("park_detail_indoor_outdoor"));
        tv_park_detail_surface.setText(getIntent().getStringExtra("park_detail_surface"));
        tv_park_detail_opening_hours.setText(getIntent().getStringExtra("park_detail_opening_hours"));
        tv_park_detail_cost.setText(getIntent().getStringExtra("park_detail_cost"));
        getTv_park_detail_email.setText(getIntent().getStringExtra("park_detail_email"));
        getTv_park_detail_website.setText(getIntent().getStringExtra("park_detail_website"));

        lats = getIntent().getStringExtra("park_detail_lats");
        longs = getIntent().getStringExtra("park_detail_longs");
        detail_image = getIntent().getStringExtra("park_detail_image");

        loadDetailImage(detail_image);

        Log.d("skatd", "image string " + detail_image);

    }

    private void loadDetailImage(String detail_image) {
        Log.d("skatd", "image string " + detail_image);
        Picasso.with(context)
                .load(detail_image)
                .placeholder(R.color.AccentColor)
                .error(R.drawable.spot1)
                .fit()
                .into(imv_image);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_park_detail, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.park_detail_openmap:

                    if (isOnline()){
                        dbl_lats = new Double(lats);
                        dbl_longs = new Double(longs);
                        label = getIntent().getStringExtra("park_detail_name");
                        String uriBegin = "geo:" + dbl_lats + "," + dbl_longs;
                        String query = dbl_lats + "," + dbl_longs + "(" + label + ")";
                        String encodedQuery = Uri.encode(query);
                        String uriString = uriBegin + "?q=" + encodedQuery + "&z=10";

                        // Creates an Intent that will load a map of Skate park
                        Uri gmmIntentUri = Uri.parse(uriString);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");

                        Log.d("skatd", "map string" + gmmIntentUri.toString());
                        startActivity(mapIntent);
                    }else{
                        Toast.makeText(getApplicationContext(), "An Internet connection is needed to show the skate park in a map.",
                                Toast.LENGTH_SHORT).show();
                    }



                    break;

                default:
                    Toast.makeText(getApplicationContext(), "No options selected",
                            Toast.LENGTH_SHORT).show();
            }
        }
    }
    //test for internet connection
    public boolean isOnline() {

        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);

        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }

}

