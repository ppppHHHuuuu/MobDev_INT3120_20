package com.example.lab9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab9.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InternalStoreActivity extends AppCompatActivity {
    Context context;

    Button buttonSettingOpen;
    Button buttonLoad;
    Button buttonStore;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_storage_activity);
        buttonLoad = (Button) findViewById(R.id.buttonLoad);
        buttonStore = (Button) findViewById(R.id.buttonSave);
        editText  =(EditText) findViewById(R.id.editText);
        buttonSettingOpen = (Button) findViewById(R.id.buttonSetting);
        context = getApplicationContext();
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        buttonStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    save();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        buttonSettingOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPageSetting();
            }
        });
    }
    private void load() throws IOException {
        String fileName = "hello_file";
        String string = "hello world";
        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
        fileOutputStream.write(string.getBytes());
        fileOutputStream.close();
    }
    private void save() throws IOException {
        FileInputStream fileInputStream = this.openFileInput("hello.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        fileInputStream.close();
    }
    private void toPageSetting() {
        Intent intent = new Intent(this, LanguageSettingActivity.class);
        startActivity(intent);
    }
}
