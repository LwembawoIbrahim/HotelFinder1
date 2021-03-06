package com.example.lwembawo.hotelfinder;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by Nsubuga on 3/29/2016.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    DateSelectedHandler dateSelectedHandler;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        //Calendar returned a wrong month so we added one
        int realMonth = month + 1;
        String date_part, month_part;
        if (day < 10){
            date_part = "0" + day;
        }else {
            date_part = Integer.toString(day);
        }

        if (realMonth < 10){
            month_part = "0" + realMonth;
        }else {
            month_part = Integer.toString(realMonth);
        }

        String date = date_part + "-" + month_part + "-" + year;
        ((DateSelectedHandler) getActivity() ).updateDate(date);
    }

    @Override
    public void setStyle(int style, int theme) {
        super.setStyle(style, theme);
    }
    public interface DateSelectedHandler{

        public void updateDate(String date);

    }


}
