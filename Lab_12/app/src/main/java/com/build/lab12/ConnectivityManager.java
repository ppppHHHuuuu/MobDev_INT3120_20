package com.build.lab12;


import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.List;

public class ConnectivityManager extends AppCompatActivity {


    Button buttonTurnOnWifi;
    Button buttonTurnOffWifi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_manager);

        String service = Context.WIFI_SERVICE;
        WifiManager wifi = (WifiManager) getSystemService(service);

        Toast.makeText(getApplication(), wifi.getConnectionInfo().toString(), Toast.LENGTH_LONG).show();
        Log.d("wifi", wifi.getConnectionInfo().toString());
        buttonTurnOnWifi = findViewById(R.id.btnTurnOnWifi);
        buttonTurnOffWifi = findViewById(R.id.btnTurnOffWifi);

        buttonTurnOnWifi.setOnClickListener(view -> {
            wifi.setWifiEnabled(true);
        });
        buttonTurnOffWifi.setOnClickListener(view -> {
            wifi.setWifiEnabled(false);
        });
        // Get a list of available configurations
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        List<WifiConfiguration> configurations = wifi.getConfiguredNetworks();
        if (configurations.size() > 0) {
            Log.d("Configuration", configurations.toString());
            int netID = configurations.get(0).networkId;
            boolean disableAllOthers = true;
            wifi.enableNetwork(netID, disableAllOthers);
        }

    }
}
