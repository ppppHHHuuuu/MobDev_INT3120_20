package com.build.lab12;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.Camera;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    Button cameraBtn;
    Button messageBtn;
    Button bluetoothBtn;
    Button callBtn;
    private SensorManager sensorManager;
    private PhoneStateListener phoneStateListener;

    private Button wifiButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)!= null) {
            Toast.makeText(getApplicationContext(), "TYPE GRAVITY allow",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "TYPE GRAVITY Disallow",
                    Toast.LENGTH_LONG).show();
        }
        bluetoothBtn = findViewById(R.id.btnBluetooth);
        bluetoothBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, BluetoothActivity.class);
            startActivity(intent);
        });
        wifiButton = findViewById(R.id.btnWifi);
        wifiButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConnectivityManager.class);
            startActivity(intent);
        });

        cameraBtn = findViewById(R.id.btnCamera);
        cameraBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, CameraView.class);
            this.startActivity(intent);
        });
        callBtn= findViewById(R.id.btnCall);
        callBtn.setOnClickListener(v-> {
            Intent whoYouGonnaCall = new Intent(Intent.ACTION_DIAL);
            whoYouGonnaCall.setData(Uri.parse("tel:0971788003"));
            whoYouGonnaCall.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(whoYouGonnaCall);
        });

        String srvcName = Context.TELEPHONY_SERVICE;
        TelephonyManager telephonyManager =
                (TelephonyManager)getSystemService(srvcName);
        Log.d("telephonyManager", telephonyManager.getNetworkOperatorName());
        Log.d("getNetworkOperatorName", telephonyManager.getNetworkOperatorName());
        Log.d("GetSimState", String.valueOf(telephonyManager.getSimState()));
        Log.d("getPhoneCount", String.valueOf(telephonyManager.getPhoneCount()));
//        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:55512345"));
//        smsIntent.putExtra("sms_body", "Press send to send me");
//        startActivity(smsIntent);

    }

}
