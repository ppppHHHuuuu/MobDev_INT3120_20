package com.example.lab9;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.Inflater;

public class LanguageSettingActivity extends AppCompatActivity{


    String[] languages = {"None", "English", "France", "VietNam"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        Spinner spinner;

        spinner =  findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String getLanguage = adapterView.getItemAtPosition(i).toString();
                if (getLanguage.equals("None")) {
                    Toast.makeText(LanguageSettingActivity.this, "None selected", Toast.LENGTH_SHORT).show();
                }

                else if (getLanguage.equals("English")) {
                    Toast.makeText(LanguageSettingActivity.this, "English selected", Toast.LENGTH_SHORT).show();
                    setLocal(LanguageSettingActivity.this, "en");

                    restartApp();

                }
                else if  (getLanguage.equals("France")) {
                    Toast.makeText(LanguageSettingActivity.this, "France selected", Toast.LENGTH_SHORT).show();

                    setLocal(LanguageSettingActivity.this, "fr");

                    restartApp();
                }
                else if (getLanguage.equals("VietNam")) {
                    Toast.makeText(LanguageSettingActivity.this, "Viet Nam selected", Toast.LENGTH_SHORT).show();
                    setLocal(LanguageSettingActivity.this, "vn");

                    restartApp();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    private void restartActivity() {
        // Create a new intent for the current activity
        Intent intent = getIntent();

        // Finish the current activity
        finish();

        // Start the activity again using the new intent
        startActivity(intent);
    }

    private void restartApp() {
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }

    }

    private void setLocal(Activity activity, String selectedLanguage) {
        Locale locale = new Locale(selectedLanguage);
        Locale.setDefault(locale);

        Resources resource = activity.getResources();
        Configuration configuration = activity.getResources().getConfiguration();
        configuration.setLocale(locale);
        resource.updateConfiguration(configuration, resource.getDisplayMetrics());

    }

}
