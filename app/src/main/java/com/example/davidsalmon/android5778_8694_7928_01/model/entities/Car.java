package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;

/**
 * Created by david salmon on 11/2/2017.
 */

public class Car {
    //
    private int BranchNumber;
    private String ModelType;
    private int Kilometers;
    private String CarNumber;

    public Car() {
    }

    public Car(int branchNumber, String modelType, int kilometers, String carNumber) {
        BranchNumber = branchNumber;
        ModelType = modelType;
        Kilometers = kilometers;
        CarNumber = carNumber;
    }

    /**
     * @return the branch number.
     */
    public int getBranchNumber() {
        return BranchNumber;
    }

    /**
     * @param branchNumber to change the current branch number.
     */
    public void setBranchNumber(int branchNumber) {
        BranchNumber = branchNumber;
    }

    /**
     * @return the car model type.
     */
    public String getModelType() {
        return ModelType;
    }

    /**
     * @param modelType to change the cutrrent car model type.
     */
    public void setModelType(String modelType) {
        ModelType = modelType;
    }

    /**
     * @return the car kilometers.
     */
    public int getKilometers() {
        return Kilometers;
    }

    /**
     * @param kilometers to change the current car kilometers.
     */
    public void setKilometers(int kilometers) {
        Kilometers = kilometers;
    }

    /**
     * @return the car number.
     */
    public String getCarNumber() {
        return CarNumber;
    }

    /**
     * @param carNumber to change the car number.
     */
    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public String toString() {
        return "Branch Number: " + BranchNumber + " Model Type: " + ModelType + " Kilometers: " + Kilometers + " Car Number: " + CarNumber;
    }

    //********ContentValues*******
    public static ContentValues CarToContentValues(Car car) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.CarConst.BRANCH_NUMBER, car.BranchNumber);
        contentValues.put(Car_GoConst.CarConst.MODEL_TYPE, car.ModelType);
        contentValues.put(Car_GoConst.CarConst.KILOMETERS, car.Kilometers);
        contentValues.put(Car_GoConst.CarConst.CAR_NUMBER, car.CarNumber);
        return contentValues;
    }

    public static Car ContentValuesToCar(ContentValues contentValues) {
        Car car = new Car();
        car.setBranchNumber(contentValues.getAsInteger(Car_GoConst.CarConst.BRANCH_NUMBER));
        car.setModelType(contentValues.getAsString(Car_GoConst.CarConst.MODEL_TYPE));
        car.setKilometers(contentValues.getAsInteger(Car_GoConst.CarConst.KILOMETERS));
        car.setCarNumber(contentValues.getAsString(Car_GoConst.CarConst.CAR_NUMBER));
        return car;
    }

}
