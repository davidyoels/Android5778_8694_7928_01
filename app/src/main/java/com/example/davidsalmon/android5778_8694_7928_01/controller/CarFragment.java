package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;

/**
 * Created by david salmon on 11/28/2017.
 */

public class CarFragment extends Fragment implements View.OnClickListener {
    public static final String TAB = "CarFragment";

    private Button btnTEST;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTEST2);
        btnTEST.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(),"TESTING BUTTON CLICK 2",Toast.LENGTH_LONG).show();
    }
}
