package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Gearbox;

import java.util.ArrayList;
import java.util.List;


public class AddCar extends Activity implements View.OnClickListener {

    private EditText BranchNumberEditText;
    private EditText ModelTypeEditText;
    private EditText KilometersEditText;
    private EditText CarNumberEditText;
    private Button addCarButton;
    private Spinner ModelTypeEditText_spinner;

    void findViews() {
        BranchNumberEditText = (EditText) findViewById(R.id.BranchNumberEditText);
        //ModelTypeEditText = (EditText) findViewById(R.id.ModelTypeEditText);
        KilometersEditText = (EditText) findViewById(R.id.KilometersEditText);
        CarNumberEditText = (EditText) findViewById(R.id.CarNumberEditText);
        addCarButton = (Button) findViewById(R.id.addCarButton);
        addCarButton.setOnClickListener(this);

        //from list of model type to spinner
        final Spinner ModelTypeEditText_spinner = (Spinner) findViewById(R.id.ModelTypeEditText_spinner);

        List<CarsModel> CarsModel_list = new ArrayList<CarsModel>();
        CarsModel_list = FactoryMethod.getManager().AllCarsModel();
        //ModelTypeEditText_spinner.setAdapter(new ArrayAdapter<CarsModel>(this, android.R.layout.simple_spinner_item,CarsModel_list )){
        final List<CarsModel> finalCarsModel_list = CarsModel_list;
        Adapter adapter = new ArrayAdapter<CarsModel>(this, R.layout.spiner_modeltype, finalCarsModel_list);





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }

    public void onClick(View v)
    {
        if (v==addCarButton)
            addCar();
    }


    void addCar()
    {
        Context context = getApplicationContext();

        final ContentValues contentValues = new ContentValues();
        try{
            int branch_number = Integer.valueOf(this.BranchNumberEditText.getText().toString());
            int kilometers = Integer.valueOf(this.KilometersEditText.getText().toString());
            int model_type = Integer.valueOf(this.ModelTypeEditText.getText().toString());
            final String car_number = CarNumberEditText.getText().toString();

            if(car_number.isEmpty() || model_type == 0 || kilometers == 0 || branch_number == 0 )
                throw new Exception("one of the filed isn't correct");
            else {
                contentValues.put(Car_GoConst.CarConst.BRANCH_NUMBER, branch_number);
                contentValues.put(Car_GoConst.CarConst.MODEL_TYPE, model_type);
                contentValues.put(Car_GoConst.CarConst.KILOMETERS, kilometers);
                contentValues.put(Car_GoConst.CarConst.CAR_NUMBER, car_number);

                new AsyncTask<Void,Void,String>(){


                    @Override
                    protected String doInBackground(Void... voids) {
                        return FactoryMethod.getManager().addCar(contentValues);
                    }

                    @Override
                    protected void onPostExecute(String idResult) { //where idResult came??
                        super.onPostExecute(idResult);
                        idResult = car_number;
                        if (! idResult.isEmpty())
                            Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                    }
                }.execute();




            }
        } catch (Exception e) {

            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }

    }
}
