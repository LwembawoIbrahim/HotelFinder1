package com.example.lwembawo.hotelfinder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PersonToAddHotelActivity extends AppCompatActivity {
    //defining a constant for tag in this activity
    private static  final String TAG= "personToAddHotelActivity";

    /**
     * You declare FirebaseAuth and FirebaseAuth.AuthStateListener;
     */
    private FirebaseAuth personsAuth;
    private FirebaseAuth.AuthStateListener personsAuthListener;
    //These are the variables for the inputs from the persons to add a hotel
    String firstNamePersonDetails;
    String lastNamePersonDetails;
    String gender;
    String personDetailsEmails;
    String personDetailsNationality;
    String personDetailsDesignation;
    String personDetailsContacts;
    String persionDetailsLocation;
    String personsDetailsPassword;
    Button uploadHotelPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_to_add_hotel);

    personsAuth=FirebaseAuth.getInstance();

        personsAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in: " + user.getUid());
                } else {
                    //user is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out:");
                }

            }

        };
    };





    //validating the gender of the radioButton

    public void getGender(View view) {
        int id = view.getId();

        if (id == R.id.radioButtonMale_persons_details) {
            gender = "male";
        } else if (id == R.id.radioButtonPersonsFemaleDetails) {
            gender = "Female";
        } else {
            gender = null;
        }

    }


    public void onSubmittingPersonsDetails(View view) {
        Intent intent = new Intent(this,AddHotelActivity.class);

        Button onDetailsSubmission = (Button) findViewById(R.id.button_submit_persons_details);

        firstNamePersonDetails = ((EditText) findViewById(R.id.edFirstNamePersonsDetails)).getText().toString();
        lastNamePersonDetails = ((EditText) findViewById(R.id.edLastNamePersonDetails)).getText().toString();
        gender =((RadioButton)findViewById(R.id.radioButtonMale_persons_details)).getText().toString();
        gender = ((RadioButton)findViewById(R.id.radioButtonPersonsFemaleDetails)).getText().toString();

        personDetailsEmails = ((EditText) findViewById(R.id.edAddRoomEmail)).getText().toString();
        personDetailsNationality = ((EditText) findViewById(R.id.edPersonsDetailsNationality)).getText().toString();
        personDetailsDesignation = ((EditText) findViewById(R.id.edPersonsDetailsDesignation)).getText().toString();
        personDetailsContacts = ((EditText) findViewById(R.id.edPersonsDetailsContacts)).getText().toString();
        persionDetailsLocation = ((EditText) findViewById(R.id.edPersonsDetailsLocation)).getText().toString();
        personsDetailsPassword = ((EditText)findViewById(R.id.edPersonsDetailsPassword)).getText().toString();
        uploadHotelPhotos  =(Button)findViewById(R.id.uploadHotelPhoto);
        if (!firstNamePersonDetails.equals("")
                && !lastNamePersonDetails.equals("")
                && !personDetailsEmails.equals("")
                && !personDetailsNationality.equals("")
                && !personDetailsDesignation.equals("")
                && !personDetailsContacts.equals("")
                && !persionDetailsLocation.equals("")
                && !persionDetailsLocation.equals("")
                && !personsDetailsPassword.equals("")
                && gender != null) {
            //&&!uploadHotelPhotos.isClickable()) {
            //Access the database columns
            HotelFinderDataBaseHelper personDetailsHelper = new HotelFinderDataBaseHelper(this);
            //getting the data in write model
            SQLiteDatabase hFinderDb = personDetailsHelper.getWritableDatabase();
            //creating new values where columns names are the key
            ContentValues personDetailsValueContent = new ContentValues();

            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_FIRST_NAME, firstNamePersonDetails);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_LAST_NAME, lastNamePersonDetails);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_GENDER, gender);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_NATIONALITY, personDetailsNationality);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_EMAIL, personDetailsEmails);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_DESIGNATION, personDetailsDesignation);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_CONTACT_PERSON_DETAILS, personDetailsContacts);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_LOCATION, persionDetailsLocation);
            personDetailsValueContent.put(HotelFinderDataEntry.COLUMN_PERSONS_PASSWORD, personsDetailsPassword);
            // Comparing the password and confirmPassword
            if(personsDetailsPassword.equals(findViewById(R.id.edPersonsDetailsConfirmPassword))){

            }
            else {
                Toast.makeText(this,"The input should be the same as the password",Toast.LENGTH_SHORT).show();
            }

            //inserting new row returning primary key value
           long personRowId = hFinderDb.insert(HotelFinderDataEntry.TABLE_NAME_PERSON_DETAILS, null, personDetailsValueContent);
            if (personRowId > 0) {
                Toast.makeText(this, "Person details added " + personRowId, Toast.LENGTH_SHORT).show();
                Intent gotoAddHotelActivity = new Intent(this, AddHotelActivity.class);
                startActivity(gotoAddHotelActivity);

            } else {
                Toast.makeText(this, "No data is inserted", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();

        }



    }
}

