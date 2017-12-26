package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;

import java.util.List;

public class ShowCarsModelList extends Activity {

    public List<CarsModel> getMyCarsModel() {
        return myCarsModel;
    }

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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(getBaseContext(), "hhhh", Toast.LENGTH_LONG).show();
           //     listView.removeViewAt(position);

                return false;
            }
        });

    }


}






