package com.example.integration_project_oop2.Classes;

/**
 * Represents the theater's Users. This is a Parent of Manager and Client.
 *
 * Has methods to get and set Username, Password, First Name, Last Name, Email and Phone Number, as
 * well as a @User constructor.
 */
abstract class User {
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
        this.setUsername(pUsername);
        this.setPassword(pPassword);
        this.setFirstName(pFirstName);
        this.setLastName(pLastName);
        this.setEmail(pEmail);
        this.setPhoneNumber(pPhoneNumber);
    }

    /**
     * Gets the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return aUsername;
    }

    /**
     * Gets the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return aPassword;
    }

    /**
     * Gets the first name of the user.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return aFirstName;
    }

    /**
     * Gets the last name of the user.
     *
     * @return The last name.
     */
    public String getLastName() {
        return aLastName;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return aEmail;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return aPhoneNumber;
    }

    /**
     * Sets the username of the user.
     *
     * @param pUsername The new username.
     */
    public void setUsername(String pUsername) {
        this.aUsername = pUsername;
    }

    /**
     * Sets the password of the user.
     *
     * @param pPassword The new password.
     */
    public void setPassword(String pPassword) {
        this.aPassword = pPassword;
    }

    /**
     * Sets the first name of the user.
     *
     * @param pFirstName The new first name.
     */
    public void setFirstName(String pFirstName) {
        this.aFirstName = pFirstName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param pLastName The new last name.
     */
    public void setLastName(String pLastName) {
        this.aLastName = pLastName;
    }

    /**
     * Sets the email address of the user.
     *
     * @param pEmail The new email address.
     */
    public void setEmail(String pEmail) {
        this.aEmail = pEmail;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param pPhoneNumber The new phone number.
     */
    public void setPhoneNumber(String pPhoneNumber) {
        this.aPhoneNumber = pPhoneNumber;
    }
}
