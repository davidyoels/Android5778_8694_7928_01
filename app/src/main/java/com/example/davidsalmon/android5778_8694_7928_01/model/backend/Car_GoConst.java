package com.example.davidsalmon.android5778_8694_7928_01.model.backend;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.CarsModel;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Client;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Gearbox;

/**
 * Created by itay0 on 12/11/2017.
 */
/**
 * All the class down below in format of key and value.
 * this needed for ContentValues which also goes with key and value.
 * With ContentValues we can send to the php page parameters.
 * Also we will convert from ContentValues to our classes(Car/Branch..) and also the same to other side.
 */
public class Car_GoConst {


    /**
     * format of key and value for the Branch class.
     */
    public static class BranchConst {
        public static final String CITY = "city";
        public static final String STREET = "street";
        public static final String BUILDING_NUMBER = "building_number";
        public static final String PARKING_SPACE_NUMBER = "parking_spaces_number";
        public static final String BRANCH_NUMBER = "_id";
    }

    /**
     * format of key and value for the Car class.
     */
    public static class CarConst {
        public static final String BRANCH_NUMBER = "branch_number";
        public static final String MODEL_TYPE = "model_type";
        public static final String KILOMETERS = "kilometer";
        public static final String CAR_NUMBER = "_id";
    }

    /**
     * format of key and value for the Car Model class.
     */
    public static class CarModelConst {
        public static final String MODEL_CODE = "_id";
        public static final String COMPANY_NAME = "company_name";
        public static final String MODEL_NAME = "model_name";
        public static final String ENGINE_CAPACITY = "engine_capacity";
        public static final String GEAR_BOX = "gearbox";
        public static final String SEATS_NUMBER = "seat_number";
    }

    /**
     * format of key and value for the Client class.
     */
    public static class ClientConst {
        public static final String FAMILY_NAME = "family_name";
        public static final String PRIVATE_NAME = "private_name";
        public static final String ID = "_id";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String EMAIL = "email";
        public static final String CREDIT_CARD = "credit_card";
    }

