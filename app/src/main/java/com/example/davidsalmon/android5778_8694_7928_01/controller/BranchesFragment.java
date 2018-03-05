package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.datasource.MySQL_DBManager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch;

import java.util.List;
import java.util.Random;

/**
 * Created by david salmon on 11/28/2017.
 */


public class BranchesFragment extends Fragment {
    Random random;
    public static final String TAB = "Tab1Fragment";
    List<Branch> myBranchsList;
    ViewGroup viewGroup;
    View v;
    FloatingActionButton add;

    /**
     * @param inflater to convert xml to view.
     * @param container of the screen.
     * @param savedInstanceState
     * @return the view to be display.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.branchs_fragment, container, false);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.branchs_fragment, container, false);
        v = initCarByListView(40);
        random = new Random(7);
        return v;

    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        add = (FloatingActionButton) getActivity().findViewById(R.id.addFloatingBranch);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),AddBracnh.class));
            }
        });
    }

    /**
     * gets the branch list form our database.
     * @param size of the list.
     */
    public  void initCarList (int size){
        myBranchsList = MySQL_DBManager.branchList;
    }

    /**
     * this function makes the view fill with the branch list.
     * @param size of the list.
     * @return the view to be display.
     */
    public View initCarByListView(int size){
        initCarList(size);
        ListView listView = new ListView(this.getActivity());
        ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(this.getActivity(), R.layout.show_branch_constraint, myBranchsList)
        {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null)    {
                    convertView = View.inflate(BranchesFragment.this.getActivity(), R.layout.show_branch_constraint,null);
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