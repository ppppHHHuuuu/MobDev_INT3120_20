package com.example.lab9sqlite;

import static com.example.lab9sqlite.UserContract.UserInfor.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.util.UUID;
public class UserHelper extends SQLiteOpenHelper {
    private Context context;
    public static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "UserContract.db";
    Integer id_count = 0;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_AGE + " INTEGER," +
                    COLUMN_GENDER + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;



    public UserHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        this.context = context;
    }

    public UserHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("On Create User Helper", "Yes");
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public Cursor getAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursor;
    }
    public Cursor getUserInfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projector = {COLUMN_AGE, COLUMN_NAME};
        // Filter results WHERE "title" = 'My Title'
        String selection = COLUMN_AGE + " = ?";
        String[] selectionArgs = {String.valueOf(32)};

        String sortOrder = COLUMN_AGE + " DESC";
        Cursor cursor = db.query(
                TABLE_NAME,
                projector,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
        return cursor;
    }

    public long insertUserInfo(String name, Integer age, String gender) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
        values.put(COLUMN_GENDER, gender);

        long newRowUser = db.insert(TABLE_NAME, null, values);
        if (newRowUser == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Added oke", Toast.LENGTH_LONG).show();
        }
            db.close();
        return newRowUser;
    }

}