    /**
     * convert Car to ContentValues.
     * @param car to be convert.
     * @return ContentValues with key and value format of Car(like we defined earlier-lines 37-42).
     */
    public static ContentValues CarToContentValues(Car car) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.CarConst.BRANCH_NUMBER, car.getBranchNumber());
        contentValues.put(Car_GoConst.CarConst.MODEL_TYPE, car.getModelType());
        contentValues.put(Car_GoConst.CarConst.KILOMETERS, car.getKilometers());
        contentValues.put(Car_GoConst.CarConst.CAR_NUMBER, car.getCarNumber());
        return contentValues;
    }

    /**
     * convert ContentValues to Car.
     * @param contentValues to be convert.
     * @return instance of Car with the ContentValues values.
     */
    public static Car ContentValuesToCar(ContentValues contentValues) {
        Car car = new Car();
        car.setBranchNumber(contentValues.getAsInteger(Car_GoConst.CarConst.BRANCH_NUMBER));
        car.setModelType(contentValues.getAsInteger(Car_GoConst.CarConst.MODEL_TYPE));
        car.setKilometers(contentValues.getAsInteger(Car_GoConst.CarConst.KILOMETERS));
        car.setCarNumber(contentValues.getAsString(Car_GoConst.CarConst.CAR_NUMBER));
        return car;
    }

    /**
     * convert Branch to ContentValues.
     * @param branch to be convert.
     * @return ContentValues with key and value format of Branch(like we defined earlier-lines 26-32).
     */
    public static ContentValues BranchToContentValues(Branch branch) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.BranchConst.BRANCH_NUMBER, branch.getBranchNumber());
        contentValues.put(Car_GoConst.BranchConst.CITY, branch.getCity());
        contentValues.put(Car_GoConst.BranchConst.STREET, branch.getStreet());
        contentValues.put(Car_GoConst.BranchConst.BUILDING_NUMBER, branch.getBuildingNumber());
        contentValues.put(Car_GoConst.BranchConst.PARKING_SPACE_NUMBER, branch.getParkingSpacesNumber());
        return contentValues;
    }


    /**
     * convert ContentValues to Branch.
     * @param contentValues to be convert.
     * @return instance of Branch
     */
    public static Branch ContentValuesToBranch(ContentValues contentValues) {

        Branch branch = new Branch();
        branch.setBranchNumber(contentValues.getAsInteger(Car_GoConst.BranchConst.BRANCH_NUMBER));
        branch.setCity(contentValues.getAsString(Car_GoConst.BranchConst.CITY));
        branch.setStreet(contentValues.getAsString((Car_GoConst.BranchConst.STREET)));
        branch.setBuildingNumber( contentValues.getAsInteger(BranchConst.BUILDING_NUMBER));
        branch.setParkingSpacesNumber(contentValues.getAsInteger(BranchConst.PARKING_SPACE_NUMBER));

        return branch;
    }

    /**
     * convert Car Model to ContentValues.
     * @param carModel to be convert.
     * @return ContentValues with key and value format of Car Model(like we defined earlier-lines 26-32).
     */
    public static ContentValues CarModelToContentValues(CarsModel carModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.CarModelConst.MODEL_CODE, carModel.getModelCode());
        contentValues.put(Car_GoConst.CarModelConst.COMPANY_NAME, carModel.getCompanyName());
        contentValues.put(Car_GoConst.CarModelConst.MODEL_NAME, carModel.getModelName());
        contentValues.put(Car_GoConst.CarModelConst.ENGINE_CAPACITY, carModel.getEngineCapacity());
        contentValues.put(Car_GoConst.CarModelConst.GEAR_BOX, carModel.getGearBox().toString());
        contentValues.put(Car_GoConst.CarModelConst.SEATS_NUMBER, carModel.getSeatsNumber());
        return contentValues;
    }

    /**
     * convert ContentValues to Car Model.
     * @param contentValues to be convert.
     * @return instance of Car Model with the ContentValues values.
     */
    public static CarsModel ContentValuesToCarModel(ContentValues contentValues) {
        CarsModel carModel = new CarsModel();
        carModel.setCompanyName(contentValues.getAsString(Car_GoConst.CarModelConst.COMPANY_NAME));
        carModel.setEngineCapacity(contentValues.getAsInteger(Car_GoConst.CarModelConst.ENGINE_CAPACITY));
        carModel.setGearBox(Gearbox.valueOf(contentValues.getAsString(Car_GoConst.CarModelConst.GEAR_BOX)));
        carModel.setModelCode(contentValues.getAsInteger(Car_GoConst.CarModelConst.MODEL_CODE));
        carModel.setModelName(contentValues.getAsString(Car_GoConst.CarModelConst.MODEL_NAME));
        carModel.setSeatsNumber(contentValues.getAsInteger(Car_GoConst.CarModelConst.SEATS_NUMBER));
        return carModel;
    }

    /**
     * convert Client to ContentValues.
     * @param client to be convert.
     * @return ContentValues with key and value format of Client(like we defined earlier-lines 59-66).
     */
    public static ContentValues ClientToContentValues(Client client) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.ClientConst.FAMILY_NAME, client.getFamilyName());
        contentValues.put(Car_GoConst.ClientConst.PRIVATE_NAME, client.getPrivateName());
        contentValues.put(Car_GoConst.ClientConst.ID, client.getId());
        contentValues.put(Car_GoConst.ClientConst.PHONE_NUMBER, client.getPhoneNumber());
        contentValues.put(Car_GoConst.ClientConst.EMAIL, client.getEmail());
        contentValues.put(Car_GoConst.ClientConst.CREDIT_CARD, client.getCreditCard());
        return contentValues;
    }
    /**
     * convert ContentValues to Client.
     * @param contentValues to be convert.
     * @return instance of Client with the ContentValues values.
     */
    public static Client ContentValuesToClient(ContentValues contentValues) {
        Client client = new Client();
        client.setId(contentValues.getAsLong(Car_GoConst.ClientConst.ID));
        client.setFamilyName(contentValues.getAsString(Car_GoConst.ClientConst.FAMILY_NAME));
        client.setPrivateName(contentValues.getAsString(Car_GoConst.ClientConst.PRIVATE_NAME));
        client.setPhoneNumber(contentValues.getAsString(Car_GoConst.ClientConst.PHONE_NUMBER));
        client.setEmail(contentValues.getAsString(Car_GoConst.ClientConst.EMAIL));
        client.setCreditCard(contentValues.getAsInteger(Car_GoConst.ClientConst.CREDIT_CARD));
        return client;
    }

}
