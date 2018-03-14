package com.example.lwembawo.hotelfinder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;

public class AddHotelActivity extends AppCompatActivity {
    String hotelName;
    String districtName;
    String regionName;
    String hotelAddress;
    String hotelContact;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hotel);
    }

    public void onSavingHotelData(View view) {
        Intent gotoHotelFavourite = new Intent(this, FavouriteHotelActivity.class);
        Button savingHotelDetails = (Button) findViewById(R.id.button_save_hotel_details);


        hotelName = ((EditText) findViewById(R.id.edHotelName)).getText().toString();
        districtName = ((EditText) findViewById(R.id.edDistrictName)).getText().toString();
        regionName = ((EditText) findViewById(R.id.edRegionName)).getText().toString();
        hotelAddress = ((EditText) findViewById(R.id.edHotelAddress)).getText().toString();
        hotelContact = ((EditText) findViewById(R.id.edHotelContacts)).getText().toString();
        description = ((EditText) findViewById(R.id.edHotelDescription)).getText().toString();
        //Validating the hotel details
        if (!hotelName.equals("")
                && !districtName.equals("")
                && !regionName.equals("")
                && !hotelAddress.equals("")
                && !hotelContact.equals("")
                && !description.equals("")) {
            //Accessing the table columns for the addHotel Table
            HotelFinderDataBaseHelper addHotelHelper = new HotelFinderDataBaseHelper(this);
            //Getting the data in write model
            SQLiteDatabase addHotelDb = addHotelHelper.getWritableDatabase();
            //Creating the new values where the column names are key

            ContentValues addHotelValue = new ContentValues();
            //Inserting values into the table columns
            addHotelValue.put(HotelFinderDataEntry.COLUMN_HOTEL_NAME, hotelName);
            addHotelValue.put(HotelFinderDataEntry.COLUMN_DISTRICT_NAME, districtName);
            addHotelValue.put(HotelFinderDataEntry.COLUMN_REGION_NAME, regionName);
            addHotelValue.put(HotelFinderDataEntry.COLUMN_ADDRESS, hotelAddress);
            addHotelValue.put(HotelFinderDataEntry.COLUMN_CONTACTS, hotelContact);
            addHotelValue.put(HotelFinderDataEntry.COLUMN_DESCRIPTION, description);
            //inserting new rows returning rowId

            long addHotelRowId = addHotelDb.insert(HotelFinderDataEntry.TABLE_NAME, null, addHotelValue);

            if (addHotelRowId > 0) {
                Toast.makeText(this, "Hotel Data inserted" + addHotelRowId, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, FavouriteHotelActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "No Hotel data inserted", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }
        startActivity(gotoHotelFavourite);

    }

    Intent intent = getIntent();
}
