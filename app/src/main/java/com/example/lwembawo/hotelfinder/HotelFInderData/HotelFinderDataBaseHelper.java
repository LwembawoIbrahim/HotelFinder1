package com.example.lwembawo.hotelfinder.HotelFInderData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;

/**
 * Created by LWEMBAWO on 7/5/2017.
 */

public class HotelFinderDataBaseHelper extends SQLiteOpenHelper {

    //This is the database version
    public static final int DATABASE_VERSION = 8;

    //This is the database name

    public static final String  DATABASE_NAME = "HotelFinder.db";
    //These are the columns of the database
    public static final String SQL_CREATE_HOTEL_TABLE = " CREATE TABLE" +
            HotelFinderDataEntry.TABLE_NAME +
            "( " + HotelFinderDataEntry._ID + " INTEGER PRIMARY KEY, " +
            HotelFinderDataEntry.COLUMN_HOTEL_NAME + " TEXT," +
            // HotelFinderDataEntry.COLUMN_HOTEL_IMAGE + " IMAGE"+
            HotelFinderDataEntry.COLUMN_DISTRICT_NAME + " TEXT," +
            HotelFinderDataEntry.COLUMN_REGION_NAME + " TEXT," +
            HotelFinderDataEntry.COLUMN_ADDRESS + " TEXT," +
            HotelFinderDataEntry.COLUMN_CONTACTS + " TEXT," +
            HotelFinderDataEntry.COLUMN_DESCRIPTION + " TEXT )";
    private static final String SQL_DELETE_HotelData = " DROP TABLE IF EXISTS " + HotelFinderDataEntry.TABLE_NAME;
    //These are the columns for the personDetails Table

    public static final String SQL_CREATE_PERSONS_DETAILS_TABLE = " CREATE  TABLE" +
            HotelFinderDataEntry.TABLE_NAME_PERSON_DETAILS +
            "(" + HotelFinderDataEntry._ID + " INTEGER PRIMARY KEY," +
            HotelFinderDataEntry.COLUMN_FIRST_NAME + " TEXT," +
            HotelFinderDataEntry.COLUMN_LAST_NAME + " TEXT," +
            HotelFinderDataEntry.COLUMN_GENDER + " TEXT," +
            HotelFinderDataEntry.COLUMN_NATIONALITY + " TEXT," +
            HotelFinderDataEntry.COLUMN_EMAIL + " TEXT," +
            HotelFinderDataEntry.COLUMN_DESIGNATION + " TEXT," +
            HotelFinderDataEntry.COLUMN_CONTACT_PERSON_DETAILS + " TEXT," +
            HotelFinderDataEntry.COLUMN_LOCATION + " TEXT, " +
            HotelFinderDataEntry.COLUMN_PERSONS_PASSWORD + " TEXT)";
    private static final String SQL_DELETE_personsDetailsToAddHotel = " DROP TABLE IF EXISTS" +
            HotelFinderDataEntry.TABLE_NAME_PERSON_DETAILS;

    //These are the columns for accommodation table
    public static final String SQL_CREATE_TABLE_ACCOMMODATION = " CREATE TABLE" +
            HotelFinderDataEntry.TABLE_ACCOMMODATION +
            "(" + HotelFinderDataEntry._ID + " INTEGER PRIMARY KEY," +
            HotelFinderDataEntry.COLUMN_ROOM_TYPE + " TEXT," +
            HotelFinderDataEntry.COLUMN_ROOM_COSTS + " TEXT)";

    private static final String SQL_DELETE_accommodation = " DROP TABLE IF EXISTS" +
            HotelFinderDataEntry.TABLE_ACCOMMODATION;
    //Table for logging in
   /* public static final String SQL_CREATE_TABLE_CREDENTIALS = " CREATE TABLE"+
            HotelFinderDataEntry.TABLE_CREDENTIALS +
            "("+HotelFinderDataEntry._ID + " TEXT,"+
            HotelFinderDataEntry.COLUMN_PASSWORD + " TEXT,"+
            HotelFinderDataEntry.COLUMN_CONFIRM_PASSWORD + " TEXT)";*/
    //These are the columns for the clients table
    public static final String SQL_CREATE_TABLE_CLIENTS = " CREATE TABLE " +
            HotelFinderDataEntry.TABLE_CLIENTS +
            "(" + HotelFinderDataEntry._ID + " INTEGER PRIMARY KEY," +

            HotelFinderDataEntry.COLUMN_CLIENT_ROOM_TYPE + " TEXT," +
            HotelFinderDataEntry.COLUMN_CLIENT_NAME + " TEXT," +
            HotelFinderDataEntry.COLUMN_CLIENT_ROOM_COSTS + " TEXT," +
            HotelFinderDataEntry.COLUMN_CLIENT_NATIONALITY + " TEXT," +
            HotelFinderDataEntry.COLUMN_CLIENT_EMAIL + " TEXT," +
            HotelFinderDataEntry.COLUMN_CLIENT_CONTACTS + " TEXT," +
            HotelFinderDataEntry.COLUMN_CLIENT_GENDER + " TEXT )";
private static final String SQL_DELETE_clients = " DROP TABLE IF EXISTS"+
        HotelFinderDataEntry.TABLE_CLIENTS;

    public HotelFinderDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_HOTEL_TABLE);
        db.execSQL(SQL_CREATE_PERSONS_DETAILS_TABLE);
        db.execSQL(SQL_CREATE_TABLE_ACCOMMODATION);
        db.execSQL(SQL_CREATE_TABLE_CLIENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_HotelData);
        db.execSQL(SQL_DELETE_personsDetailsToAddHotel);
        db.execSQL(SQL_DELETE_accommodation);
        db.execSQL(SQL_DELETE_clients);
        onCreate(db);

    }
}
