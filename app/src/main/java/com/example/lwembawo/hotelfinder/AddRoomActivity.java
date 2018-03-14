package com.example.lwembawo.hotelfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRoomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    //Validating the details to add a room
    public void onClickingEnter(View view) {
        Button enter = ((Button) findViewById(R.id.EnterButtonAddRoom));
   String    personDetailsEmails = ((EditText) findViewById(R.id.edAddRoomEmail)).getText().toString();
   String    roomPassword = ((EditText) findViewById(R.id.edAddRoomPassword)).getText().toString();
        if (!personDetailsEmails.equals("")
                &&!roomPassword.equals("")) {

            // Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, RoomsActivity.class);
            startActivity(intent);
        } else {
         Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }



    }
}



