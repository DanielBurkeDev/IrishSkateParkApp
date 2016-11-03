package com.skatdev.irishskateapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.activities.Main2Activity;
import com.skatdev.irishskateapp.activities.SkatePark_Detail_Activity;
import com.skatdev.irishskateapp.models.DBParks_Model;
import com.skatdev.irishskateapp.models.JSONParksResponse;
import com.skatdev.irishskateapp.models.Skateparks_Model;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Callback;

import static android.R.attr.label;

/**
 * Created by skatgroovey on 08/07/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Skateparks_Model> parks;
    private Context context;
    private Callback callback;
    private DBParks_Model dbParks_model;
    private String lats, longs, label;
    private double dbl_lats, dbl_longs;

    public DataAdapter(ArrayList<Skateparks_Model> parks, Context context) {

        this.parks = parks;
        this.context=context;
    }

    public DataAdapter(ArrayList<Skateparks_Model> parks, Callback<JSONParksResponse> callback) {
        this.parks = parks;
        this.callback=callback;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view, parks, context);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, int i) {


        //viewHolder.iv_image.setImageBitmap(parks.get(i).getmIsa_image());
        viewHolder.tv_name.setText(parks.get(i).getmIsa_name());
        viewHolder.tv_descr.setText(parks.get(i).getmIsa_description());
        viewHolder.tv_location.setText(parks.get(i).getmIsa_location());

        label = parks.get(i).getmIsa_name();

                viewHolder.btn_list_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        // This is how we use Picasso to load images from the internet.
        Picasso.with(context)
                .load(parks.get(i).getmIsa_image())
                .placeholder(R.color.AccentColor)
                .error(R.drawable.spot1)
                .into(viewHolder.iv_image);


    }

    public void setFilter(ArrayList<Skateparks_Model> filteredparks) {
        parks = new ArrayList<>();
        Log.d("skatd", "test setfilter array" + parks.toString());
        parks.addAll(filteredparks);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv_image;
        private TextView tv_name,tv_descr,tv_location,tv_moreinfo;
        private Button btn_list_map;
        private View container;
        private Context context;
        private ArrayList<Skateparks_Model> parks;

        public ViewHolder(View view, ArrayList<Skateparks_Model> parks, Context context) {
            super(view);
            this.parks = parks;
            this.context = context;
            Log.d("parks RVAdapter", "" + parks.toString());
            view.setOnClickListener(this);

            iv_image = (ImageView)view.findViewById(R.id.list_image);
            tv_name = (TextView)view.findViewById(R.id.list_title);
            tv_descr = (TextView)view.findViewById(R.id.list_desc);
            tv_location = (TextView)view.findViewById(R.id.list_location);
            btn_list_map = (Button) view.findViewById(R.id.list_openmap);

            container = itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Skateparks_Model skateparks = this.parks.get(position);

            Log.d("skatd", "parkname: " + skateparks.getmIsa_name() );

            Intent intent = new Intent(v.getContext(), SkatePark_Detail_Activity.class);

            intent.putExtra("park_detail_name", skateparks.getmIsa_name());
            intent.putExtra("park_detail_address", skateparks.getmIsa_address());
            intent.putExtra("park_detail_phone", skateparks.getmIsa_phone());
            intent.putExtra("park_detail_location", skateparks.getmIsa_location());
            intent.putExtra("park_detail_lights", skateparks.getmIsa_lights());
            intent.putExtra("park_detail_helmets", skateparks.getmIsa_helmets());

            intent.putExtra("park_detail_indoor_outdoor", skateparks.getmIsa_indoor_outdoor());
            intent.putExtra("park_detail_surface", skateparks.getmIsa_surface());
            intent.putExtra("park_detail_opening_hours", skateparks.getmIsa_opening_hours());
            intent.putExtra("park_detail_cost", skateparks.getmIsa_cost());
            intent.putExtra("park_detail_email", skateparks.getmIsa_email());
            intent.putExtra("park_detail_website", skateparks.getmIsa_website());
            intent.putExtra("park_detail_lats", skateparks.getmIsa_latitude());
            intent.putExtra("park_detail_longs", skateparks.getmIsa_longitude());
            intent.putExtra("park_detail_image", skateparks.getmIsa_image());



            Log.d("skatd", "image string: " + skateparks.getmIsa_image() );
            v.getContext().startActivity(intent);
        }
    }


}
