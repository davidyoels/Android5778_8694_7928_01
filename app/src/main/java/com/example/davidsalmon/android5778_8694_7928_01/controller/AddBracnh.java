package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;

/**
 * this class is the code behind of the activity_add_branch that handel his events.
 * class that add a new Branch.
 */
public class AddBracnh extends Activity implements View.OnClickListener {

    //definition for the instance views we will get.
    private EditText CityEditText;
    private EditText StreetEditText;
    private EditText BuildingNumberEditText;
    private EditText ParkingSpacesNumberEditText;
    private EditText BranchNumberEditText;
    private Button addBracnhButton;

    /**
     * the findViews function gets the instance of the views.
     * and make the add button to listen the click event.
     */
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

    /**
     * the function create the activity and find the views.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bracnh);
        findViews();
    }

    /**
     * check if the click is the add button click
     * @param v represent the view of the event that have been occurred.
     */
    public void onClick(View v)
    {
      if (v == addBracnhButton)
          addBracnh();

    }

    /**
     * the function take all the information that has been insert and send it by thread in the background to
     * php page and add the new Branch.
     */
    @SuppressLint("StaticFieldLeak")
    void addBracnh() {
        final ContentValues contentValues = new ContentValues();
        try {
            final int branch_number = Integer.valueOf(this.BranchNumberEditText.getText().toString());
            int building_number = Integer.valueOf(this.BuildingNumberEditText.getText().toString());
            int parking_spaces = Integer.valueOf(this.ParkingSpacesNumberEditText.getText().toString());
            String city = CityEditText.getText().toString();
            String street = StreetEditText.getText().toString();

            if(city.isEmpty() || branch_number == 0 || building_number == 0 || street.isEmpty() )
                throw new Exception("one of the filed missed");
            else {
                contentValues.put(Car_GoConst.BranchConst.CITY, city);
                contentValues.put(Car_GoConst.BranchConst.STREET, street);
                contentValues.put(Car_GoConst.BranchConst.BRANCH_NUMBER, branch_number);
                contentValues.put(Car_GoConst.BranchConst.BUILDING_NUMBER, building_number);
                contentValues.put(Car_GoConst.BranchConst.PARKING_SPACE_NUMBER, parking_spaces);

                new AsyncTask<Void, Void, Integer>() {
                    @Override
                    protected Integer doInBackground(Void... params)
                    {
                        return FactoryMethod.getManager().addBranch(contentValues);
                    }

                    @Override
                    protected void onPostExecute(Integer idResult)
                    {
                        super.onPostExecute(idResult);
                        if (idResult > 0)
                            Toast.makeText(getBaseContext(), "insert branch: " + idResult, Toast.LENGTH_LONG).show();
                    }
                }.execute();


            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
