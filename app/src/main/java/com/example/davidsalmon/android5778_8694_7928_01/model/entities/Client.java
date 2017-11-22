package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

import android.content.ContentValues;
import android.provider.ContactsContract;

import com.example.davidsalmon.android5778_8694_7928_01.model.backend.Car_GoConst;

/**
 * Created by david salmon on 11/4/2017.
 */

public class Client {
    public String FamilyName;
    private String PrivateName;
    public long Id;
    private String PhoneNumber;
    private String email;
    private long CreditCard;

    // default constructor.
    public Client() {
    }

    //constructor.
    public Client(String familyName, String privateName, long id, String phoneNumber, String email, long creditCard) {
        FamilyName = familyName;
        PrivateName = privateName;
        Id = id;
        PhoneNumber = phoneNumber;
        this.email = email;
        CreditCard = creditCard;
    }

    /**
     * @return the client family name.
     */
    public String getFamilyName() {
        return FamilyName;
    }

    /**
     * @param familyName to change the current family name.
     */
    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    /**
     * @return the client private name.
     */
    public String getPrivateName() {
        return PrivateName;
    }

    /**
     * @param privateName to change the current private name.
     */
    public void setPrivateName(String privateName) {
        PrivateName = privateName;
    }

    /**
     * @return the client phone number.
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param phoneNumber to change the current phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    /**
     * @return the client id.
     */
    public long getId() {
        return Id;
    }

    /**
     * @return the client email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email to change the current email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the client credit card number.
     */
    public long getCreditCard() {
        return CreditCard;
    }

    /**
     * @param creditCard to change the current credic card number.
     */
    public void setCreditCard(long creditCard) {
        CreditCard = creditCard;
    }

    public String toString()
    {
        return "Name: " + PrivateName + " " + FamilyName + " Id: " + Id + " Phone Number: " + PhoneNumber + " Email: " + email + " Credit Card: " + CreditCard;
    }

    //********ContentValues*******
    public static ContentValues ClientToContentValues(Client client) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Car_GoConst.ClientConst.FAMILY_NAME, client.FamilyName);
        contentValues.put(Car_GoConst.ClientConst.PRIVATE_NAME, client.PrivateName);
        contentValues.put(Car_GoConst.ClientConst.ID, client.Id);
        contentValues.put(Car_GoConst.ClientConst.PHONE_NUMBER, client.PhoneNumber);
        contentValues.put(Car_GoConst.ClientConst.EMAIL, client.email);
        contentValues.put(Car_GoConst.ClientConst.CREDIT_CARD, client.CreditCard);
        return contentValues;
    }

    public static Client ContentValuesToClient(ContentValues contentValues) {
        Client client = new Client();
        client.setFamilyName(contentValues.getAsString(Car_GoConst.ClientConst.FAMILY_NAME));
        client.setPrivateName(contentValues.getAsString(Car_GoConst.ClientConst.PRIVATE_NAME));
        client.setPhoneNumber(contentValues.getAsString(Car_GoConst.ClientConst.PHONE_NUMBER));
        client.setEmail(contentValues.getAsString(Car_GoConst.ClientConst.EMAIL));
        client.setCreditCard(contentValues.getAsInteger(Car_GoConst.ClientConst.CREDIT_CARD));
        return client;
    }
}
