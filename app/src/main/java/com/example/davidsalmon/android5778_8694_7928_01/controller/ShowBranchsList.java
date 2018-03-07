package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
 *
 */
public class ShowBranchsList extends AppCompatActivity {
    List<Branch> myBranchsList;
    /**
     * @param savedInstanceState contains the most recent data, specially contains
     * data of the activity's previous initialization part.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_branchs_list);
        final ListView listView = new ListView(this);
        /*
          thread that download the BranchList in the background.
         */
        new AsyncTask<Void,Void,ArrayAdapter>(){


            @Override
            protected ArrayAdapter doInBackground(Void... params) {

                myBranchsList = FactoryMethod.getManager().AllBranch();


                ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(getBaseContext(), R.layout.activity_show_branchs_list, myBranchsList){

                    @Override
                    public View getView(int position,  View convertView,  ViewGroup parent) {

                        if (convertView == null)    {
                            convertView = View.inflate(ShowBranchsList.this, R.layout.activity_show_branchs_list,null);
                        }

                        TextView productId_City_TextView = (TextView) convertView.findViewById(R.id.city);
                        TextView productId_Street_TextView = (TextView) convertView.findViewById(R.id._Street);
                        TextView productId_BuildingNumber_TextView = (TextView) convertView.findViewById(R.id._bulidingNumber);
                        TextView productId_ParkingSpaces_TextView = (TextView) convertView.findViewById(R.id._ParkingSpaces);
                        TextView productId_BranchNumber_TextView = (TextView) convertView.findViewById(R.id._BranchNumber);

                        productId_City_TextView.setText(myBranchsList.get(position).getCity().toString() +", ");
                        productId_Street_TextView.setText((myBranchsList.get(position).getStreet()).toString());
                        productId_BuildingNumber_TextView.setText(((Integer) myBranchsList.get(position).getBuildingNumber()).toString());
                        productId_ParkingSpaces_TextView.setText(((Integer) myBranchsList.get(position).getParkingSpacesNumber()).toString());
                        productId_BranchNumber_TextView.setText(((Integer) myBranchsList.get(position).getBranchNumber()).toString());

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


//    public  void initCarList (int size){
//       /* new AsyncTask<Void, Void, Integer>() {
//            @Override
//            protected void onPostExecute(Integer idResult)
//            {
//                super.onPostExecute(idResult);
//                if (idResult > 0)
//                    Toast.makeText(getBaseContext(), "show list size: " + idResult, Toast.LENGTH_LONG).show();
//                else {
//                    Toast.makeText(getBaseContext(), "nothing to show size: " + idResult, Toast.LENGTH_LONG).show();
//                    finish();
//                }
//            }
//            @Override
//            protected Integer doInBackground(Void... params)
//            {
//                myBranchsList = FactoryMethod.getManager().AllBranch();
//                return myBranchsList.size();
//            }}.execute();*/
//       myBranchsList = FactoryMethod.getManager().AllBranch();
//    }
//
//    public void initCarByListView(int size){
//
//
//        ListView listView = new ListView(this);
//        ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(this, R.layout.activity_show_branchs_list, myBranchsList)
//        {
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//
//                if (convertView == null)    {
//                    convertView = View.inflate(ShowBranchsList.this, R.layout.activity_show_branchs_list,null);
//                }
//
//                TextView productId_City_TextView = (TextView) convertView.findViewById(R.id._City);
//                TextView productId_Street_TextView = (TextView) convertView.findViewById(R.id.car_company);
//                TextView productId_BuildingNumber_TextView = (TextView) convertView.findViewById(R.id.car_model);
//                TextView productId_ParkingSpaces_TextView = (TextView) convertView.findViewById(R.id._ParkingSpaces);
//                TextView productId_BranchNumber_TextView = (TextView) convertView.findViewById(R.id._BranchNumber);
//
//                productId_City_TextView.setText(myBranchsList.get(position).getCity().toString());
//                productId_Street_TextView.setText((myBranchsList.get(position).getStreet()).toString()+", ");
//                productId_BuildingNumber_TextView.setText(((Integer) myBranchsList.get(position).getBuildingNumber()).toString());
//                productId_ParkingSpaces_TextView.setText(((Integer) myBranchsList.get(position).getParkingSpacesNumber()).toString());
//                productId_BranchNumber_TextView.setText(((Integer) myBranchsList.get(position).getBranchNumber()).toString());
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
