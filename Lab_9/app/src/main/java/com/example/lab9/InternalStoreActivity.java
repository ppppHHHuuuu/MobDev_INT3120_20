package com.example.lab9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InternalStoreActivity extends AppCompatActivity {
    Context context;
    Button buttonSettingOpen;
    Button buttonWrite;
    Button buttonRead;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_storage_activity);
        buttonWrite = (Button) findViewById(R.id.buttonWrite);
        buttonRead = (Button) findViewById(R.id.buttonRead);
        editText  =(EditText) findViewById(R.id.editText);
        buttonSettingOpen = (Button) findViewById(R.id.buttonSetting);
        context = getApplicationContext();
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    write();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StringBuilder stringBuilder = read();
                    editText.setText(stringBuilder.toString());
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
    private void write() throws IOException {
        String fileName = "hello.txt";
        String string = editText.getText().toString();
        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
        fileOutputStream.write(string.getBytes());
        fileOutputStream.close();
        String filePath = getFilesDir().toString();
        String message = String.format("Stored data into %s", filePath);
        Toast.makeText(InternalStoreActivity.this, message, Toast.LENGTH_SHORT).show();

    }

//    @Override
//    public File getFilesDir() {
//        Log.d("file_dir", getFilesDir().toString());
//        Log.d("file_list", Arrays.toString(fileList()));
//        return super.getFilesDir();
//    }

    private StringBuilder read() throws IOException {
        String[] fileList = fileList();
        for (String fileName : fileList) {
            Log.d("FileList", "File: " + fileName);
        }
        FileInputStream fileInputStream = this.openFileInput("hello.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        fileInputStream.close();
        return stringBuilder;
    }
    private void toPageSetting() {
        Intent intent = new Intent(this, LanguageSettingActivity.class);
        startActivity(intent);
    }
}
