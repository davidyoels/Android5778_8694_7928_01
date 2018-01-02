package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch;

import java.util.List;

/**
 * Created by david salmon on 11/28/2017.
 */

public class BranchesFragment extends Fragment {
    public static final String TAB = "Tab1Fragment";
    List<Branch> myBranchsList;
    ViewGroup viewGroup;
    View v;
    FloatingActionButton add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.branchs_fragment, container, false);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.branchs_fragment, container, false);
        new AsyncTask<Void, View, List<Branch>>() {

            @Override
            protected List<Branch> doInBackground(Void... voids) {
                initCarList(40);
                return myBranchsList;
            }

        }.execute();
        while(myBranchsList==null){}
        v = initCarByListView(40);
        return v;

    }
    public  void initCarList (int size){
        myBranchsList = FactoryMethod.getManager().AllBranch();
    }
    public View initCarByListView(int size){

        ListView listView = new ListView(this.getActivity());
        ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(this.getActivity(), R.layout.branchs_fragment, myBranchsList)
        {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null)    {
                    convertView = View.inflate(BranchesFragment.this.getActivity(), R.layout.branchs_fragment,null);
                }

                TextView productId_City_TextView = (TextView) convertView.findViewById(R.id._Street);
                TextView productId_Street_TextView = (TextView) convertView.findViewById(R.id.city);
                TextView productId_BuildingNumber_TextView = (TextView) convertView.findViewById(R.id._bulidingNumber);
                TextView productId_ParkingSpaces_TextView = (TextView) convertView.findViewById(R.id._ParkingSpaces);
                TextView productId_BranchNumber_TextView = (TextView) convertView.findViewById(R.id._BranchNumber);

                productId_City_TextView.setText(myBranchsList.get(position).getCity().toString());
                productId_Street_TextView.setText((myBranchsList.get(position).getStreet()).toString()+", ");
                productId_BuildingNumber_TextView.setText(((Integer) myBranchsList.get(position).getBuildingNumber()).toString());
                productId_ParkingSpaces_TextView.setText(((Integer) myBranchsList.get(position).getParkingSpacesNumber()).toString());
                productId_BranchNumber_TextView.setText(((Integer) myBranchsList.get(position).getBranchNumber()).toString());
                return convertView;
            }
        };


        listView.setAdapter(adapter);
        viewGroup.addView(listView);

      return viewGroup;
    }



}