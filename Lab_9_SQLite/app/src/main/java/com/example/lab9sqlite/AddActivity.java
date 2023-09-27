package com.example.lab9sqlite;

import static com.example.lab9sqlite.UserContract.UserInfor.COLUMN_AGE;
import static com.example.lab9sqlite.UserContract.UserInfor.COLUMN_ID;
import static com.example.lab9sqlite.UserContract.UserInfor.COLUMN_NAME;
import static com.example.lab9sqlite.UserContract.UserInfor.TABLE_NAME;
import static com.example.lab9sqlite.UserHelper.DATABASE_VERSION;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class AddActivity extends AppCompatActivity {
    private Context context;
    private EditText userName;
    private EditText age;
    private EditText gender;
    private Button buttonAdd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        userName = findViewById(R.id.editUsername);
        age = findViewById(R.id.editAge);
        gender = findViewById(R.id.editGender);
        buttonAdd = findViewById(R.id.buttonAdd);
        context = AddActivity.this;
        buttonAdd.setOnClickListener(view -> {
            SQLiteDatabase.CursorFactory cursorFactory = (sqLiteDatabase, sqLiteCursorDriver, s, sqLiteQuery) -> null;
            UserHelper userHelper = new UserHelper(AddActivity.this, "UserHelper",cursorFactory, DATABASE_VERSION );
            String name = userName.getText().toString().trim();
            String ageText = age.getText().toString().trim();
            String genderText =gender.getText().toString().trim();
            if (!ageText.isEmpty()) {
                try {
                    int age1 = Integer.parseInt(ageText);
                    userHelper.insertUserInfo(name, age1, genderText);
                } catch (NumberFormatException e) {
                    // Handle the case where ageText is not a valid integer
                    Toast.makeText(context, "Invalid age input", Toast.LENGTH_LONG).show();
                }
            } else {
                // Handle the case where age field is empty-
                Toast.makeText(context, "Age field is empty", Toast.LENGTH_LONG).show();
            }
        });
    }


//    public long insertUserInfo(String name, Integer age) {
//        SQLiteDatabase db = UserHelper.this.getReadableDatabase();
//        UUID uuid = UUID.randomUUID();
//        String userName = name;
//        int userAge = age;
//        ContentValues values = new ContentValues();
//
//        values.put(COLUMN_ID, uuid.toString());
//        values.put(COLUMN_NAME, userName);
//        values.put(COLUMN_AGE, userAge);
//
//        long newRowUser = db.insert(TABLE_NAME, null, values);
//        if (newRowUser == -1) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();
//        }
//        else {
//            Toast.makeText(context, "Added oke", Toast.LENGTH_LONG).show();
//
//        }
//        db.close();
//        return newRowUser;
//    }
}
