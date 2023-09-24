package com.example.lab6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    Button optionMenu;
    Button contextMenu;
    Button popupMenu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        optionMenu = (Button) findViewById(R.id.btnOptionMenu);
        contextMenu = (Button) findViewById(R.id.btnContextMenu);
        popupMenu = (Button) findViewById(R.id.buttonPopupMenu);

        contextMenu.setOnClickListener(view -> changeMenu(ContextActivity.class));
        optionMenu.setOnClickListener(view -> changeMenu(OptionActivity.class));
        popupMenu.setOnClickListener(view-> changeMenu(PopupActivity.class));

    }
    private void changeMenu(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        this.startActivity(intent);
    }



}
