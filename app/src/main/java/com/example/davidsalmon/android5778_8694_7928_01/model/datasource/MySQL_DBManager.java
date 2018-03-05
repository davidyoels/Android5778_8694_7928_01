package com.example.davidsalmon.android5778_8694_7928_01.model.datasource;

import android.content.ContentValues;
import android.util.Log;

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

/**
 * class that get interaction with our data that inserted and our database.
 */
public class MySQL_DBManager implements DB_manager {

    private final String UserName="itaamar";
    private final String WEB_URL = "http://"+UserName+".vlab.jct.ac.il/Car_and_Go/";
    static public List<Branch> branchList = new ArrayList<Branch>();
    static public List<CarsModel> carsModelList = new ArrayList<>();
    static public List<Car> carsList = new ArrayList<>();
    static public List<Client> clientList = new ArrayList<>();


    /**
     *  We did not implement this function here.
     * -> We used this function in the List_DBManager class, because we decided to search the
     *  client in the list we got in the beginning. in this way we don't need to call the sql table
     *  and load all the client and then to search(less effective). <-
     * @param ID of the client
     * @return true if the user exist false otherwise.
     */
    @Override
    public boolean UserExistsOnDataBase(Long ID) {
        return false;
    }

    /**
     * add new car model.
     * the function send the new car model to php page that handle the "add function" and add the
     * new car model to the car model table(in our sql database).
     * @param newModel to be added.
     * @return the car model id.
     */
    @Override
    public int addModel(ContentValues newModel) {
        try{
            String result = PHPtools.POST(WEB_URL + "/insertCarModel.php", newModel);
            String s = result.trim();
            int id = Integer.parseInt(s) ;
            //          if (id > 0)
//                SetUpdate();
            printLog("addCarModel:\n" + 1);
            return id;
        } catch (IOException e) {
            e.getMessage();
            printLog("addCarModel Exception:\n" + e);

            return -1;
        }
    }

    /**
     * delete existing car model.
     * the function send the car model to be deleted to php page that handle the "delete function" and delete the
     * car model from the car model table(in our sql database).
     * @param id of the car model to be deleted.
     */
    public void deleteModel(ContentValues id) {
        try{
            PHPtools.POST(WEB_URL + "/deleteCarModel.php", id);
        } catch (IOException e) {
            e.getMessage();
            printLog("addCarModel Exception:\n" + e);

        }
    }

    /**
     /**
     * add new car.
     * the function send the new car to php page that handle the "add function" and add the
     * new car to the car table(in our sql database).
     * @param newCar to be added
     * @return "1" in case he succeed to add.
     */
    @Override
    public String addCar(ContentValues newCar) {

        try {
            String result = PHPtools.POST(WEB_URL + "/insertCar.php", newCar);
         //   String id = result;
//            if (id > 0)
//                SetUpdate();
//            printLog("addStudent:\n" + result);
            return "1";
        } catch (IOException e) {
            printLog("addCar Exception:\n" + e);
            return null;
        }
    }

    /**
     * add new client.
     * the function send the new client to php page that handle the "add function" and add the
     * new client to the client table(in our sql database).
     * @param newClient to be added
     * @return the client id.
     */
    @Override
    public long addUser(ContentValues newClient) {

        try {
            String result = PHPtools.POST(WEB_URL + "/insertClient.php", newClient);
            String s = result.trim();
            long id = Long.parseLong(s) ;

//            if (id > 0)
//                SetUpdate();
//            printLog("addStudent:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addCar Exception:\n" + e);
            return -1;
        }
    }

    /**
     * add new branch.
     * the function send the new branch to php page that handle the "add function" and add the
     * new branch to the branch table(in our sql database).
     * @param newBranch to be added
     * @return the branch number.
     */
    @Override
    public int addBranch(ContentValues newBranch) {

        try{
            String result = PHPtools.POST(WEB_URL + "insertBranch.php", newBranch);
            String s = result.trim();
            int id = Integer.parseInt(s) ;
  //          if (id > 0)
//                SetUpdate();
            printLog("addStudent:\n" + result);
                return id;
        } catch (IOException e) {
            e.getMessage();
            printLog("addBranch Exception:\n" + e);

            return -1;
        }

    }

    /**
     * the function use the php page that handel the "function that return all the cars model" to return all the cars model
     * @return all the cars model.
     */
    @Override
    public List<CarsModel> AllCarsModel() {
        List<CarsModel> result = new ArrayList<CarsModel>();

        try{
            String str = PHPtools.GET(WEB_URL+"/getAllCarModels.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("cars_model");

            for( int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                CarsModel carsModel = Car_GoConst.ContentValuesToCarModel(contentValues);
                result.add(carsModel);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * the function use the php page that handel the "function that return all the client" to return all the clients.
     * @return all the clients.
     */
    @Override
    public List<Client> AllUsers() {
        List<Client> result = new ArrayList<>();

        try{
            String str = PHPtools.GET(WEB_URL+"/getAllClients.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("client");

            for( int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Client client = Car_GoConst.ContentValuesToClient(contentValues);
                result.add(client);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * the function use the php page that handel the "function that return all the branch" to return all the branch.
     * @return all the branch.
     */
    @Override
    public List<Branch> AllBranch() {
        List<Branch> result = new ArrayList<Branch>();

        try{
            String str = PHPtools.GET(WEB_URL+"/getAllBranch.php");
            JSONArray jsonArray = new JSONObject(str).getJSONArray("branches");

            for( int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ContentValues contentValues = PHPtools.JsonToContentValues(jsonObject);
                Branch branch = Car_GoConst.ContentValuesToBranch(contentValues);
                result.add(branch);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * the function use the php page that handel the "function that return all the cars" to return all the cars.
     * @return all the cars.
     */
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



    //two function that printing to the screen - "the class properties/Exception".
    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }
    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
    }


}
