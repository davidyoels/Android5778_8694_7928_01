package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

/**
 * Created by david salmon on 11/2/2017.
 */
enum Gearbox {Manual, Automaton}
public class CarsModel {

    private int ModelCode;
    private String CompanyName;
    private String ModelName;
    private int EngineCapacity;
    private Gearbox GearBox;
    private int SeatsNumber;
    //default constrcutor
    public CarsModel(){}

    public CarsModel(int modelCode, String companyName, String modelName, int engineCapacity, Gearbox gearBox, int seatsNumber) {
        ModelCode = modelCode;
        CompanyName = companyName;
        ModelName = modelName;
        EngineCapacity = engineCapacity;
        GearBox = gearBox;
        SeatsNumber = seatsNumber;
    }

    /**
     *
     * @return the car Model code.
     */
    public int getModelCode() {
        return ModelCode;
    }

    /**
     *
     * @param modelCode to change the current model code.
     */
    public void setModelCode(int modelCode) {
        ModelCode = modelCode;
    }

    /**
     *
     * @return the company name.
     */
    public String getCompanyName() { return CompanyName; }

    /**
     *
     * @param companyName to change the current company name.
     */
    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    /**
     *
     * @return the car model name.
     */
    public String getModelName() {
        return ModelName;
    }

    /**
     *
     * @param modelName to change the current car model name.
     */
    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    /**
     *
     * @return the car engine capacity.
     */
    public int getEngineCapacity() {
        return EngineCapacity;
    }

    /**
     *
     * @param engineCapacity to change the current car engine capacity.
     */
    public void setEngineCapacity(int engineCapacity) {
        EngineCapacity = engineCapacity;
    }

    /**
     *
     * @return the car gear box.
     */
    public Gearbox getGearBox() {
        return GearBox;
    }

    /**
     *
     * @param gearBox to change the current car gear box.
     */
    public void setGearBox(Gearbox gearBox) {
        GearBox = gearBox;
    }

    /**
     *
     * @return the car seats number.
     */
    public int getSeatsNumber() {
        return SeatsNumber;
    }

    /**
     *
     * @param seatsNumber to change the current seats number.
     */
    public void setSeatsNumber(int seatsNumber) {
        SeatsNumber = seatsNumber;
    }




}
