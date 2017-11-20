package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.widget.Button;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.cars_list;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch.BranchToContentValues;
import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car.CarToContentValues;
import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel.CarModelToContentValues;
import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client.ClientToContentValues;

public class MainActivity extends Activity implements View.OnClickListener {

    FactoryMethod a = new FactoryMethod();
    public DB_manager b;

    private Button addCarButton;
    private Button addBranchButton;
    private Button addCarModelButton;
    private Button addClientButton;
    private Button showCarsButton;
    private Button showClientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create one mofa
        b = a.getManager();
        findViews();
    }

    void findViews() {
        addCarButton = (Button) findViewById(R.id.addCarButton);
        addBranchButton = (Button) findViewById(R.id.addBranchButton);
        addCarModelButton = (Button) findViewById(R.id.addCarModelButton);
        addClientButton = (Button) findViewById(R.id.addClientButton);
        showCarsButton = (Button) findViewById(R.id.showCarsButton);
        showClientButton = (Button) findViewById(R.id.showClientButton);

        addCarButton.setOnClickListener(this);
        addBranchButton.setOnClickListener(this);
        addCarModelButton.setOnClickListener(this);
        addClientButton.setOnClickListener(this);
        showCarsButton.setOnClickListener(this);
        showClientButton.setOnClickListener(this);
    }
    @Override     public void onClick(View v) {
        if (v == addCarButton) {
            addCar();
        } else if
                (v == addCarModelButton) {
            addCarModel();
        } else if
                (v == addClientButton) {
            addClient();
        } else if
                (v == addBranchButton) {
            addBranch();
        } else if
                (v == showCarsButton) {
            showCars();
        } else if
                (v == showClientButton) {
        }
    }
    private void addCar()
    {
        Intent intent = new Intent(this,addCar.class);
        startActivity(intent);
    }
    private void addCarModel()
    {
        Intent intent = new Intent(this,addCarModel.class);
        startActivity(intent);
    }
    private void addClient()
    {
        Intent intent = new Intent(this,addClient.class);
        startActivity(intent);
    }
    private void addBranch()
    {
        Intent intent = new Intent(this,addBracnh.class);
        startActivity(intent);
    }
    private void showCars()
    {
        Intent intent = new Intent(this,cars_list.class);
        startActivity(intent);
    }


}