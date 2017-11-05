package com.example.davidsalmon.android5778_8694_7928_01.model.backend;

import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;

import java.util.List;

/**
 * Created by david salmon on 11/3/2017.
 */

public interface DB_manager {
    //to write all the function he said to writre on BackEnd.
    boolean UserExistsOnDataBase(Client client);
    void addUser(Client newUser);
    void addModel(CarsModel newModel);
    void addCar(Car car);
    List<CarsModel> AllCarsModel();
    List<Client> AllUsers();
    List<Branch> AllBranch();
    List<Car> AllCars();



}
