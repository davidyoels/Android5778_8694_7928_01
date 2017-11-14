package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;

public class CarsModel {

    private int ModelCode;
    private String CompanyName;
    private String ModelName;
    private int EngineCapacity;
    private Gearbox GearBox;
    private int SeatsNumber;

    //default constructor
    public CarsModel() {
    }

    public CarsModel(int modelCode, String companyName, String modelName, int engineCapacity, Gearbox gearBox, int seatsNumber) {
        ModelCode = modelCode;
        CompanyName = companyName;
        ModelName = modelName;
        EngineCapacity = engineCapacity;
        GearBox = gearBox;
        SeatsNumber = seatsNumber;
    }

    /**
     * @return the car Model code.
     */
    public int getModelCode() {
        return ModelCode;
    }

    /**
     * @param modelCode to change the current model code.
     */
    public void setModelCode(int modelCode) {
        ModelCode = modelCode;
    }

    /**
     * @return the company name.
     */
    public String getCompanyName() {
        return CompanyName;
    }

    /**
     * @param companyName to change the current company name.
     */
    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    /**
     * @return the car model name.
     */
    public String getModelName() {
        return ModelName;
    }

    /**
     * @param modelName to change the current car model name.
     */
    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    /**
     * @return the car engine capacity.
     */
    public int getEngineCapacity() {
        return EngineCapacity;
    }

    /**
     * @param engineCapacity to change the current car engine capacity.
     */
    public void setEngineCapacity(int engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    /**
     * @return the car gear box.
     */
    public Gearbox getGearBox() {
        return GearBox;
    }

    /**
     * @param gearBox to change the current car gear box.
     */
    public void setGearBox(Gearbox gearBox) {
        GearBox = gearBox;
    }

    /**
     * @return the car seats number.
     */
    public int getSeatsNumber() {
        return SeatsNumber;
    }

    /**
     * @param seatsNumber to change the current seats number.
     */
    public void setSeatsNumber(int seatsNumber) {
        SeatsNumber = seatsNumber;
    }

    public String toString() {
        return "Model Code: " + ModelCode + " Company Name: " + CompanyName + " Model Name: " + ModelName + "Engine Capacity: " + " Gear Box: " + GearBox + " Seat Numbers: " + SeatsNumber;
    }

    //********ContentValues*******
    public static ContentValues CarModelToContentValues(CarsModel carModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.CarModelConst.MODEL_CODE, carModel.ModelCode);
        contentValues.put(Car_GoConst.CarModelConst.COMPANY_NAME, carModel.CompanyName);
        contentValues.put(Car_GoConst.CarModelConst.MODEL_NAME, carModel.ModelName);
        contentValues.put(Car_GoConst.CarModelConst.ENGINE_CAPACITY, carModel.EngineCapacity);
        //gearbox need to check if this is the right cast
        contentValues.put(Car_GoConst.CarModelConst.GEAR_BOX, carModel.GearBox.toString());
        contentValues.put(Car_GoConst.CarModelConst.SEATS_NUMBER, carModel.SeatsNumber);
        return contentValues;
    }

    public static CarsModel ContentValuesToCarModel(ContentValues contentValues) {
        CarsModel carModel = new CarsModel();
        carModel.setCompanyName(contentValues.getAsString(Car_GoConst.CarModelConst.COMPANY_NAME));
        carModel.setEngineCapacity(contentValues.getAsInteger(Car_GoConst.CarModelConst.ENGINE_CAPACITY));
        //need to check how to cast enum
        //carModel.setGearBox(contentValues.getAsString(Car_GoConst.CarModelConst.GEAR_BOX));
        carModel.setModelCode(contentValues.getAsInteger(Car_GoConst.CarModelConst.MODEL_CODE));
        carModel.setModelName(contentValues.getAsString(Car_GoConst.CarModelConst.MODEL_NAME));
        carModel.setSeatsNumber(contentValues.getAsInteger(Car_GoConst.CarModelConst.SEATS_NUMBER));
        return carModel;
    }


}
