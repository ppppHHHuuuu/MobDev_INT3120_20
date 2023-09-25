package com.example.lab9;


import android.app.Activity;
import android.content.SharedPreferences;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonSave;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextNumberPassword;
    private TextView textUsername;
    private TextView textPassword;


    private String username;
    private Integer password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSave = findViewById(R.id.button3);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextNumberPassword);
        editTextNumberPassword = findViewById(R.id.editTextNumberPassword);
        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);

        loadData();
        buttonSave.setOnClickListener(view -> {
            saveData();
        });

        // Set a click listener for the "Login" button
        buttonLogin.setOnClickListener(view -> {
            login();
        });
    }
    
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String passwordText = editTextPassword.getText().toString();
        Integer password = passwordText.isEmpty() ? 0 : Integer.parseInt(passwordText);

        editor.putString("name", editTextUsername.getText().toString());
        editor.putInt("password", password);
        editor.apply();
        Toast.makeText(MainActivity.this, "Saved Login data", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String storedUserName = sharedPreferences.getString("name", "");
        Integer storedPassword = sharedPreferences.getInt("password", -1);
        Log.d("StoredUsername", storedUserName);
        Log.d("StoredPassword", String.valueOf(storedPassword));

        if (!storedUserName.equals("") && storedPassword != -1) {
            this.username = storedUserName;
            password = storedPassword;

        }
        else {
            // Check if login and password fields are filled
            this.username = editTextUsername.getText().toString();
            String passwordText = editTextPassword.getText().toString();
            this.password = passwordText.isEmpty() ? 0 : Integer.parseInt(passwordText);
        }
        editTextUsername.setText(username);
        editTextPassword.setText(String.valueOf(password));
        Log.d("storedUserName", sharedPreferences.getString("name", "null"));
        Log.d("Username", username);
        Log.d("Password", String.valueOf(password));
        editor.apply();
    }

    private void login() {
        if (username.isEmpty() || password.equals(-1)) {
            // Show an error message to the user (e.g., using a Toast)
            Toast.makeText(MainActivity.this, "Please fill in both username and password", Toast.LENGTH_SHORT).show();
        } else {
            toStoreContent();
        }
    }

    private void toStoreContent() {
        Intent intent = new Intent(this, InternalStoreActivity.class);
        startActivity(intent);
    }

    private void applyLanguage() {
        SharedPreferences sharedPreferences = getSharedPreferences("Language", Context.MODE_PRIVATE);
        String currentLanguage = sharedPreferences.getString("Language", "");
        setLocal(MainActivity.this, currentLanguage);
        Log.d("Current Language", currentLanguage);
    }

    @Override
    public void recreate() {
        super.recreate();
    }

    private void setLocal(Activity activity, String selectedLanguage) {
        Locale locale = new Locale(selectedLanguage);
        Locale.setDefault(locale);
        Log.d("Locale", locale.toString());
        Resources resource = activity.getResources();
        Configuration configuration = activity.getResources().getConfiguration();
        configuration.setLocale(locale);
        resource.updateConfiguration(configuration, resource.getDisplayMetrics());
        recreate();
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
