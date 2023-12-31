package com.example.integration_project_oop2.Classes;

import java.io.Serializable;

/**
 * Represents the theater's Manager.
 *
 * Has methods to get and set the "IsManager" boolean as well as a @Manager constructor.
 * Extends the User class to get username, password, first name, last name, e-mail address and phone number.
 */
public class Manager extends User implements Serializable {

    /**
     * Manager constructor.
     *
     * @param pUsername    User username.
     * @param pPassword    User password.
     * @param pFirstName   User first name.
     * @param pLastName    User last name.
     * @param pEmail       User e-mail address.
     * @param pPhoneNumber User phone number.
     * @param pIsManager   User manager boolean.
     */
    public Manager(String pUsername, String pPassword, String pFirstName, String pLastName, String pEmail, String pPhoneNumber, boolean pIsManager) {
        super(pUsername, pPassword, pFirstName, pLastName, pEmail, pPhoneNumber, pIsManager);
    }
}
