package com.example.lwembawo.hotelfinder;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lwembawo.hotelfinder.FragmentClass.AccommodationFragment;
import com.example.lwembawo.hotelfinder.FragmentClass.SectionPageAdapter;
import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract.HotelFinderDataEntry;

public class HotelDetailsActivityWithFragments extends AppCompatActivity {

    RecyclerView accomFragRecyclerView;

    String []accomDataProjection ={
        HotelFinderDataEntry.TABLE_ACCOMMODATION,
        HotelFinderDataEntry.COLUMN_ROOM_TYPE,
        HotelFinderDataEntry.COLUMN_ROOM_COSTS,

    };
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;
    public SectionPageAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasan);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent gotoAddRoomActivity = new Intent(HotelDetailsActivityWithFragments.this,AddRoomActivity.class);
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                startActivity(gotoAddRoomActivity);
               // Intent gotoAddRoomActivity = new Intent(HotelDetailsActivityWithFragments.this,AddRoomActivity.class);
                //startActivity(gotoAddRoomActivity);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

       /* accomFragRecyclerView = (RecyclerView)findViewById(R.id.accomRecyclerView);
         accomFragRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AccomFragmentAdapter fAdapter = new AccomFragmentAdapter();

       accomFragRecyclerView.setAdapter(fAdapter);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kasan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button_add, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*public Cursor fragDataRetrieval(){
        HotelFinderDataBaseHelper accomFragHelper =new  HotelFinderDataBaseHelper(this);
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
        if(accommFragCursor!=null &accommFragCursor.getCount()>0){
            return accommFragCursor;
        }
        else {
            Toast.makeText(this,"No data inserted",Toast.LENGTH_SHORT).show();
        }
        return null;
    }*/
    Intent intent = getIntent();





}
