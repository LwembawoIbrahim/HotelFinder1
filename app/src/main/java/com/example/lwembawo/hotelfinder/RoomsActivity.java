package com.example.lwembawo.hotelfinder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;

public class RoomsActivity extends AppCompatActivity {
    Toolbar toolbar;
    String roomType ;
    String roomCost ;
    ImageButton uploadPhoto ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void OnAddRoom(View view){


        roomType = ((EditText)findViewById(R.id.edAddRoomType)).getText().toString();
        roomCost = ((EditText)findViewById(R.id.edAddRoomCost)).getText().toString();
         uploadPhoto = ((ImageButton)findViewById(R.id.imageButtonUpload));


        //validating the inputs
        if(!roomType.equals("")
            &&!roomCost.equals("")

                ){
            //Accessing the database

            HotelFinderDataBaseHelper room = new HotelFinderDataBaseHelper(this);
            //getting the data in write mode
            SQLiteDatabase roomDb = room.getWritableDatabase();

            //creating new map of value,where column names are keys
            ContentValues roomValues = new ContentValues();
            //
            roomValues.put(HotelFinderDataEntry.COLUMN_ROOM_TYPE,roomType);
            roomValues.put(HotelFinderDataEntry.COLUMN_ROOM_COSTS,roomCost);

            //inserting new rows

            long roomId = roomDb.insert(HotelFinderDataEntry.TABLE_ACCOMMODATION,null,roomValues);

            if(roomId>0){

                Toast.makeText(this,"Room Type and Cost added" +roomId,Toast.LENGTH_SHORT).show();

                Intent goToHotelWithFragment = new Intent(this,HotelDetailsActivityWithFragments.class);

                Button addRoom = (Button)findViewById(R.id.button_add);
                startActivity(goToHotelWithFragment);

            }
            else {
                Toast.makeText(this," No Room Type and Cost added",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this,"Add all content required",Toast.LENGTH_SHORT).show();
        }

    }
}
