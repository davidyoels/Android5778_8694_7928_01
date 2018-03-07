package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is the code behind of the activity_add_car that handel the activity's events.
 * class that add a new Car.
 */
public class AddCar extends Activity implements View.OnClickListener  {

    //definition for the instance views we will get.
    private EditText BranchNumberEditText;
    private EditText ModelTypeEditText;
    private EditText KilometersEditText;
    private EditText CarNumberEditText;
    private Button addCarButton;
    private Spinner ModelTypeEditText_spinner;

    List<CarsModel> CarsModel_list = new ArrayList<CarsModel>();
    List<String> strings = new ArrayList<>();


    /**
     * the findViews function gets the instance of the views.
     * And also makes the "add button" to listen the click event.
     * Here we did spiner for the cars model attribute to insert.
     */
    void findViews() {
        BranchNumberEditText = (EditText) findViewById(R.id.BranchNumberEditText);
        //ModelTypeEditText = (EditText) findViewById(R.id.ModelTypeEditText);
        KilometersEditText = (EditText) findViewById(R.id.KilometersEditText);
        CarNumberEditText = (EditText) findViewById(R.id.CarNumberEditText);
        addCarButton = (Button) findViewById(R.id.addCarButton);
        addCarButton.setOnClickListener(this);

        //from list of model type to spinner
         ModelTypeEditText_spinner = (Spinner) findViewById(R.id.ModelTypeEditText_spinner);
        new AsyncTask<Void, Void, List<CarsModel>>() {


            @Override
            protected List<CarsModel> doInBackground(Void... voids) {
                CarsModel_list = FactoryMethod.getManager().AllCarsModel();
                return CarsModel_list;
            }

            @Override
            protected void onPostExecute(List<CarsModel> CarsModel_list) {
                super.onPreExecute();
                SpinnerAdapter adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item,CarModel_toString(CarsModel_list));
                ModelTypeEditText_spinner.setAdapter(adapter);
            }
        }.execute();




    }

    /**
     * makes the carsModel_list to string.
     * @param carsModel_list to be convert.
     * @return the string of akk the list.
     */
    private List<String> CarModel_toString(List<CarsModel> carsModel_list) {

        for (CarsModel item:carsModel_list) {
            strings.add(new String(item.getCompanyName() + "  " + item.getModelName()));
        }
        return strings;
    }

    /**
     * the function create the activity and find the views.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }

    /**
     * check if the click is the add button click
     * @param v represent the view of the event that have been occurred.
     */
    public void onClick(View v)
    {
        if (v==addCarButton)
            addCar();
    }

    /**
     * the function take all the information that has been insert and send it by thread in the background to
     * php page and add the new Branch.
     */
    void addCar()
    {
        Context context = getApplicationContext();

        final ContentValues contentValues = new ContentValues();
        try{
            int branch_number = Integer.valueOf(this.BranchNumberEditText.getText().toString());
            int kilometers = Integer.valueOf(this.KilometersEditText.getText().toString());
            Object s = ModelTypeEditText_spinner.getSelectedItem();
            int model_type = CarsModel_list.get(ModelTypeEditText_spinner.getSelectedItemPosition()).getModelCode();
            final String car_number = CarNumberEditText.getText().toString();

            if(car_number.isEmpty() || model_type == 0 || kilometers == 0 || branch_number == 0 )
                throw new Exception("one of the filed isn't correct");
            else {
                contentValues.put(Car_GoConst.CarConst.BRANCH_NUMBER, branch_number);
                contentValues.put(Car_GoConst.CarConst.MODEL_TYPE, model_type);
                contentValues.put(Car_GoConst.CarConst.KILOMETERS, kilometers);
                contentValues.put(Car_GoConst.CarConst.CAR_NUMBER, car_number);

                new AsyncTask<Void,Void,Integer>(){


                    @Override
                    protected Integer doInBackground(Void... voids) {


                        int result = 0;
                        try {
                            result = FactoryMethod.getManager().addCar(contentValues);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return result;
                    }

                    @Override
                    protected void onPostExecute(Integer idResult) {
                        super.onPostExecute(idResult);
                        //idResult = car_number; //this is kind of solution.
                        if ( idResult != 0)
                            Toast.makeText(getBaseContext(), "insert id: " + idResult, Toast.LENGTH_LONG).show();
                    }
                }.execute();

            }
        } catch (Exception e) {

            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        finish();

    }


}
