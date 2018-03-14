package com.example.lwembawo.hotelfinder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.FragmentClass.AccommodationFragment;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;

public class FavouriteHotelActivity extends AppCompatActivity {
    RecyclerView hotelFinderRecyclerView;

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
        setContentView(R.layout.activity_favourite_hotel);
        favouriteHotelDataRetrieval();


        hotelFinderRecyclerView = (RecyclerView) findViewById(R.id.favouriteActivityRecyclerView);
        hotelFinderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        HotelFinderAdapter favouriteDataAdapter = new HotelFinderAdapter(favouriteHotelDataRetrieval());
        hotelFinderRecyclerView.setAdapter(favouriteDataAdapter);

    }

    public void onAddingHotel(View view) {
        Intent gotoPersonsDetailsToAddHotel = new Intent(this, PersonToAddHotelActivity.class);

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        startActivity(gotoPersonsDetailsToAddHotel);

    }

    public void onClickingBook(View view){
        Intent goToServiceOffered = new Intent(this,HotelDetailsActivityWithFragments.class);
        Button book = (Button)findViewById(R.id.button_book);
        startActivity(goToServiceOffered);
    }

    private Cursor favouriteHotelDataRetrieval() {

        HotelFinderDataBaseHelper hFavouriteHelper = new HotelFinderDataBaseHelper(this);
        SQLiteDatabase fDb = hFavouriteHelper.getReadableDatabase();

        Cursor favouriteActCursor = fDb.query(
                HotelFinderDataEntry.TABLE_NAME,
                favouriteActivityDataProjection,
                null,
                null,
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
    Intent intent = getIntent();
}
