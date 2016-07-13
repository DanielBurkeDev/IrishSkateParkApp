package com.skatdev.irishskateapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by skatgroovey on 06/07/2016.
 */
public class View_Holder extends RecyclerView.ViewHolder {

    CardView cv;
    ImageView imageView;
    TextView title;
    TextView description;

    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        imageView = (ImageView) itemView.findViewById(R.id.list_image);
        title = (TextView) itemView.findViewById(R.id.list_title);
        description = (TextView) itemView.findViewById(R.id.list_desc);

    }
}