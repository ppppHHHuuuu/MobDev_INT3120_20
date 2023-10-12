package com.build.lab_13;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocaltionProviderClient;
    private LocationManager locationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager) getSystemService(getApplicationContext().LOCATION_SERVICE);
        fusedLocaltionProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        getLastLocation();
        Toast.makeText(getApplicationContext(), "Helloworld ", Toast.LENGTH_LONG).show();
        getLastLocationWithManager();
    }

    @SuppressLint("MissingPermission")
    protected void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
        fusedLocaltionProviderClient.getLastLocation().addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
            }
        });
        fusedLocaltionProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        double accuracy = location.getAccuracy();
                        Log.d("latitude", String.valueOf(latitude));
                        Log.d("longitude", String.valueOf(longitude));
                        Log.d("accuracy", String.valueOf(accuracy));
                        Toast.makeText(getApplicationContext(), "SUCCESSED", Toast.LENGTH_LONG).show();

                        if (accuracy > 100 || location.getProvider().equals("network")) {
                            Toast.makeText(getApplicationContext(), "The location was determined using cell ID or Wi - Fi.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "The location was determined using GPS ", Toast.LENGTH_LONG).show();

                        }
                        latitude += 0.01;
                        String geoCode = "geo:" + latitude + "," + longitude;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
                        startActivity(intent);
                    }
                }
        );
    }

    @SuppressLint("MissingPermission")
    protected void getLastLocationWithManager() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
        String locationProvider = LocationManager.NETWORK_PROVIDER;
        LocationListener locationListener = location -> {

            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            String geoCode = "geo:" + latitude + "," + longitude;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
            startActivity(intent);
        };
        // String locationProvider = LocationManager.GPS_PROVIDER;
        locationManager.requestLocationUpdates(locationProvider, 0L, (float) 0, locationListener);
        locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
        ///Test
        Location lastKnownLocation =
                locationManager.getLastKnownLocation(locationProvider);
        double latitude = lastKnownLocation.getLatitude();
        double longitude = lastKnownLocation.getLongitude();
        String geoCode = "geo:" + latitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);

        locationManager.removeUpdates(locationListener);

    }
}
