package com.example.lab_8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeEnabled = intent.getBooleanExtra("state", false);
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_LONG).show();

            return;
        }
        Toast.makeText(context, "Airplane mode disabled", Toast.LENGTH_LONG).show();
    }

}
