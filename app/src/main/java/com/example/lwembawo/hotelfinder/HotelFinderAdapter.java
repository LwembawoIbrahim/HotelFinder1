package com.example.lwembawo.hotelfinder;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lwembawo.hotelfinder.HotelFInderData.HotelFinderContract;

/**
 * Created by LWEMBAWO on 7/5/2017.
 */

public class HotelFinderAdapter extends RecyclerView.Adapter<HotelFinderAdapter.ViewHolder> {
    Cursor hFinderCursor;

    public static final String HOTEL_FINDER_ID_EXTRA = " hotelFinder_extra";
    public static final String HOTEL_ADDRESS_EXTRA = " hotelAddress_extra";
    public static final String HOTEL_DESCRIPTION_EXTRA = " hotelDescription_extra";


    public HotelFinderAdapter(Cursor cursor) {
        hFinderCursor = cursor;

    }

    //creating the ViewHolder class

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView
                tvRoomCosts,
                tvHotelName_,
                tvHotelLocation_,
                tvHotelRegion_,
                tvHotelAddress_,
                tvHotelContact_,
                tvAddHotelRowId_,
                tvHotelDescription_;


        public ViewHolder(final View cardView) {
            super(cardView);

            tvHotelName_ = (TextView) cardView.findViewById(R.id.tvHotelName);
            tvHotelLocation_ = (TextView) cardView.findViewById(R.id.tvHotelLocation);
            //tvHotelRegion_ =(TextView) cardView.findViewById(R.id.tvHotelRegion);
            tvHotelAddress_ = (TextView) cardView.findViewById(R.id.tvHotelAddress);
     /* tvHotelContact_ = (TextView)cardView.findViewById(R.id.tvHotelContacts);*/
            tvAddHotelRowId_ = (TextView) cardView.findViewById(R.id.tvaddHotelRowId);
            //tvHotelDescription_ = (TextView)cardView.findViewById(R.id.displayDetailedDescription);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String addHotelRowId = tvAddHotelRowId_.getText().toString();


                    Intent goToDetailedActivity = new Intent(cardView.getContext(), DescriptionActivity.class);
                    goToDetailedActivity.putExtra(HOTEL_FINDER_ID_EXTRA, addHotelRowId);
                    cardView.getContext().startActivity(goToDetailedActivity);
                }
            });
        }
    }

    @Override
    public HotelFinderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_finder_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(HotelFinderAdapter.ViewHolder holder, int position) {


        hFinderCursor.moveToPosition(position);
        String AddHotelRowId = hFinderCursor.getString(0);
        String hotelName = hFinderCursor.getString(1);
        String hotelDistrictName = hFinderCursor.getString(2);
        //String hotelRegion = hFinderCursor.getString(3);
        // String hotelAddress = hFinderCursor.getString(4);
        //String hotelContacts = hFinderCursor.getString(5);*/
        //String hotelDescription = hFinderCursor.getString(6);


        holder.tvHotelName_.setText(hotelName);
        holder.tvHotelLocation_.setText(hotelDistrictName);
        //holder.tvHotelRegion_.setText(hotelRegion);
        // holder.tvHotelAddress_.setText(hotelAddress);
       /* holder.tvHotelContact_.setText(hotelContacts);*/
        holder.tvAddHotelRowId_.setText(AddHotelRowId);
        //holder.tvHotelDescription_.setText(hotelDescription);


    }


    @Override
    public int getItemCount() {
        if (hFinderCursor != null) {
            return hFinderCursor.getCount();
        }
        return 0;
    }
}
