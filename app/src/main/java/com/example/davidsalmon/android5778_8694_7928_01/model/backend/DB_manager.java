package com.example.davidsalmon.android5778_8694_7928_01.model.backend;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;

import java.util.List;

/**
 * Created by david salmon on 11/3/2017.
 */

public interface DB_manager {

    boolean UserExistsOnDataBase(Long ID);
    long addUser(ContentValues newClient);
    long addModel(ContentValues newModel);
    String addCar(ContentValues newCar);
    long addBranch(ContentValues newBranch);
    List<CarsModel> AllCarsModel();
    List<Client> AllUsers();
    List<Branch> AllBranch();
    List<Car> AllCars();

    //functions we added
    /*boolean CarModelAvailable();
    boolean addInvitaion();
    boolean removeClient();
    boolean removeCar();
    boolean removeCarModel();
    boolean removeInvitation();*/



}
