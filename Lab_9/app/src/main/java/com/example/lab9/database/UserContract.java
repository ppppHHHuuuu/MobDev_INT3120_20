package com.example.lab9.database;

public final class UserContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserContract() {}

    public static class UserInfor {
        public static String TABLE_NAME = "user";
        public static String COLUMN_ID = "ID";

        public static String COLUMN_NAME = "username";
        public static String COLUMN_AGE = "age";
    }

}
