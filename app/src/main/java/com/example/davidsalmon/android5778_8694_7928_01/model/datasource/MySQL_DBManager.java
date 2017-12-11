package com.example.davidsalmon.android5778_8694_7928_01.model.datasource;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;
import com.example.davidsalmon.android5778_8694_7928_01.model.backend.DB_manager;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by itay0 on 09/12/2017.
 */

public class MySQL_DBManager implements DB_manager {

    private final String UserName="itaamar";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/Car_and_Go/";


    @Override
    public boolean UserExistsOnDataBase(Long ID) {
        return false;
    }

    @Override
    public long addUser(ContentValues newClient) {
        return 0;
    }

    @Override
    public long addModel(ContentValues newModel) {
        return 0;
    }

    @Override
    public String addCar(ContentValues newCar) {

        try {
            String result = PHPtools.POST(WEB_URL + "/insertCar.php", newCar);
            String id = result;
//            if (id > 0)
//                SetUpdate();
//            printLog("addStudent:\n" + result);
            return id;
        } catch (IOException e) {
            //printLog("addStudent Exception:\n" + e);
            return null;
        }
    }


    @Override
    public long addBranch(ContentValues newBranch) {
        return 0;
    }

    @Override
    public List<CarsModel> AllCarsModel() {
        return null;
    }

    @Override
    public List<Client> AllUsers() {
        return null;
    }

    @Override
    public List<Branch> AllBranch() {
        return null;
    }

    @Override
    public List<Car> AllCars() {
        List<Car> result = new ArrayList<Car>();

        try{
            String str = PHPtools.GET(WEB_URL+"/getAllCars.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("cars");

            for( int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                /*
                Car car = new Car();
                car.setCarNumber(jsonObject.getString(Car_GoConst.CarConst.CAR_NUMBER));
                car.setBranchNumber(jsonObject.getInt(Car_GoConst.CarConst.BRANCH_NUMBER));
                car.setKilometers(jsonObject.getInt(Car_GoConst.CarConst.KILOMETERS));
                car.setModelType(jsonObject.getInt(Car_GoConst.CarConst.));
                //car.setImage(jsonObject.getString("image"));
                */

                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Car car = Car_GoConst.ContentValuesToCar(contentValues);
                result.add(car);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





}
