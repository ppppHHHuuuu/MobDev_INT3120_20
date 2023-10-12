package com.build.lab_13;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MediaPlayerActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    WifiManager.WifiLock wifiLock;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wifiLock = ((WifiManager) getSystemService(Context.WIFI_SERVICE))
                .createWifiLock(WifiManager.WIFI_MODE_FULL, "mylock");
        wifiLock.acquire();
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
//        mediaPlayer.start();
//

        mediaPlayer=  new MediaPlayer();
        int resID = getResources().getIdentifier("music", "raw", getPackageName());
        Log.d("GetPackageName", getPackageName());
        Log.d("ResID", String.valueOf(resID));
        Uri myUri=   Uri.parse("android.resource://" + getPackageName() + '/' + resID);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);

        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mediaPlayer.start();

//        String myUri2 = "http://master255.org/res/%D0%9A%D0%BB%D0%B8%D0%BF%D1%8B/S/SKRILLEX/Skrillex%20-%20Summit%20(feat.%20Ellie%20Goulding)%20%5BVideo%20by%20Pilerats%5D.mp4";
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        try {
//            mediaPlayer.setDataSource(myUri2);
//            mediaPlayer.prepareAsync();
//            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mediaPlayer) {
//                    mediaPlayer.start();
//                }
//            });
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        wifiLock.release();

    }


}
