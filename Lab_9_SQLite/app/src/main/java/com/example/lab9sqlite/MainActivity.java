package com.example.lab9sqlite;

import static com.example.lab9sqlite.UserHelper.DATABASE_VERSION;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton addButton;

    ArrayList<Integer > user_id;
    ArrayList<String > user_name;
    ArrayList<Integer > user_age;
    ArrayList<String > user_gender;
    UserHelper database;

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        addButton = findViewById(R.id.floatingActionButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        user_id = new ArrayList<>();
        user_name = new ArrayList<>();
        user_age = new ArrayList<>();
        user_gender = new ArrayList<>();

        SQLiteDatabase.CursorFactory cursorFactory = (sqLiteDatabase, sqLiteCursorDriver, s, sqLiteQuery) -> null;
        database = new UserHelper(MainActivity.this, "UserHelper",null, DATABASE_VERSION );
        storeDataInArray();

        customAdapter = new CustomAdapter(MainActivity.this, user_id, user_name, user_age, user_gender);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    void storeDataInArray() {
        Cursor cursor = database.getAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(MainActivity.this, "No data in DB ", Toast.LENGTH_LONG ).show();
        }
        else {
            while (cursor.moveToNext()) {
                user_id.add(Integer.valueOf(cursor.getString(0)));
                user_name.add(cursor.getString(1));
                user_age.add(Integer.valueOf(cursor.getString(2)));
                user_gender.add(cursor.getString(3));
                Log.d("userid", String.valueOf(user_id.get(0)));
                Log.d("userName", String.valueOf(user_name.get(0)));

            }
        }
    }
}
