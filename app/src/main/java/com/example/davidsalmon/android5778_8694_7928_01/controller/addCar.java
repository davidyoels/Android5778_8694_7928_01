package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;


public class addCar extends Activity implements View.OnClickListener {

    private EditText BranchNumberEditText;
    private EditText ModelTypeEditText;
    private EditText KilometersEditText;
    private EditText CarNumberEditText;
    private Button addCarButton;
    void findViews()
    {
        BranchNumberEditText = (EditText) findViewById(R.id.BranchNumberEditText);
        ModelTypeEditText = (EditText) findViewById(R.id.ModelTypeEditText);
        KilometersEditText = (EditText) findViewById(R.id.KilometersEditText);
        CarNumberEditText = (EditText) findViewById(R.id.CarNumberEditText);
        addCarButton = (Button) findViewById(R.id.addCarButton);
        addCarButton.setOnClickListener( this );
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
        CharSequence text = "one of the filed isnt correct";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        final ContentValues contentValues = new ContentValues();
        try{
            int branch_number = Integer.valueOf(this.BranchNumberEditText.getText().toString());
            int kilometers = Integer.valueOf(this.KilometersEditText.getText().toString());
            String model_type = ModelTypeEditText.getText().toString();
            String car_number = CarNumberEditText.getText().toString();
            if(car_number.isEmpty() || model_type.isEmpty())
                toast.show();
            else {
                contentValues.put(Car_GoConst.CarConst.BRANCH_NUMBER, branch_number);
                contentValues.put(Car_GoConst.CarConst.MODEL_TYPE, model_type);
                contentValues.put(Car_GoConst.CarConst.KILOMETERS, kilometers);
                contentValues.put(Car_GoConst.CarConst.CAR_NUMBER, car_number);
                FactoryMethod.getManager().addCar(contentValues);
                finish();
            }
        } catch (Exception e) {

            toast.show();

        }

    }
}
