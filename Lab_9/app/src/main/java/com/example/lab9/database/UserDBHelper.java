package com.example.lab9.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserContract.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserContract.UserInfor.TABLE_NAME + " (" +
                    UserContract.UserInfor.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    UserContract.UserInfor.COLUMN_NAME + " TEXT," +
                    UserContract.UserInfor.COLUMN_AGE + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserContract.UserInfor.TABLE_NAME;


    public UserDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public Cursor getUserInfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projector = {UserContract.UserInfor.COLUMN_AGE, UserContract.UserInfor.COLUMN_NAME};
        // Filter results WHERE "title" = 'My Title'
        String selection = UserContract.UserInfor.COLUMN_AGE + " = ?";
        String[] selectionArgs = {String.valueOf(32)};

        String sortOrder = UserContract.UserInfor.COLUMN_AGE + " DESC";
        Cursor cursor = db.query(
                UserContract.UserInfor.TABLE_NAME,
                projector,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
        return cursor;
    }

//    public long insertUserInfo(String name, String age) {
//
//    }

}
