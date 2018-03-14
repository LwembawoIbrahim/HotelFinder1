package com.example.lwembawo.hotelfinder.HotelFInderData;

import android.media.Image;
import android.provider.BaseColumns;

/**
 * Created by LWEMBAWO on 7/5/2017.
 */

public final class HotelFinderContract {

    private HotelFinderContract() {

    }

    //
    public static final class HotelFinderDataEntry implements BaseColumns {

        //table name for the hotel addition

        public static final String TABLE_NAME = " HotelData ";
        //these are the columns in the hotelFinderApp

        public static final String COLUMN_HOTEL_NAME = " hotelName";
        // public static final Image COLUMN_HOTEL_IMAGE ="hotelImages";
        public static final String COLUMN_DISTRICT_NAME = " districtHotel";
        public static final String COLUMN_REGION_NAME = "regionName";
        public static final String COLUMN_ADDRESS = " addressOfTheHotel";
        public static final String COLUMN_CONTACTS = " contacts";
        public static final String COLUMN_DESCRIPTION = " description";

        //Table for adding personsDetails to add a hotel

        public static final String TABLE_NAME_PERSON_DETAILS = " personsDetailsToAddHotel";

        //Columns for the table personsDetails to add a hotel

        public static final String COLUMN_FIRST_NAME = " firstName";
        public static final String COLUMN_LAST_NAME = "lastName";
        public static final String COLUMN_GENDER = " gender";
        public static final String COLUMN_NATIONALITY = " nationality";
        public static final String COLUMN_EMAIL = " email";
        public static final String COLUMN_DESIGNATION = " designation";
        public static final String COLUMN_CONTACT_PERSON_DETAILS = " contactsPersonDetails";
        public static final String COLUMN_LOCATION = " location";
        public static final String COLUMN_PERSONS_PASSWORD = "personsPassword";

        //Table   name for accommodation

        public static final String TABLE_ACCOMMODATION = " accommodation";
        //Columns for accommodation table

        public static final String COLUMN_ROOM_TYPE = "roomType";
        public static final String COLUMN_ROOM_COSTS = "roomCosts";

        //Table for validating
       /* public static final String TABLE_CREDENTIALS = "credentials";
        //columns
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_CONFIRM_PASSWORD = "confirmPassword";*/

       //Table clients
        public static final String TABLE_CLIENTS = " clients";
        //Columns for the table clients
        public static final String COLUMN_CLIENT_NAME = " clientName";
        public static final String COLUMN_CLIENT_ROOM_TYPE =" roomType";
        public static final String  COLUMN_CLIENT_ROOM_COSTS =" roomCosts";
        public static final String COLUMN_CLIENT_NATIONALITY =" clientNationality";
        public static final String COLUMN_CLIENT_EMAIL=" clientEmail";
        public static final String COLUMN_CLIENT_CONTACTS = " clientContacts";
        public static final String COLUMN_CLIENT_GENDER =" clientGender";


    }
}
