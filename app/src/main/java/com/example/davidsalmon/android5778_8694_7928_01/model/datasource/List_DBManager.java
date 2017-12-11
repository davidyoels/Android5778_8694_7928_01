package com.example.davidsalmon.android5778_8694_7928_01.model.datasource;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;

import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch.ContentValuesToBranch;
import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel.ContentValuesToCarModel;
import static com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client.ContentValuesToClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david salmon on 11/3/2017.
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


    @Override
    public boolean UserExistsOnDataBase(Long ID) {
        int ClientsMount = clients.size();
        for (int i = 0; i < ClientsMount; i++)
            if (clients.get(i).getId() == ID)
                return true;
        return false;
    }

    @Override
    public long addUser(ContentValues newClient) {
        Client client = ContentValuesToClient(newClient);
        clients.add(client);
        return client.getId();
    }

    @Override
    public long addModel(ContentValues newModel) {
        CarsModel model = ContentValuesToCarModel(newModel);
        carsModels.add(model);
        return model.getModelCode();
    }

    @Override
    public String addCar(ContentValues newCar) {
        Car car = Car_GoConst.ContentValuesToCar(newCar);
        cars.add(car);
        return car.getCarNumber();
    }
    @Override
    public long addBranch(ContentValues newBranch) {
        Branch branch = ContentValuesToBranch(newBranch);
        branchs.add(branch);
        return branch.getBranchNumber();
    }

    @Override
    public List<CarsModel> AllCarsModel() {
        return carsModels;
    }

    @Override
    public List<Client> AllUsers() {
        return clients;
    }

    @Override
    public List<Branch> AllBranch() {
        return branchs;
    }

    @Override
    public List<Car> AllCars() {
        return cars;
    }


}
