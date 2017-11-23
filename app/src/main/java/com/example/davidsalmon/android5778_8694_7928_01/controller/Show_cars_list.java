package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import java.util.ArrayList;
import java.util.List;

public class Show_cars_list extends Activity {

    private List<Car> myCarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        initCarByListView(100);

    }


    public  void initCarList (int size){
        myCarList = FactoryMethod.getManager().AllCars();

        //
        Car car1 = new Car(123,"Toyota Corola",55000,"89-322-45");
        myCarList.add(car1);
        //
    }

    public void initCarByListView(int size){

        initCarList(size);
        ListView listView = new ListView(this);
        ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(this, R.layout.activity_cars_list, myCarList)
        {

            @Override
            public View getView(int position,  View convertView,  ViewGroup parent) {

                if (convertView == null)    {
                    convertView = View.inflate(Show_cars_list.this, R.layout.activity_cars_list,null);
                }

                TextView productId_carModel_TextView = (TextView) convertView.findViewById(R.id.carModel_id);
                TextView productId_Kilometer_TextView = (TextView) convertView.findViewById(R.id.kilometer_id);
                TextView productId_carNumber_TextView = (TextView) convertView.findViewById(R.id.carNumber_id);
                TextView productId_carBranch_TextView = (TextView) convertView.findViewById(R.id.carBranch_id);

                productId_carModel_TextView.setText(myCarList.get(position).getModelType().toString());
                productId_Kilometer_TextView.setText(((Integer)myCarList.get(position).getKilometers()).toString());
                productId_carNumber_TextView.setText(myCarList.get(position).getCarNumber());
                productId_carBranch_TextView.setText(((Integer)myCarList.get(position).getBranchNumber()).toString());

                return convertView;
            }
        };


        listView.setAdapter(adapter);
        this.setContentView(listView);



    }



}
