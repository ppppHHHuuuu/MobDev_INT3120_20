package com.build.lab_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button buttonLocationActivity;
    Button buttonMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startMusic();

        buttonLocationActivity = findViewById(R.id.buttonLocationActivity);
        buttonMediaPlayer= findViewById(R.id.buttonMediaPlayer);


        buttonMediaPlayer.setOnClickListener(v-> {
            Intent intent = new Intent(getApplicationContext(), MediaPlayerActivity.class);
            startActivity(intent);
        });
        buttonLocationActivity.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
            startActivity(intent);
        });

    }


}