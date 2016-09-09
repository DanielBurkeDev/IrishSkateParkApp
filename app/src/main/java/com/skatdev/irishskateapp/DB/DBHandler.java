package com.skatdev.irishskateapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by skatgroovey on 29/08/2016.
 */
public class DBHandler extends SQLiteOpenHelper {



    private static final String TAG = DBHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "isa_db";

    // SkateParks table name
    private static final String TABLE_PARKS = "skateparks";

    // Login Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_LATITUDE = "latitude";
    private static final String KEY_LONGITUDE = "longitude";
    private static final String KEY_RATINGS = "ratings";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_COMMENT = "comment";
    private static final String KEY_WEBSITE = "website";
    private static final String KEY_LOCATION = "location";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ISA_TABLE = "CREATE TABLE " + TABLE_PARKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT," + KEY_ADDRESS + " TEXT,"
                + KEY_PHONE + " TEXT,"  + KEY_EMAIL + " TEXT,"
                + KEY_LATITUDE + " TEXT,"  + KEY_LONGITUDE + " TEXT,"
                + KEY_RATINGS + " TEXT,"  + KEY_IMAGE + " TEXT,"
                + KEY_COMMENT + " TEXT,"  + KEY_WEBSITE + " TEXT,"
                + KEY_LOCATION + " TEXT" + ")";
        db.execSQL(CREATE_ISA_TABLE);

        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARKS);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing park details in database
     * */
    public void addParks(String name, String description, String address, String phone, String email, String latitude,
                         String longitude, String ratings, String image, String comment, String website, String location) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_DESCRIPTION, description); // description
        values.put(KEY_ADDRESS, address); // address
        values.put(KEY_PHONE, phone); // phone
        values.put(KEY_EMAIL, email); // email
        values.put(KEY_LATITUDE, latitude); // latitude
        values.put(KEY_LONGITUDE, longitude); // longitude
        values.put(KEY_RATINGS, ratings); // ratings
        values.put(KEY_IMAGE , image); // image
        values.put(KEY_COMMENT , comment); // comment
        values.put(KEY_WEBSITE , website); // website
        values.put(KEY_LOCATION , location); // location

        Log.d("skatd", "testing addtoparks args: " + phone + " " + longitude + " " + location);
        // Inserting Row
        long id = db.insert(TABLE_PARKS, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New park inserted into sqlite: " + id);
    }

    /**
     * Getting park data from database
     * */
    public HashMap<String, String> getParkDetails() {
        HashMap<String, String> parks = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE_PARKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            parks.put("name", cursor.getString(1));
            parks.put("location", cursor.getString(2));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching park from Sqlite: " + parks.toString());

        return parks;
    }

    /**
     * Getting user login status return true if rows are there in table
     * */
    public int getRowCount() {
        String countQuery = "SELECT  * FROM " + TABLE_PARKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();

        // return row count
        return rowCount;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteParks() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_PARKS, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }
}
