package com.example.davidsalmon.android5778_8694_7928_01.model.entities;

import android.provider.ContactsContract;

/**
 * Created by david salmon on 11/4/2017.
 */

public class Client {
    private String FamilyName;
    private String PrivateName;
    private long Id;
    private String PhoneNumber;
    private ContactsContract.CommonDataKinds.Email email;
    private long CreditCard;

    // default constructor.
    public Client() {
    }

    //constructor.
    public Client(String familyName, String privateName, long id, String phoneNumber, ContactsContract.CommonDataKinds.Email email, long creditCard) {
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
    public ContactsContract.CommonDataKinds.Email getEmail() {
        return email;
    }

    /**
     * @param email to change the current email.
     */
    public void setEmail(ContactsContract.CommonDataKinds.Email email) {
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
}
