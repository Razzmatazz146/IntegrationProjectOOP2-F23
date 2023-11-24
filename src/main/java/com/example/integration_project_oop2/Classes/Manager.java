package com.example.integration_project_oop2.Classes;

public class Manager extends User{
    private String aEmployeeId;
    private String aPosition;
    private double aHours;
    private String aPermission;
    public Manager(String pUsername, String pPassword, String pFirstName, String pLastName, String pEmail, String pPhoneNumber,
                   String pEmployeeId, String pPosition, double pHours, String pPermission) {
        super(pUsername, pPassword, pFirstName, pLastName, pEmail, pPhoneNumber);
        this.aEmployeeId = pEmployeeId;
        this.aPosition = pPosition;
        this.aHours = pHours;
        this.aPermission = pPermission;
    }
    public String getEmployeeId() {
        return aEmployeeId;
    }

    public void setEmployeeId(String pEmployeeId) {
        this.aEmployeeId = pEmployeeId;
    }

    public String getPosition() {
        return aPosition;
    }

    public void setPosition(String pPosition) {
        this.aPosition = pPosition;
    }

    public double getHours() {
        return aHours;
    }

    public void setHours(double pHours) {
        this.aHours = pHours;
    }

    public String getPermission() {
        return aPermission;
    }

    public void setPermission(String pPermission) {
        this.aPermission = pPermission;
    }
}
