package com.example.lab11service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;

    private EditText editTextInput;
    private Button buttonStartService;
    private Button buttonStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        editTextInput = findViewById(R.id.editTextTitle);
        buttonStartService = findViewById(R.id.buttonStartService);
        buttonStopService = findViewById(R.id.buttonStopService );

        Intent serviceIntent = new Intent(this, BackgroundService.class);
        startService(serviceIntent);

//        buttonChannel1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendOnChannel1(view);
//            }
//        });
//        buttonChannel2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendOnChannel2(view);
//            }
//        });
    }

    @SuppressLint("MissingPermission")
    public void sendOnChannel1(View v) {
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setContentTitle("Title 1")
                .setContentText("This is your notification 1 text.")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory("Category 1")
                .setVibrate(new long[] {0, 100, 1000})
                .setLights(Color.RED, 1000, 1000) // Set LED light color, on time, and off time
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    @SuppressLint("MissingPermission")

    public void sendOnChannel2(View v) {
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_1_ID)
                .setContentTitle("Title 2")
                .setContentText("This is your notification 2 from Mainactivity text.")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory("Category 2")
                .setVibrate(new long[] {0, 100, 1000})
                .setLights(Color.RED, 1000, 1000) // Set LED light color, on time, and off time
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}
