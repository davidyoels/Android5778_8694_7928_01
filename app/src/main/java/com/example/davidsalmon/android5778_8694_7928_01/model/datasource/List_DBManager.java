package com.example.davidsalmon.android5778_8694_7928_01.model.datasource;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david salmon on 11/3/2017.
 */

/**
 * List_DBManager class manage the application with lists and actions on them(add/userExist?..etc)
 */
public class List_DBManager implements DB_manager {
    static List<Branch> branchs;
    static List<Car> cars;
    static List<CarsModel> carsModels;
    static List<Client> clients;
    static List<Invitation> invitations;

    static {
        branchs = new ArrayList<>();
        cars = new ArrayList<>();
        carsModels = new ArrayList<>();
        clients = new ArrayList<>();
        invitations = new ArrayList<>();
    }

    /**
     * @param ID of the client to search.
     * @return true if the user exist false otherwise.
     */
    @Override
    public boolean UserExistsOnDataBase(Long ID) {
        int ClientsMount = clients.size();
        for (int i = 0; i < ClientsMount; i++)
            if (clients.get(i).getId() == ID)
                return true;
        return false;
    }

    /**
     * @param newClient added to clients list.
     * @return the id of the new client.
     */
    @Override
    public long addUser(ContentValues newClient) {
        Client client = Car_GoConst.ContentValuesToClient(newClient);
        clients.add(client);
        return client.getId();
    }

    /**
     * @param newModel added to cars model list.
     * @return the id of the new car model.
     */
    @Override
    public int addModel(ContentValues newModel) {
        CarsModel model = Car_GoConst.ContentValuesToCarModel(newModel);
        carsModels.add(model);
        return model.getModelCode();
    }

    /**
     * @param newCar added to car list.
     * @return the car number.
     */
    @Override
    public int addCar(ContentValues newCar) {
        Car car = Car_GoConst.ContentValuesToCar(newCar);
        cars.add(car);
        return Integer.parseInt(car.getCarNumber());
    }

    /**
     * @param newBranch added to branch list.
     * @return the branch number.
     */
    @Override
    public int addBranch(ContentValues newBranch) {
        Branch branch = Car_GoConst.ContentValuesToBranch(newBranch);
        branchs.add(branch);
        return branch.getBranchNumber();
    }

    /**
     * @return the cars model list.
     */
    @Override
    public List<CarsModel> AllCarsModel() {
        return carsModels;
    }

    /**
     * @return the client list.
     */
    @Override
    public List<Client> AllUsers() {
        return clients;
    }

    /**
     * @return the branch list.
     */
    @Override
    public List<Branch> AllBranch() {
        return branchs;
    }

    /**
     * @return the cars list.
     */
    @Override
    public List<Car> AllCars() {
        return cars;
    }

    /**
     * we didn't implemented this function here,
     * we implemented this function in MySQL_DBManager.
     * we did it just because we have to implement everything in the DB_manager interface .
     * @param _idDel id of client to be deleted.
     */
    @Override
    public void deleteModel(ContentValues _idDel) {

    }


}
