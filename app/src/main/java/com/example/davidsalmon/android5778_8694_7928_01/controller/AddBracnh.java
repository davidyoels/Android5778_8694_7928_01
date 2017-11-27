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

public class AddBracnh extends Activity implements View.OnClickListener {

    private EditText CityEditText;
    private EditText StreetEditText;
    private EditText BuildingNumberEditText;
    private EditText ParkingSpacesNumberEditText;
    private EditText BranchNumberEditText;
    private Button addBracnhButton;
    void findViews()
    {
        CityEditText = (EditText) findViewById(R.id.CityEditText);
        StreetEditText = (EditText) findViewById(R.id.StreetEditText);
        BuildingNumberEditText = (EditText) findViewById(R.id.BuildingNumberEditText);
        ParkingSpacesNumberEditText = (EditText) findViewById(R.id.ParkingSpacesNumberEditText);
        BranchNumberEditText = (EditText) findViewById(R.id.BranchNumberEditText);
        addBracnhButton = (Button) findViewById(R.id.addBranchButton);
        addBracnhButton.setOnClickListener( this );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bracnh);
        findViews();
    }
    public void onClick(View v)
    {
      if (v==addBracnhButton)
          addBracnh();

    }
    void addBracnh() {
        Context context = getApplicationContext();
        CharSequence text = "one of the filed isnt correct";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        final ContentValues contentValues = new ContentValues();
        try {
            int branch_number = Integer.valueOf(this.BranchNumberEditText.getText().toString());
            int building_number = Integer.valueOf(this.BuildingNumberEditText.getText().toString());
            int parking_spaces = Integer.valueOf(this.ParkingSpacesNumberEditText.getText().toString());
            String city = CityEditText.getText().toString();
            String street = StreetEditText.getText().toString();

            contentValues.put(Car_GoConst.BranchConst.CITY, city);
            contentValues.put(Car_GoConst.BranchConst.STREET, street);
            contentValues.put(Car_GoConst.BranchConst.BRANCH_NUMBER, branch_number);
            contentValues.put(Car_GoConst.BranchConst.BUILDING_NUMBER, building_number);
            contentValues.put(Car_GoConst.BranchConst.PARKING_SPACE_NUMBER, parking_spaces);
            FactoryMethod.getManager().addBranch(contentValues);
            finish();

        } catch (Exception e) {

            toast.show();

        }

    }
}
