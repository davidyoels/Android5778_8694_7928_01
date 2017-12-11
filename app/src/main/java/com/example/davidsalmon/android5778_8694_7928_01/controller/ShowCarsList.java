package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;

import java.util.List;

public class ShowCarsList extends AppCompatActivity {

    private List<Car> myCarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);
         final ListView listView = new ListView(this);

        new AsyncTask<Void,Void,ArrayAdapter>(){


            @Override
            protected ArrayAdapter doInBackground(Void... voids) {

                myCarList = FactoryMethod.getManager().AllCars();


                ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(getBaseContext(), R.layout.activity_cars_list, myCarList){

                    @Override
                    public View getView(int position,  View convertView,  ViewGroup parent) {

                        if (convertView == null)    {
                            convertView = View.inflate(ShowCarsList.this, R.layout.activity_cars_list,null);
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

                return adapter;


            }

            @Override
            protected void onPostExecute(ArrayAdapter adapter) {
                //super.onPostExecute(arrayAdapter);
                listView.setAdapter(adapter);
                setContentView(listView);

            }
        }.execute();

    }




//    @Override
//    protected void onPostExecute(ListAdapter adapter) {
//        listView.setAdapter(adapter);
//        getBaseContext().setContentView(listView);
//    }
//    public  void initCarList (int size){
//        myCarList = FactoryMethod.getManager().AllCars();
//    }
//
//    public void initCarByListView(int size){
//
//        initCarList(size);
//        ListView listView = new ListView(this);
//        ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(this, R.layout.activity_cars_list, myCarList)
//        {
//
//            @Override
//            public View getView(int position,  View convertView,  ViewGroup parent) {
//
//                if (convertView == null)    {
//                    convertView = View.inflate(ShowCarsList.this, R.layout.activity_cars_list,null);
//                }
//
//                TextView productId_carModel_TextView = (TextView) convertView.findViewById(R.id.carModel_id);
//                TextView productId_Kilometer_TextView = (TextView) convertView.findViewById(R.id.kilometer_id);
//                TextView productId_carNumber_TextView = (TextView) convertView.findViewById(R.id.carNumber_id);
//                TextView productId_carBranch_TextView = (TextView) convertView.findViewById(R.id.carBranch_id);
//
//                productId_carModel_TextView.setText(((Integer)myCarList.get(position).getModelType()).toString());
//                productId_Kilometer_TextView.setText(((Integer)myCarList.get(position).getKilometers()).toString());
//                productId_carNumber_TextView.setText(myCarList.get(position).getCarNumber());
//                productId_carBranch_TextView.setText(((Integer)myCarList.get(position).getBranchNumber()).toString());
//
//                return convertView;
//            }
//        };
//
//
//        listView.setAdapter(adapter);
//        this.setContentView(listView);
//
//
//
//    }



}
