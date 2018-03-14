package com.example.lwembawo.hotelfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;

import static com.example.lwembawo.hotelfinder.HotelFinderAdapter.HOTEL_FINDER_ID_EXTRA;

public class DescriptionActivity extends AppCompatActivity {

    String hotelId;


    String[] favouriteActivityDataProjection = {
            HotelFinderDataEntry._ID,
            HotelFinderDataEntry.COLUMN_HOTEL_NAME,
            HotelFinderDataEntry.COLUMN_DISTRICT_NAME,
            HotelFinderDataEntry.COLUMN_REGION_NAME,
            HotelFinderDataEntry.COLUMN_ADDRESS,
            HotelFinderDataEntry.COLUMN_CONTACTS,
            HotelFinderDataEntry.COLUMN_DESCRIPTION


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent getDetails = getIntent();
        hotelId = getDetails.getStringExtra(HOTEL_FINDER_ID_EXTRA);
        disPlayDataFromTheDatabase(favouriteHotelDataRetrieval());

    }

    public void disPlayDataFromTheDatabase(Cursor displayDataFromFavourite) {
        displayDataFromFavourite.moveToFirst();

        ((TextView) findViewById(R.id.displayDetailedDescription))
                .setText(displayDataFromFavourite
                        .getString(6));

        ((TextView) findViewById(R.id.displayDetailedAddress))
                .setText(displayDataFromFavourite
                        .getString(4));
    }

    public void onClickService(View view) {
        Intent goToServiceOffered = new Intent(this, HotelDetailsActivityWithFragments.class);
        startActivity(goToServiceOffered);
    }


    private Cursor favouriteHotelDataRetrieval() {
        //Accessing the data where i fetch the data
        HotelFinderDataBaseHelper hFavouriteHelper = new HotelFinderDataBaseHelper(this);

        //putting the data into the readable model
        SQLiteDatabase fDb = hFavouriteHelper.getReadableDatabase();
        //This is the where clause where i use the id to display data
        String selection = HotelFinderDataEntry._ID + " = ? ";
        String[] selectionArgs = {
                hotelId
        };

        Cursor favouriteActCursor = fDb.query(
                HotelFinderDataEntry.TABLE_NAME,
                favouriteActivityDataProjection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        if (favouriteActCursor != null) {
            return favouriteActCursor;
        } else
            Toast.makeText(this, "there is no data inserted", Toast.LENGTH_SHORT).show();
        return null;

    }

}
