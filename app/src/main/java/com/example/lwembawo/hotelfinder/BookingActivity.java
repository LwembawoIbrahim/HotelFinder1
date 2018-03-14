package com.example.lwembawo.hotelfinder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;

public class BookingActivity extends AppCompatActivity implements DatePickerFragment.DateSelectedHandler {

   //EditText checkingIn;
    String dateChecked;
    String clientRoomType;

    String clientRoomCosts;
    int nights = 0;
    TextView tvAmount;


    //double amount =0;
    String bookId;
    String gender;

    String[] accomDataProjection = {
            HotelFinderDataEntry._ID,
            HotelFinderDataEntry.COLUMN_ROOM_TYPE,
            HotelFinderDataEntry.COLUMN_ROOM_COSTS

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Intent getDetailsFromAccommodation = getIntent();
        bookId = getDetailsFromAccommodation.getStringExtra(AccomFragmentAdapter.FRAG_ID_EXTRA);
        displayDataToBookingActivity(fragDataRetrieval());
        tvAmount = (TextView) findViewById(R.id.tvDisplayRoomCosts);
    /*EditText checkingOut=((EditText) findViewById(R.id.check_out));
        checkingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoDatePickerFragment = new Intent(BookingActivity.this,DatePickerFragment.class);
                startActivity(gotoDatePickerFragment);

            }
        });*/

    }

    public void displayDataToBookingActivity(Cursor displayRoomDetails) {

        displayRoomDetails.moveToFirst();

        ((TextView) findViewById(R.id.tvDisplayRoomYpe))
                .setText(displayRoomDetails.getString(displayRoomDetails
                        .getColumnIndex(HotelFinderDataEntry.COLUMN_ROOM_TYPE)));
        ((TextView) findViewById(R.id.tvDisplayRoomCosts))
                .setText(displayRoomDetails.getString(displayRoomDetails
                        .getColumnIndex(HotelFinderDataEntry.COLUMN_ROOM_COSTS)));


//This method is called a plus button is clicked
    }

    public void increment(View view) {
        String amount = tvAmount.getText().toString().substring(0);

        nights = nights + 1;
        if (nights >= 0) {
            displayNights(nights);
            displayTotalAmount(nights, Double.valueOf(amount));
        } else if (nights < 0) {
            nights = 1;
            displayNights(nights);
            displayTotalAmount(nights, Double.valueOf(amount));
        }


    }

    //This method is called when a minus button is clicked
    public void decrement(View view) {
        String amount = tvAmount.getText().toString().substring(0);
        nights = nights - 1;
        if (nights >= 0) {
            displayNights(nights);
            displayTotalAmount(nights, Double.valueOf(amount));
        } else {
            Toast.makeText(this, "Eh! Zero nights :-(", Toast.LENGTH_SHORT).show();
        }


    }

    private void displayTotalAmount(int numberOfNights, double amountPerNight) {
        double total = numberOfNights * amountPerNight;
        // String totalAmount = Double.toString(total);
        ((TextView) findViewById(R.id.tvTotalAmount)).setText("UGX: " + total);

    }

    public void displayTotalAmount(double amount) {
        TextView amountDisplayed = ((TextView) findViewById(R.id.tvTotalAmount));

    }

    public void totalButton(View view) {
        // Button totalBtn = ((Button) findViewById(R.id.totalButton));
        displayTotalAmount(nights);
    }


    private void displayNights(int numberOfNights) {
        TextView displayNumber = ((TextView) findViewById(R.id.numberToBeIncremented));
        displayNumber.setText("" + numberOfNights);

    }

    private Cursor fragDataRetrieval() {
        HotelFinderDataBaseHelper accomFragHelper = new HotelFinderDataBaseHelper(this.getApplicationContext());
        SQLiteDatabase fragDb = accomFragHelper.getReadableDatabase();
        String selection = HotelFinderDataEntry._ID + " = ? ";
        String[] selectionArgs = {
                bookId
        };
        Cursor accommFragCursor = fragDb.query(
                HotelFinderDataEntry.TABLE_ACCOMMODATION,
                accomDataProjection,
                selection,
                selectionArgs,
                null,
                null,
                null

        );
        if (accommFragCursor != null & accommFragCursor.getCount() > 0) {
            return accommFragCursor;
        } else {
            Toast.makeText(getApplicationContext(), "No data inserted", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public void getClientGender(View view) {
        int id = view.getId();

        if (id == R.id.radioButtonClientMale) {
            gender = "Male";
        } else if (id == R.id.radioButtonClientFemale) {
            gender = "Female";
        } else {
            gender = null;
        }

    }

    public void reserve(View view) {
        String clientName = ((EditText) findViewById(R.id.edClientName)).getText().toString();
        //String clientGender =((RadioGroup)findViewById(R.id.clientRadioGroup)).toString();
        String clientNationality = ((EditText) findViewById(R.id.edClientsNationality)).getText().toString();
        String clientEmail = ((EditText) findViewById(R.id.edClientEmail)).getText().toString();
        String clientContact = ((EditText) findViewById(R.id.edClientContacts)).getText().toString();
        if (!clientName.equals(" ")
                && !clientNationality.equals(" ")
                && !clientEmail.equals(" ")
                && !clientContact.equals(" ")){
                //&& gender != null) {
            //Accessing the database
            HotelFinderDataBaseHelper clientHelper = new HotelFinderDataBaseHelper(this);
            //getting the data in write model
            SQLiteDatabase clientDb = clientHelper.getWritableDatabase();
            //
            ContentValues clientContentValue = new ContentValues();
            //
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_NAME, clientName);
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_ROOM_TYPE, clientRoomType);
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_ROOM_COSTS, clientRoomCosts);
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_NATIONALITY, clientNationality);
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_EMAIL, clientEmail);
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_EMAIL, clientContact);
            clientContentValue.put(HotelFinderDataEntry.COLUMN_CLIENT_GENDER, gender);
            //creating new rows returning columns as keys
            long clientId = clientDb.insert(HotelFinderDataEntry.TABLE_CLIENTS, null, clientContentValue);
            if (clientId > 0) {
                Intent gotoFavouriteActivity = new Intent(this, HotelDetailsActivityWithFragments.class);
                Toast.makeText(this, "Thank You" + " " + " " + clientName, Toast.LENGTH_SHORT).show();
                startActivity(gotoFavouriteActivity);
            } else {
                Toast.makeText(this, "No reservation made", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCancellingBooking(View view){
        Intent gotoAccommodationFragment = new Intent(this, HotelDetailsActivityWithFragments.class);
        Button cancelBooking = (Button)findViewById(R.id.cancel_booking);
        startActivity(gotoAccommodationFragment);
    }

    public void pickDate(View view){
        int id = view.getId();
        switch(id){
            case R.id.check_in:
                dateChecked = "check_in";
                break;
            case  R.id.check_out:
                 dateChecked = "check_out";
                break;
        }
        DialogFragment newFragment = new DatePickerFragment();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            newFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);
        }
        newFragment.show(getSupportFragmentManager(), "timePicker");

    }



    @Override
    public void updateDate(String date) {
        //ToDo get the date from this method

        if(dateChecked.equals("check_in")){
            ((EditText) findViewById(R.id.check_in)).setText(date);

        }
        else {
            ((EditText)findViewById(R.id.check_out)).setText(date);

        }



    }


}
