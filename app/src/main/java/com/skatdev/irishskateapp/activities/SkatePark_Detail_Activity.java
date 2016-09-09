package com.skatdev.irishskateapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.skatdev.irishskateapp.R;

public class SkatePark_Detail_Activity extends AppCompatActivity {

    private ImageView imv_image;
    private TextView tv_park_detail_name, tv_park_detail_address, tv_park_detail_phone, tv_park_detail_location;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skate_park__detail_);
        initViews();
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

        tv_park_detail_name.setText(getIntent().getStringExtra("park_detail_name"));
        tv_park_detail_address.setText(getIntent().getStringExtra("park_detail_address"));
        tv_park_detail_phone.setText(getIntent().getStringExtra("park_detail_phone"));
        tv_park_detail_location.setText(getIntent().getStringExtra("park_detail_location"));


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

}

