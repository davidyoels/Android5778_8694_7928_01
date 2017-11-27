package com.example.davidsalmon.android5778_8694_7928_01.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.davidsalmon.android5778_8694_7928_01.R;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.FactoryMethod;

public class MainActivity extends Activity implements View.OnClickListener {

    FactoryMethod a = new FactoryMethod();
    public DB_manager b;

    private Button addCarButton;
    private Button addBranchButton;
    private Button addCarModelButton;
    private Button addClientButton;
    private Button showCarsButton;
    private Button showClientButton;
    private Button showCarsModelButton;
    private Button showBranchsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create one
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
        showCarsModelButton = (Button) findViewById(R.id.showCarsModelButton);
        showBranchsButton = (Button) findViewById(R.id.showBranchesButton);

        addCarButton.setOnClickListener(this);
        addBranchButton.setOnClickListener(this);
        addCarModelButton.setOnClickListener(this);
        addClientButton.setOnClickListener(this);
        showCarsButton.setOnClickListener(this);
        showClientButton.setOnClickListener(this);
        showCarsModelButton.setOnClickListener(this);
        showBranchsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
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
            showClients();
        } else if
                (v == showCarsModelButton) {
            showCarsModel();
        } else if
                (v == showBranchsButton) {
            showBranchs();
        }
    }

    private void addCar()
    {
        Intent intent = new Intent(this,AddCar.class);
        startActivity(intent);
    }
    private void addCarModel()
    {
        Intent intent = new Intent(this,AddCarModel.class);
        startActivity(intent);
    }
    private void addClient()
    {
        Intent intent = new Intent(this,AddClient.class);
        startActivity(intent);
    }
    private void addBranch()
    {
        Intent intent = new Intent(this,AddBracnh.class);
        startActivity(intent);
    }
    private void showCars()
    {
        Intent intent = new Intent(this, ShowCarsList.class);
        startActivity(intent);
    }
    private void showClients()
    {
        Intent intent = new Intent(this, ShowClient.class);
        startActivity(intent);
    }
    private void showCarsModel()
    {
        Intent intent = new Intent(this,ShowCarsModelList.class);
        startActivity(intent);
    }
    private void showBranchs()
    {
        Intent intent = new Intent(this,ShowBranchsList.class);
        startActivity(intent);
    }
}