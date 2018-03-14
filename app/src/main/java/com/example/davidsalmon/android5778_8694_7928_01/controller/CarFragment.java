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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    //definition for the instance views we will get.
    FloatingActionButton addFlaoting;
    FloatingActionButton showCarsModel;
    FloatingActionButton addFlaotingCar;
    //this definitions will use to make the Floating buttons to be animate.
    Animation FabOpen,FabClose,FabRClockwise,FabRantiClockwise;
    //isOpen used to know if he need to open the Floating buttons or to close them.
    boolean isOpen=false;
    List<Car> myCarList;
    ViewGroup viewGroup;
    View v;
    /**
     * @param inflater to convert xml to view.
     * @param container of the screen.
     * @param savedInstanceState contains the most recent data, specially contains
     * data of the activity's previous initialization part.
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
     * @param savedInstanceState contains the most recent data, specially contains
     * data of the activity's previous initialization part.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //gets the instance of the views.
        addFlaoting = (FloatingActionButton) getActivity().findViewById(R.id.addFlaoting);
        showCarsModel = (FloatingActionButton) getActivity().findViewById(R.id.showCarsModel);
        addFlaotingCar = (FloatingActionButton) getActivity().findViewById(R.id.addFlaotingCar);
        final Animation FabOpen,FabClose,FabRClockwise,FabRantiClockwise;
        //gets the animations.
        FabOpen = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.rotate_clockwise);
        FabRantiClockwise = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.rotate_anticlockwise);
        addFlaotingCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddCar.class));
            }
        });
        showCarsModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShowCarsModelList.class));
            }
        });

        /*here we make the Floating button that always displayed to listen the click event
          after this button got clicked he will check if he is open or he is close
          and then he will open/close the Floating buttons by the boolean value(open/close)
          if he is open he will close it and also to the opposite way. */
        addFlaoting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isOpen)
                {
                    showCarsModel.startAnimation(FabClose);
                    addFlaotingCar.startAnimation(FabClose);
                    addFlaoting.startAnimation(FabRantiClockwise);
                    showCarsModel.setClickable(false);
                    addFlaotingCar.setClickable(false);
                    isOpen=false;
                }
                else
                {
                    showCarsModel.startAnimation(FabOpen);
                    addFlaotingCar.startAnimation(FabOpen);
                    addFlaoting.startAnimation(FabRClockwise);
                    showCarsModel.setClickable(true);
                    addFlaotingCar.setClickable(true);
                    isOpen=true;
                }
            }
        });
    }
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });


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
