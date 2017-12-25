package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.os.Bundle;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;

import java.util.ArrayList;
import java.util.List;

public class ShowCarsModelList extends Activity {

    List<CarsModel> myCarsModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCarsModel = new ArrayList<>();
        setContentView(R.layout.activity_show_cars_model_list);

        //initCarByListView(100);

    }



//   private void initCarsModelList(int size) {
//        myCarsModel = FactoryMethod.getManager().AllCarsModel();
//    }
//
//
//
//
//    public void initCarByListView(int size){
//
//        initCarsModelList(size);
//        ListView listView = new ListView(this);
//        ArrayAdapter<CarsModel> adapter = new ArrayAdapter<CarsModel>(this, R.layout.activity_cars_list, myCarsModel)
//        {
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//
//                if (convertView == null)    {
//                    convertView = View.inflate(ShowCarsModelList.this, R.layout.activity_show_cars_model_list,null);
//                }
//
//                TextView productId_carModel_TextView = (TextView) convertView.findViewById(R.id.carModel_id);
//                TextView productId_Kilometer_TextView = (TextView) convertView.findViewById(R.id.kilometer_id);
//                TextView productId_carNumber_TextView = (TextView) convertView.findViewById(R.id.carNumber_id);
//                TextView productId_carBranch_TextView = (TextView) convertView.findViewById(R.id.carBranch_id);
//
//                productId_carModel_TextView.setText(myCarsModel.get(position).getModelType().toString());
//                productId_Kilometer_TextView.setText(((Integer)myCarsModel.get(position).getKilometers()).toString());
//                productId_carNumber_TextView.setText(myCarsModel.get(position).getCarNumber());
//                productId_carBranch_TextView.setText(((Integer)myCarsModel.get(position).getBranchNumber()).toString());
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
