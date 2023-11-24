package com.example.integration_project_oop2.Classes;

/**
 * Represents the theater's Users. This is a Parent of Manager and Client.
 *
 * Has methods to get and set Username, Password, First Name, Last Name, Email and Phone Number, as
 * well as a @User constructor.
 */
public class User {
    private String aUsername;
    private String aPassword;
    private String aFirstName;
    private String aLastName;
    private String aEmail;
    private String aPhoneNumber;

    /**
     * User constructor.
     * @param pUsername User username.
     * @param pPassword User password.
     * @param pFirstName User first name.
     * @param pLastName User last name.
     * @param pEmail User e-mail address.
     * @param pPhoneNumber User phone number.
     */
    public User(String pUsername, String pPassword, String pFirstName, String pLastName, String pEmail, String pPhoneNumber) {
        this.aUsername = pUsername;
        this.aPassword = pPassword;
        this.aFirstName = pFirstName;
        this.aLastName = pLastName;
        this.aEmail = pEmail;
        this.aPhoneNumber = pPhoneNumber;
    }

    public String getUsername() {
        return aUsername;
    }
    public String getPassword() {
        return aPassword;
    }
    public String getFirstName() {
        return aFirstName;
    }
    public String getLastName() {
        return aLastName;
    }
    public String getEmail() {
        return aEmail;
    }
    public String getPhoneNumber() {
        return aPhoneNumber;
    }

    public void setUsername(String pUsername) {
        this.aUsername = pUsername;
    }
    public void setPassword(String pPassword) {
        this.aPassword = pPassword;
    }
    public void setFirstName(String pFirstName) {
        this.aFirstName = pFirstName;
    }
    public void setLastName(String pLastName) {
        this.aLastName = pLastName;
    }
    public void setEmail(String pEmail) {
        this.aEmail = pEmail;
    }
    public void setPhoneNumber(String pPhoneNumber) {
        this.aPhoneNumber = pPhoneNumber;
    }
}
