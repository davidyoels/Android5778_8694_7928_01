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
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.datasource.MySQL_DBManager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;

import java.util.List;

/**
 * Created by david salmon on 11/28/2017.
 */

public class CarFragment extends Fragment{
    public static final String TAB = "CarFragment";
    FloatingActionButton addCar;
    List<Car> myCarList;
    ViewGroup viewGroup;
    View v;
    /**
     * @param inflater to convert xml to view.
     * @param container of the screen.
     * @param savedInstanceState
     * @return the view to be display.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment,container,false);
        viewGroup = (ViewGroup) inflater.inflate(R.layout.car_fragment, container, false);
        v = initCarByListView(100);
        return v;
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addCar = (FloatingActionButton) getActivity().findViewById(R.id.addFlaotingCar);
        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddCar.class));
            }
        });
    }

    /**
     * gets the branch list form our database.
     * @param size of the list.
     */
    public  void initCarList (int size){

        myCarList = MySQL_DBManager.carsList;
    }

    /**
     * this function makes the view fill with the cars list.
     * @param size of the list.
     * @return the view to be display.
     */
    public View initCarByListView(int size){
        initCarList(size);
        ListView listView = new ListView(this.getActivity());
        ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(this.getActivity(), R.layout.show_car_constraint, myCarList)
        {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                if (convertView == null)    {
                    convertView = View.inflate(CarFragment.this.getActivity(), R.layout.show_car_constraint,null);
                }

                TextView productId_carModel_TextView = (TextView) convertView.findViewById(R.id.carModel_id);
                TextView productId_Kilometer_TextView = (TextView) convertView.findViewById(R.id.kilometer_id);
                TextView productId_carNumber_TextView = (TextView) convertView.findViewById(R.id.carNumber_id);
                TextView productId_carBranch_TextView = (TextView) convertView.findViewById(R.id.carBranch_id);

                productId_carModel_TextView.setText(((Integer)myCarList.get(position).getModelType()).toString());
                productId_Kilometer_TextView.setText(((Integer)myCarList.get(position).getKilometers()).toString());
                productId_carNumber_TextView.setText(myCarList.get(position).getCarNumber());
                productId_carBranch_TextView.setText(((Integer)myCarList.get(position).getBranchNumber()).toString());
                return convertView;
            }
        };

        listView.setAdapter(adapter);
        viewGroup.addView(listView);

        return viewGroup;
    }
}
