package com.example.davidsalmon.android5778_8694_7928_01.model.datasource;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by david salmon on 11/3/2017.
 */

public class List_DBManager implements DB_manager{
    static List<Branch> branchs;
    static List<Car> cars;
    static List<CarsModel> carsModels;
    static List<Client> clients;
    static List<Invitation> invitations;

    static {
        branchs = new ArrayList<Branch>();
        cars = new ArrayList<Car>();
        carsModels = new ArrayList<CarsModel>();
        clients = new ArrayList<Client>();
        invitations = new ArrayList<Invitation>();
    }
    @Override
    public boolean UserExistsOnDataBase(Client client){
        int ClientsMount=clients.size();
        for(int i=0;i<ClientsMount;i++)
            if(clients.get(i).getId()==client.getId())
                return true;
        return false;
    }
    @Override
    public void addUser(Client newUser) {
      clients.add(newUser);
    }
    @Override
    public void addModel(CarsModel newModel){
        carsModels.add(newModel);
    }
    @Override
    public void addCar(Car newCar){
        cars.add(newCar);
    }
    @Override
    public void addBranch(Branch branch) { branchs.add(branch);}
    @Override
    public List<CarsModel> AllCarsModel()
    {
        return carsModels;
    }
    @Override
    public List<Client> AllUsers(){
        return clients;
    }
    @Override
    public List<Branch> AllBranch(){
        return branchs;
    }
    @Override
    public List<Car> AllCars(){
        return cars;
    }

}
