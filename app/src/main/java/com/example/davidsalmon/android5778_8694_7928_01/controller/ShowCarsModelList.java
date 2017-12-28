package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;

import java.util.List;

public class ShowCarsModelList extends Activity {

    public List<CarsModel> getMyCarsModel() {
        return myCarsModel;
    }
    int _idDel;

    public List<CarsModel> myCarsModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cars_model_list);
        final ListView listView = new ListView(this);

        new AsyncTask<Void, Void, List<CarsModel>>() {


            @Override
            protected List<CarsModel> doInBackground(Void... voids) {
                 myCarsModel = FactoryMethod.getManager().AllCarsModel();
                return myCarsModel;
            }

            @Override
            protected void onPostExecute(List<CarsModel> myCarsModel) {
                super.onPostExecute(myCarsModel);

                ArrayAdapter<CarsModel>adapter = new ArrayAdapter<CarsModel>(getBaseContext(), R.layout.activity_show_cars_model_list, myCarsModel) {

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {

                        if (convertView == null) {
                            convertView = View.inflate(ShowCarsModelList.this, R.layout.activity_show_cars_model_list, null);
                        }

                        TextView textView_modelNumber = (TextView) convertView.findViewById(R.id.textView_modelNumber);
                        TextView textView_conpany = (TextView) convertView.findViewById(R.id.textView_conpany);
                        TextView textView_model = (TextView) convertView.findViewById(R.id.textView_model);
                        TextView textView_seats = (TextView) convertView.findViewById(R.id.textView_seats);
                        TextView textView_gearbox = (TextView) convertView.findViewById(R.id.textView_gearbox);


                        textView_modelNumber.setText("code: " + ((Integer)getMyCarsModel().get(position).getModelCode()).toString());
                        textView_conpany.setText((getMyCarsModel().get(position).getCompanyName()).toString());
                        textView_model.setText((getMyCarsModel().get(position).getModelName()).toString());
                        textView_seats.setText("Seats: " + ((Integer)getMyCarsModel().get(position).getSeatsNumber()).toString());
                        textView_gearbox.setText(", " + (getMyCarsModel().get(position).getGearBox().toString()));

                        return convertView;
                    }
                };

                listView.setAdapter(adapter);
                setContentView(listView);



            }
        }.execute();


        //DELETE item from list

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                 _idDel = ((CarsModel)listView.getItemAtPosition(position)).getModelCode();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ShowCarsModelList.this);
                alertDialogBuilder.setTitle("Delete Car model");
                alertDialogBuilder.setMessage("You are trying to delete a car model " + _idDel+ ",\n" +"Are you sure?");

                alertDialogBuilder.setPositiveButton("Ok",onClickListener);
                alertDialogBuilder.setNegativeButton("Cancel ",onClickListener);


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show( );





                return false;
            }
        });

    }

    AlertDialog.OnClickListener onClickListener = new DialogInterface.OnClickListener() {


        @Override
        public void onClick(DialogInterface dialog, int which) {

            switch (which)
            {
                case Dialog.BUTTON_NEGATIVE:
                    Toast.makeText(getBaseContext(), "OK. we saved your data. ", Toast.LENGTH_LONG).show();
                    break;
                case Dialog.BUTTON_POSITIVE:
                     final ContentValues contentValues = new ContentValues();
                     contentValues.put(Car_GoConst.CarModelConst.MODEL_CODE, _idDel );

                     new AsyncTask<Void, Void, Void>() {
                         @Override
                         protected Void doInBackground(Void... params)
                         {
                             FactoryMethod.getManager().deleteModel(contentValues);
                             //return 1;
                             return null;
                         }


                     }.execute();
                     Toast.makeText(getBaseContext(), "Car code " + _idDel + "delete successfully!", Toast.LENGTH_LONG).show();
                     finish();
                     break;

            }

        } };


}






