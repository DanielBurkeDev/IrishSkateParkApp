package com.skatdev.irishskateapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skatdev.irishskateapp.R;
import com.skatdev.irishskateapp.models.Skateparks_Model;

import java.util.ArrayList;

/**
 * Created by skatgroovey on 08/07/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Skateparks_Model> parks;

    public DataAdapter(ArrayList<Skateparks_Model> parks) {
        this.parks = parks;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_image;
        private TextView tv_name,tv_descr,tv_location;
        public ViewHolder(View view) {
            super(view);

            iv_image = (ImageView)view.findViewById(R.id.list_image);
            tv_name = (TextView)view.findViewById(R.id.list_title);
            tv_descr = (TextView)view.findViewById(R.id.list_desc);
            tv_location = (TextView)view.findViewById(R.id.list_location);

        }
    }

}
