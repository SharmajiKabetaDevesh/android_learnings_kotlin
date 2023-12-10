package com.example.googlemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemaps.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    Fragment fragmap;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragmap);

       mapFragment.getMapAsync(this);



    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
mMap = googleMap;
LatLng latLng = new LatLng(26.2389,73.0243);
//MarkerOptions markerOPtions = new MarkerOptions().position(latLng).title("Jodhpur");
//mMap.addMarker(markerOPtions);


mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));

//        CircleOptions circleOptions = new CircleOptions().center(latLng).radius(1000).fillColor(Color.blue(10)).strokeColor(Color.CYAN);
//
//mMap.addCircle(circleOptions);
//
//        PolygonOptions polygonOptions = new PolygonOptions().add(new LatLng(26.2389,73.0243),
//                new LatLng(26.2389,74.0243),
//                new LatLng(27.2389,74.0243),
//                new LatLng(27.2389,73.0243),
//                new LatLng(26.2389,73.0243))
//                .fillColor(Color.RED).strokeColor(Color.BLACK);
//
//
//
//mMap.addPolygon(polygonOptions);


//mMap.addGroundOverlay(new GroundOverlayOptions().position(latLng,1000f,1000f))
//        .setImage(BitmapDescriptorFactory.fromResource(R.drawable.e));
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        MarkerOptions markerOPtions = new MarkerOptions().position(latLng).title("Jodhpur");
        mMap.addMarker(markerOPtions);
        Geocoder geocoder = new Geocoder(MapsActivity.this);
        try {
            ArrayList<Address> arrAdr=(ArrayList)geocoder.getFromLocation(26.2389,73.0243,1);
            Log.d("Addr", arrAdr.get(0).getAddressLine(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
});
Geocoder geocoder = new Geocoder(this);
        try {
            ArrayList<Address> arrAdr=(ArrayList)geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);
            Log.d("Addr", arrAdr.get(0).getAddressLine(0));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Log.d("Map Loaded","Yes the map is loaded");
    }
}