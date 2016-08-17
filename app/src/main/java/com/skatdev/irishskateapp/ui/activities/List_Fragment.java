//package com.skatdev.irishskateapp.ui.activities;
//
//import android.app.ListFragment;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.skatdev.irishskateapp.R;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
///**
// * Created by skatgroovey on 06/11/2015.
// */
//public class List_Fragment extends ListFragment{
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1 );
//        String[] items = getResources().getStringArray( R.array.list_items );
//        adapter.addAll( new ArrayList( Arrays.asList(items) ) );
//        setListAdapter( adapter );
//    }
//
////    @Override
////    public void onListItemClick(ListView l, View v, int position, long id) {
////        super.onListItemClick(l, v, position, id);
////
////        String item = ( (TextView) v ).getText().toString();
//////        if( getString( R.string.label_skateparks ).equalsIgnoreCase( item ) ) {
//////            startActivity( new Intent( getActivity(), MainMapActivity.class ) );
//////        } else if( getString( R.string.label_skateshops ).equalsIgnoreCase( item ) ) {
//////            startActivity( new Intent( getActivity(), HeatMapActivity.class ) );
//////        } else if( getString( R.string.label_skatespots ).equalsIgnoreCase( item ) ) {
//////            startActivity( new Intent( getActivity(), PolylineActivity.class ) );
//////        } else if( getString( R.string.item_spherical_geometry ).equalsIgnoreCase( item ) ) {
//////            startActivity( new Intent( getActivity(), SphericalGeometryActivity.class ) );
////       }
//    }
//}
