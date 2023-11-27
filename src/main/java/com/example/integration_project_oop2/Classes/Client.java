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
        this.setSignUpDate(pSignUpDate);
        this.setPurchaseHistory(pPurchaseHistory);
        this.setPaymentInfo(pPaymentInfo);
    }

    /**
     * Gets the sign-up date of the user's account.
     *
     * @return The sign-up date.
     */
    public LocalDate getSignUpDate() {
        return aSignUpDate;
    }

    /**
     * Gets the purchase history of the user's account.
     *
     * @return The purchase history.
     */
    public double getPurchaseHistory() {
        return aPurchaseHistory;
    }

    /**
     * Gets the payment information associated with the user's account.
     *
     * @return The payment information.
     */
    public int getPaymentInfo() {
        return aPaymentInfo;
    }

    /**
     * Sets the sign-up date of the user's account.
     *
     * @param pSignUpDate The new sign-up date.
     */
    public void setSignUpDate(LocalDate pSignUpDate) {
        if (pSignUpDate == null)
            throw new IllegalArgumentException("SignUpDate cannot be null");
        if (pSignUpDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("SignUpDate cannot be in the future");
        this.aSignUpDate = pSignUpDate;
    }

    /**
     * Sets the purchase history of the user's account.
     *
     * @param pPurchaseHistory The new purchase history.
     */
    public void setPurchaseHistory(double pPurchaseHistory) {
        this.aPurchaseHistory = pPurchaseHistory;
    }

    /**
     * Sets the payment information associated with the user's account.
     *
     * @param pPaymentInfo The new payment information.
     */
    public void setPaymentInfo(int pPaymentInfo) {
        this.aPaymentInfo = pPaymentInfo;
    }
}
