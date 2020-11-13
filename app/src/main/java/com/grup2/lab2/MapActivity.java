package com.grup2.lab2;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.location.LocationServices;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE = 101;
    FusedLocationProviderClient fusedLocationProviderClient;
    Location currentLocation;

    private GoogleMap map;
    private LatLng defaultLatLng;
    private LatLng latLngSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        defaultLatLng = new LatLng(-2.1231132, -79.9070392);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    if (map != null) onMapReady(map);
                }
            }
        });


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLng;

        if (currentLocation == null) {
            latLng = defaultLatLng;
        } else {
            latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        }
        googleMap.clear();

        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Location");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14));
        googleMap.addMarker(markerOptions);
        this.latLngSelect = latLng;

        this.map = googleMap;

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                LatLng latLng = new LatLng(point.latitude, point.longitude);
                latLngSelect = latLng;
                MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Location");
                map.clear();
                map.addMarker(markerOptions);

                Toast toast =Toast.makeText(getApplicationContext(), "Lat: " + latLngSelect.latitude + " Lng: " + latLngSelect.longitude, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                } else {
                    Toast.makeText(getApplicationContext(), "Agregar Permisos de Ubicación", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
        }
    }
}