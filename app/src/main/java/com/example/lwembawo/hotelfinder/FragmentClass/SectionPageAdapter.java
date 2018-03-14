package com.example.lwembawo.hotelfinder.FragmentClass;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LWEMBAWO on 7/10/2017.
 */

public class SectionPageAdapter  extends FragmentPagerAdapter{

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);
        switch (position){
            case 0:
                return new AccommodationFragment();
            case 1:
                return new RestaurantFragment();
            case 2:
                return new LeisureFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "ACCOMMODATION";
            case 1:
                return "RESTAURANT";
            case 2:
                return "LEISURE";
        }
        return null;
    }
}
