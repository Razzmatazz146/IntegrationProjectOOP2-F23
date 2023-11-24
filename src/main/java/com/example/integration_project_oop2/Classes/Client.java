package com.example.integration_project_oop2.Classes;

import java.time.LocalDate;

/**
 * Represents the theater's clients' Signup Date, Purchase History and Payment Info.
 *
 * Has methods to get and set Signup Date, Purchase History and Payment info as well as a @Client constructor.
 * Extends the User class to get username, password, first name, last name, e-mail address and phone number.
 */
public class Client extends User{
    private LocalDate aSignUpDate;
    private double aPurchaseHistory;
    private int aPaymentInfo;

    /**
     * Client constructor
     * @param pUsername User username.
     * @param pPassword User password.
     * @param pFirstName User first name.
     * @param pLastName User last name.
     * @param pEmail User e-mail address.
     * @param pPhoneNumber User phone number.
     * @param pSignUpDate User signup date.
     * @param pPurchaseHistory User purchase history.
     * @param pPaymentInfo User payment info.
     */
    public Client(String pUsername, String pPassword, String pFirstName, String pLastName, String pEmail, String pPhoneNumber, LocalDate pSignUpDate, double pPurchaseHistory, int pPaymentInfo) {
        super(pUsername, pPassword, pFirstName, pLastName, pEmail, pPhoneNumber);
        this.aSignUpDate = pSignUpDate;
        this.aPurchaseHistory = pPurchaseHistory;
        this.aPaymentInfo = pPaymentInfo;
    }

    public LocalDate getSignUpDate() {
        return aSignUpDate;
    }

    public double getPurchaseHistory() {
        return aPurchaseHistory;
    }

    public int getPaymentInfo() {
        return aPaymentInfo;
    }


    public void setSignUpDate(LocalDate pSignUpDate) {
        this.aSignUpDate = pSignUpDate;
    }

    public void setPurchaseHistory(double pPurchaseHistory) {
        this.aPurchaseHistory = pPurchaseHistory;
    }

    public void setPaymentInfo(int pPaymentInfo) {
        this.aPaymentInfo = pPaymentInfo;
    }
}
