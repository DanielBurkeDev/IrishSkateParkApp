package com.skatdev.irishskateapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.activities.SkatePark_Detail_Activity;
import com.skatdev.irishskateapp.models.JSONParksResponse;
import com.skatdev.irishskateapp.models.Skateparks_Model;

import java.util.ArrayList;

import retrofit2.Callback;

/**
 * Created by skatgroovey on 08/07/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Skateparks_Model> parks;
    private Context context;
    private Callback callback;

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
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        //viewHolder.iv_image.setImageBitmap(parks.get(i).getmIsa_image());
        viewHolder.tv_name.setText(parks.get(i).getmIsa_name());
        viewHolder.tv_descr.setText(parks.get(i).getmIsa_description());
        //viewHolder.tv_location.setText(parks.get(i).getmIsa_locations_id());


    }

    @Override
    public int getItemCount() {
        return parks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView iv_image;
        private Button btn_moreinfo;
        private TextView tv_name,tv_descr,tv_location;
        private View container;
        private Context context;
        private ArrayList<Skateparks_Model> parks;

        public ViewHolder(View view, ArrayList<Skateparks_Model> parks, Context context) {
            super(view);
            this.parks = parks;
            this.context = context;

            view.setOnClickListener(this);

            iv_image = (ImageView)view.findViewById(R.id.list_image);
            tv_name = (TextView)view.findViewById(R.id.list_title);
            tv_descr = (TextView)view.findViewById(R.id.list_desc);
            tv_location = (TextView)view.findViewById(R.id.list_location);
            btn_moreinfo = (Button) view.findViewById(R.id.more_info);
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


            Log.d("skatd", "parkname: " + skateparks.getmIsa_name() );
            v.getContext().startActivity(intent);
        }
    }



}
