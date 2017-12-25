package com.example.davidsalmon.android5778_8694_7928_01.model.backend;

import android.content.ContentValues;

import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Branch;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Car;
import com.example.davidsalmon.android5778_8694_7928_01.model.entities.Gearbox;

/**
 * Created by itay0 on 12/11/2017.
 */

public class Car_GoConst {


    public static class BranchConst {
        public static final String CITY = "city";
        public static final String STREET = "street";
        public static final String BUILDING_NUMBER = "building_number";
        public static final String PARKING_SPACE_NUMBER = "parking_spaces_number";
        public static final String BRANCH_NUMBER = "_id";
    }

    public static class CarConst {
        public static final String BRANCH_NUMBER = "branch_number";
        public static final String MODEL_TYPE = "model_type";
        public static final String KILOMETERS = "kilometer";
        public static final String CAR_NUMBER = "_id";
    }

    public static class CarModelConst {
        public static final String MODEL_CODE = "model_code";
        public static final String COMPANY_NAME = "company_name";
        public static final String MODEL_NAME = "model_name";
        public static final String ENGINE_CAPACITY = "engine_capacity";
        public static final String GEAR_BOX = "gear_box";
        public static final String SEATS_NUMBER = "seats_number";
    }

    public static class ClientConst {
        public static final String FAMILY_NAME = "family_name";
        public static final String PRIVATE_NAME = "private_name";
        public static final String ID = "_id";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String EMAIL = "email";
        public static final String CREDIT_CARD = "credit_card";
    }

    public static ContentValues CarToContentValues(Car car) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.CarConst.BRANCH_NUMBER, car.getBranchNumber());
        contentValues.put(Car_GoConst.CarConst.MODEL_TYPE, car.getModelType());
        contentValues.put(Car_GoConst.CarConst.KILOMETERS, car.getKilometers());
        contentValues.put(Car_GoConst.CarConst.CAR_NUMBER, car.getCarNumber());
        return contentValues;
    }

    public static Car ContentValuesToCar(ContentValues contentValues) {
        Car car = new Car();
        car.setBranchNumber(contentValues.getAsInteger(Car_GoConst.CarConst.BRANCH_NUMBER));
        car.setModelType(contentValues.getAsInteger(Car_GoConst.CarConst.MODEL_TYPE));
        car.setKilometers(contentValues.getAsInteger(Car_GoConst.CarConst.KILOMETERS));
        car.setCarNumber(contentValues.getAsString(Car_GoConst.CarConst.CAR_NUMBER));
        return car;
    }

    public static ContentValues BranchToContentValues(Branch branch) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.BranchConst.BRANCH_NUMBER, branch.getBranchNumber());
        contentValues.put(Car_GoConst.BranchConst.CITY, branch.getCity());
        contentValues.put(Car_GoConst.BranchConst.STREET, branch.getStreet());
        contentValues.put(Car_GoConst.BranchConst.BUILDING_NUMBER, branch.getBuildingNumber());
        contentValues.put(Car_GoConst.BranchConst.PARKING_SPACE_NUMBER, branch.getParkingSpacesNumber());
        return contentValues;
    }

    public static Branch ContentValuesToBranch(ContentValues contentValues) {

        Branch branch = new Branch();
        branch.setBranchNumber(contentValues.getAsInteger(Car_GoConst.BranchConst.BRANCH_NUMBER));
        branch.setCity(contentValues.getAsString(Car_GoConst.BranchConst.CITY));
        branch.setStreet(contentValues.getAsString((Car_GoConst.BranchConst.STREET)));
        branch.setBuildingNumber( contentValues.getAsInteger(BranchConst.BUILDING_NUMBER));
        branch.setParkingSpacesNumber(contentValues.getAsInteger(BranchConst.PARKING_SPACE_NUMBER));

        return branch;
    }

}
