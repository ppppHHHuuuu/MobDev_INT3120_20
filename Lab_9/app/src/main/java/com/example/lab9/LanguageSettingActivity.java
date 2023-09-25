package com.example.lab9;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

    String[] languages = {"en", "fr", "vn"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        Spinner spinner;

        SharedPreferences sharedPreferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        String currentLanguage = sharedPreferences.getString("Language", "");

        spinner =  findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
//        spinner.setSelection(1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String getLanguage = adapterView.getItemAtPosition(i).toString();

//                if (getLanguage.equals("None")) {
//                    Toast.makeText(LanguageSettingActivity.this, "None selected", Toast.LENGTH_SHORT).show();
//                }

                 if (getLanguage.equals("en") && !getLanguage.equals(currentLanguage))  {

                    Toast.makeText(LanguageSettingActivity.this, "English selected", Toast.LENGTH_SHORT).show();
//                    setLocal(LanguageSettingActivity.this, "en");
                     putLanguage(getLanguage);

                    restartApp();
                }
                else if  (getLanguage.equals("fr") && !getLanguage.equals(currentLanguage) ) {
                    Toast.makeText(LanguageSettingActivity.this, "France selected", Toast.LENGTH_SHORT).show();

//                    setLocal(LanguageSettingActivity.this, "fr");
                     putLanguage(getLanguage);
                    restartApp();
                }
                else if (getLanguage.equals("vn") && !getLanguage.equals(currentLanguage)) {
                    Toast.makeText(LanguageSettingActivity.this, "Viet Nam selected", Toast.LENGTH_SHORT).show();
//                    setLocal(LanguageSettingActivity.this, "vn");
                     putLanguage(getLanguage);

                    restartApp();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void putLanguage(String language) {
        SharedPreferences sharedPreferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Language", language);
        editor.apply();

    }
    private void restartActivity() {
        // Create a new intent for the current activity
        Intent intent = new Intent(this, LanguageSettingActivity.class);

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



}
