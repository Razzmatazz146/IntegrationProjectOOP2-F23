package com.example.integration_project_oop2.Classes;

import java.time.LocalDate;

public class Client extends User{
    private LocalDate aSignUpDate;
    private double aPurchaseHistory;
    private int aPaymentInfo;

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

    // Setters for new attributes
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
