package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;

/**
 * Created by david salmon on 11/2/2017.
 */

/**
 * Car class represents the cars to rent.
 */
public class Car {
    //attributes
    private int BranchNumber;
    private int ModelType;//just int
    private int Kilometers;
    private String CarNumber;



    private boolean InUse;


    /**
     * default constructor.
     */
    public Car() {
    }

    /**
     * constructor.
     * @param branchNumber to insert branch number.
     * @param modelType to insert model type.
     * @param kilometers to insert kilometers.
     * @param carNumber to insert car number name.
     */
    public Car(int branchNumber, int modelType, int kilometers, String carNumber) {
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
    public int getModelType() {
        return ModelType;
    }

    /**
     * @param modelType to change the cutrrent car model type.
     */
    public void setModelType(int modelType) {
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

    /**
     * @return true if the car in use, false otherwise.
     */
    public boolean isInUse() {
        return InUse;
    }

    /**
     * @param inUse to change the inUse true/false.
     */
    public void setInUse(boolean inUse) {
        InUse = inUse;
    }

    /**
     *
     * @return string with all attribute of the class.
     */
    public String toString() {
        return "Branch Number: " + BranchNumber + " Model Type: " + ModelType + " Kilometers: " + Kilometers + " Car Number: " + CarNumber;
    }
}
