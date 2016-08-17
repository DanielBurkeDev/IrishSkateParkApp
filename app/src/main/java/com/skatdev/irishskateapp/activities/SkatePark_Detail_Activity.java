package com.skatdev.irishskateapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.skatdev.irishskateapp.R;

public class SkatePark_Detail_Activity extends AppCompatActivity {

    private ImageView imv_image;
    private TextView tv_park_detail_name, tv_park_detail_address, tv_park_detail_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skate_park__detail_);
        initViews();
    }

    private void initViews() {
        imv_image = (ImageView) findViewById(R.id.park_detail_img);
        tv_park_detail_name = (TextView) findViewById(R.id.park_detail_name);
        tv_park_detail_address = (TextView) findViewById(R.id.park_detail_address);
        tv_park_detail_phone = (TextView) findViewById(R.id.park_detail_phone);

        tv_park_detail_name.setText(getIntent().getStringExtra("park_detail_name"));
        tv_park_detail_address.setText(getIntent().getStringExtra("park_detail_address"));
        tv_park_detail_phone.setText(getIntent().getStringExtra("park_detail_phone"));
    }
}
