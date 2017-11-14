package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;

/**
 * Created by david salmon on 11/2/2017.
 */

public class Branch {

    private String City;
    private String Street;
    private int BuildingNumber;
    private int ParkingSpacesNumber;
    private int BranchNumber; //ID

    //default constructor.
    public Branch(){}

    //constructor.
    public Branch(String city, String street, int buildingNumber, int parkingSpacesNumber, int branchNumber) {
        City = city;
        Street = street;
        BuildingNumber = buildingNumber;
        ParkingSpacesNumber = parkingSpacesNumber;
        BranchNumber = branchNumber;
    }

    /**
     * @return the branch city.
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param city to chanbge the current branch city.
     */
    public void setCity(String city) {
        City = city;
    }

    /**
     * @return the branch street.
     */
    public String getStreet() {
        return Street;
    }

    /**
     *
     * @param street to change the current street.
     */
    public void setStreet(String street) {
        Street = street;
    }

    /**
     *
     * @return the branch building number.
     */
    public int getBuildingNumber() {
        return BuildingNumber;
    }

    /**
     *
     * @param buildingNumber to change the current building number.
     */
    public void setBuildingNumber(int buildingNumber) {
        BuildingNumber = buildingNumber;
    }

    /**
     *
     * @return the number of parking spaces.
     */
    public int getParkingSpacesNumber() {
        return ParkingSpacesNumber;
    }

    /**
     *
     * @param parkingSpacesNumber to change the current number of parking spaces.
     */
    public void setParkingSpacesNumber(int parkingSpacesNumber) {
        ParkingSpacesNumber = parkingSpacesNumber;
    }

    /**
     *
     * @return the branch number.
     */
    public int getBranchNumber() {
        return BranchNumber;
    }

    /**
     *
     * @param branchNumber to change the current branch number.
     */
    public void setBranchNumber(int branchNumber) {
        BranchNumber = branchNumber;
    }

    public String toString()
    {
        return " City: " + City + " Street: " +  Street + " Building Number: " + BuildingNumber + " Parking Spaces: " + ParkingSpacesNumber + " Brach Number: " + BranchNumber;
    }


    //********ContentValues*******
    public static ContentValues BranchToContentValues(Branch branch){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.BranchConst.CITY, branch.getCity());
        contentValues.put(Car_GoConst.BranchConst.STREET, branch.getStreet());
        contentValues.put(Car_GoConst.BranchConst.BUILDING_NUMBER, branch.getBuildingNumber());
        contentValues.put(Car_GoConst.BranchConst.PARKING_SPACE_NUMBER, branch.getParkingSpacesNumber());
        contentValues.put(Car_GoConst.BranchConst.BRANCH_NUMBER, branch.BranchNumber);

        return contentValues;
    }

    public static Branch ContentValuesToBranch(ContentValues contentValues){

        Branch branch = new Branch();
        branch.setCity(contentValues.getAsString(Car_GoConst.BranchConst.CITY));
        branch.setStreet(contentValues.getAsString(Car_GoConst.BranchConst.STREET));
        branch.setBuildingNumber(contentValues.getAsInteger(Car_GoConst.BranchConst.BUILDING_NUMBER));
        branch.setParkingSpacesNumber(contentValues.getAsInteger(Car_GoConst.BranchConst.PARKING_SPACE_NUMBER));
        branch.setBranchNumber(contentValues.getAsInteger(Car_GoConst.BranchConst.BRANCH_NUMBER));
        return branch;
    }

}
