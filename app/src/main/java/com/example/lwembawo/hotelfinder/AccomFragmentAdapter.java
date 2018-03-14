package com.example.lwembawo.hotelfinder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LWEMBAWO on 7/11/2017.
 */

public class AccomFragmentAdapter extends RecyclerView.Adapter<AccomFragmentAdapter.ViewHolder>{


     Cursor accFragCursor;
    public  static final  String FRAG_ID_EXTRA = "fragId_extra";

    public Context mContext;

    public AccomFragmentAdapter(Cursor cursor){
        accFragCursor = cursor;

    }

    public static final class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRoomType,tvRoomCost,tvCardFragId;
        Button btnBookNow;
        public ViewHolder(final View cardView){
            super(cardView);

          tvRoomType =((TextView)cardView.findViewById(R.id.roomType));
          tvRoomCost = ((TextView)cardView.findViewById(R.id.roomCosts));
          tvCardFragId = ((TextView)cardView.findViewById(R.id.cardFragRowId));
            btnBookNow = ((Button) cardView.findViewById(R.id.bookNowButton));
            btnBookNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String bookId = tvCardFragId.getText().toString();
                    Intent gotoBookingActivity = new Intent(cardView.getContext(),BookingActivity.class);
                    gotoBookingActivity.putExtra(FRAG_ID_EXTRA,bookId);
                    cardView.getContext().startActivity(gotoBookingActivity);
                }
            });
        }
    }
    @Override
    public AccomFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.accom_frag_card_view,parent,false));
    }






    @Override
    public void onBindViewHolder(AccomFragmentAdapter.ViewHolder holder, int position) {
      accFragCursor.moveToPosition(position);

        String roomType = accFragCursor.getString(1);
        String roomCosts = accFragCursor.getString(2);
        String cardFragId = accFragCursor.getString(0);

        holder.tvRoomType.setText(roomType);
        holder.tvRoomCost.setText(roomCosts);
        holder.tvCardFragId.setText(cardFragId);
    }

    @Override
    public int getItemCount() {
        if(accFragCursor!=null ){
            return accFragCursor.getCount();
        }
       return 0;
    }


}
