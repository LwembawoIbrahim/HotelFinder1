package com.example.lwembawo.hotelfinder.FragmentClass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lwembawo.hotelfinder.R;

/**
 * Created by LWEMBAWO on 7/10/2017.
 */

public class LeisureFragment extends Fragment {
    private static final String TAG = "LeisureFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.leisure_fragment,container,false);
        return view;
    }
}
