package com.example.lwembawo.hotelfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;

import static com.example.lwembawo.hotelfinder.HotelFinderAdapter.HOTEL_FINDER_ID_EXTRA;

public class HotelDetailsActivity extends AppCompatActivity {

    String [] favouriteActivityDataProjection ={
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
        setContentView(R.layout.activity_main_fragment);
        Intent getAddHotelDetails = getIntent();

//        displayHotelData(favouriteHotelDataRetrieval());



    }

    public void displayHotelData(Cursor displayFetchedDetails){
        displayFetchedDetails.moveToFirst();

        /*((TextView)findViewById(R.id.tvDisplayHotelDescription)).
                setText(displayFetchedDetails.getString(displayFetchedDetails.
                        getColumnIndex(HotelFinderDataEntry.COLUMN_DESCRIPTION)));
        ((TextView)findViewById(R.id.tvHotelDetailAddressDisplay)).
                setText(displayFetchedDetails.getString(displayFetchedDetails.
          getColumnIndex(HotelFinderDataEntry.COLUMN_ADDRESS)));*/
}
    /*private Cursor favouriteHotelDataRetrieval(){

        HotelFinderDataBaseHelper hFavouriteHelper = new HotelFinderDataBaseHelper(this);
        SQLiteDatabase fDb = hFavouriteHelper.getReadableDatabase();
        String selection = HotelFinderDataEntry._ID + " = ? ";
        String []selectionArgs ={
                addHotelId
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
        if(favouriteActCursor!=null){
            return favouriteActCursor;
        }
        else
            Toast.makeText(this,"there is no data inserted",Toast.LENGTH_SHORT).show();
        return null;

    }*/

}


