package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Gearbox;

public class AddCarModel extends Activity implements View.OnClickListener{



    private EditText ModelCodeEditText;
    private EditText CompanyNameEditText;
    private EditText ModelNameEditText;
    private EditText EngineCapacityEditText;
    private Spinner GearBoxSpinner;
    private AutoCompleteTextView SeatNumberEditTextS;
    private Button button;



    private void findViews() {
        ModelCodeEditText = (EditText)findViewById( R.id.ModelCode_editText );
        CompanyNameEditText = (EditText)findViewById( R.id.CompanyName_editText );
        ModelNameEditText = (EditText)findViewById( R.id.ModelName_editText );
        EngineCapacityEditText = (EditText)findViewById( R.id.EngineCapacity_editText );
        GearBoxSpinner = (Spinner)findViewById( R.id.GearBox_spinner );
        SeatNumberEditTextS = (AutoCompleteTextView)findViewById( R.id.SeatNumber_editTextS );

        Spinner GearBoxSpinner = (Spinner) findViewById(R.id.GearBox_spinner);
        GearBoxSpinner.setAdapter(new ArrayAdapter<Gearbox>(this, android.R.layout.simple_spinner_item, Gearbox.values()));

        button = (Button)findViewById( R.id.button );
        button.setOnClickListener( this );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
        findViews();
    }


    @Override
    public void onClick(View v) {
        if ( v == button ) {

            Context context = getApplicationContext();
            CharSequence text = "one of the filed missed!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);

            final ContentValues contentValues = new ContentValues();
            try{
                int ModelCode = Integer.valueOf(this.ModelCodeEditText.getText().toString());
                int EngineCapacity = Integer.valueOf(this.EngineCapacityEditText.getText().toString());
                int SeatsNumber = Integer.valueOf(this.SeatNumberEditTextS.getText().toString());
                String CompanyName = this.CompanyNameEditText.getText().toString();
                String ModelName = this.ModelNameEditText.getText().toString();
                Gearbox gearbox =  (Gearbox) this.GearBoxSpinner.getSelectedItem();

                if(ModelCode == 0 || CompanyName.isEmpty() || ModelName.isEmpty() )
                    toast.show();
                else {
                    contentValues.put(Car_GoConst.CarModelConst.COMPANY_NAME, CompanyName);
                    contentValues.put(Car_GoConst.CarModelConst.ENGINE_CAPACITY, EngineCapacity);
                    contentValues.put(Car_GoConst.CarModelConst.GEAR_BOX, gearbox.toString());
                    contentValues.put(Car_GoConst.CarModelConst.MODEL_CODE, ModelCode);
                    contentValues.put(Car_GoConst.CarModelConst.MODEL_NAME, ModelName);
                    contentValues.put(Car_GoConst.CarModelConst.SEATS_NUMBER, SeatsNumber);

                    FactoryMethod.getManager().addModel(contentValues);
                    finish();
                }
            } catch (Exception e) {

                toast.show();

            }

        }
    }

}
