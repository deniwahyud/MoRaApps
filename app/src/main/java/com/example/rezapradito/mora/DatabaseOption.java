package com.example.rezapradito.mora;

public class DatabaseOption {
    public static final String DB_NAME = "UserManager.db";
    public static final int DB_VERSION = 1;

    public static final String USERS_TABLE = "user";

    public static final String ID = "user_id";
    public static final String NAME = "user_name";
    public static final String EMAIL = "user_email";
    public static final String PASSWORD = "user_password";

    public static final String CREATE_USERS_TABLE_ =
            "CREATE TABLE  " + USERS_TABLE + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EMAIL + " TEXT NOT NULL," +
                    PASSWORD + " TEXT );";

}
