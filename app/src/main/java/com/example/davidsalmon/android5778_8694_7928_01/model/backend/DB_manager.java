package com.example.davidsalmon.android5778_8694_7928_01.model.backend;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;

import java.util.List;

/**
 * Created by david salmon on 11/3/2017.
 */

/**
 * interface : everyone the inherit from me must to implement all his functions.
 * interface defines the functions we should implements.
 */
public interface DB_manager {

    boolean UserExistsOnDataBase(Long ID);
    long addUser(ContentValues newClient);
    int addModel(ContentValues newModel);
    int addCar(ContentValues newCar) throws Exception;
    int addBranch(ContentValues newBranch);
    List<CarsModel> AllCarsModel();
    List<Client> AllUsers();
    List<Branch> AllBranch();
    List<Car> AllCars();

    //functions we added
    /*boolean CarModelAvailable();
    boolean addInvitaion();
    boolean removeClient();
    vo removeCar();
    boolean removeCarModel();
    boolean removeInvitation();*/

    void deleteModel(ContentValues _idDel);

}
