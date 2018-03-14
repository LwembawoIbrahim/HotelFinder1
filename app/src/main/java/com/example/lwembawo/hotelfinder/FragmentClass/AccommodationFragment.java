package com.example.lwembawo.hotelfinder.FragmentClass;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lwembawo.hotelfinder.AccomFragmentAdapter;
import com.example.lwembawo.hotelfinder.AddRoomActivity;
import com.example.lwembawo.hotelfinder.BookingActivity;
import com.example.lwembawo.hotelfinder.HotelDetailsActivityWithFragments;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderDataBaseHelper;
import com.example.lwembawo.hotelfinder.R;

/**
 * Created by LWEMBAWO on 7/10/2017.
 */

public class AccommodationFragment extends Fragment {
    RecyclerView accomFragRecyclerView;
   private Button booNow;
    public AccommodationFragment() {

    }

    @Override

    public void onCreate(Bundle savedInstateState) {

        super.onCreate(savedInstateState);
        //fragDataRetrieval();




    }

    private static final String TAG = "AccommodationFragment";

    String[] accomDataProjection = {
            HotelFinderDataEntry._ID,
            HotelFinderDataEntry.COLUMN_ROOM_TYPE,
            HotelFinderDataEntry.COLUMN_ROOM_COSTS

    };
    /*public  void onClickingAddHotel(View view){

    }*/

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.accommodation_fragment, container, false);

       final FloatingActionButton floatingActionButton  = (FloatingActionButton)view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddRoom = new Intent(getActivity(), AddRoomActivity.class);
                floatingActionButton.findViewById(R.id.fab);
                startActivity(goToAddRoom);

            }
        });


       // startActivity(goToAddRoom);
        fragDataRetrieval();
        accomFragRecyclerView = (RecyclerView) view.findViewById(R.id.accomRecyclerView);
        accomFragRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        AccomFragmentAdapter fragmentAdapter = new AccomFragmentAdapter(fragDataRetrieval());
        accomFragRecyclerView.setAdapter(fragmentAdapter);

        return view;
    }
    private Cursor fragDataRetrieval() {
        HotelFinderDataBaseHelper accomFragHelper = new HotelFinderDataBaseHelper(this.getContext());
        SQLiteDatabase fragDb = accomFragHelper.getReadableDatabase();
        Cursor accommFragCursor = fragDb.query(
                HotelFinderDataEntry.TABLE_ACCOMMODATION,
                accomDataProjection,
                null,
                null,
                null,
                null,
                null

        );
        if (accommFragCursor != null & accommFragCursor.getCount() > 0) {
            return accommFragCursor;
        } else {
            Toast.makeText(getContext(), "No data inserted", Toast.LENGTH_SHORT).show();
        }
        return null;
    }











   }






