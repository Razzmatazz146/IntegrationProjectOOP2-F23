package com.example.integration_project_oop2.Classes;

/**
 * Represents the theater's Manager and Staff's Employee ID, job position, hours per week and permissions.
 *
 * Has methods to get and set Employee ID, Position, House and Permissions, as well as a @Manager constructor.
 * Extends the User class to get username, password, first name, last name, e-mail address and phone number.
 */
public class Manager extends User{
    private String aEmployeeId;
    private String aPosition;
    private double aHours;
    private String aPermission;

    /**
     * Manager constructor.
     * @param pUsername User username.
     * @param pPassword User password.
     * @param pFirstName User first name.
     * @param pLastName User last name.
     * @param pEmail User e-mail address.
     * @param pPhoneNumber User phone number.
     * @param pEmployeeId User Employee ID.
     * @param pPosition User Job Position.
     * @param pHours User Hours per week.
     * @param pPermission User permissions to CRUD theater information.
     */
    public Manager(String pUsername, String pPassword, String pFirstName, String pLastName, String pEmail, String pPhoneNumber,
                   String pEmployeeId, String pPosition, double pHours, String pPermission) {
        super(pUsername, pPassword, pFirstName, pLastName, pEmail, pPhoneNumber);
        this.aEmployeeId = pEmployeeId;
        this.aPosition = pPosition;
        this.aHours = pHours;
        this.aPermission = pPermission;
    }

    /**
     * Gets the employee ID.
     *
     * @return The employee ID.
     */
    public String getEmployeeId() {
        return aEmployeeId;
    }

    /**
     * Gets the position of the employee.
     *
     * @return The employee position.
     */
    public String getPosition() {
        return aPosition;
    }

    /**
     * Gets the number of hours worked by the employee.
     *
     * @return The hours worked.
     */
    public double getHours() { return aHours; }

    /**
     * Gets the permission level of the employee.
     *
     * @return The employee permission level.
     */
    public String getPermission() {
        return aPermission;
    }

    /**
     * Sets the employee ID.
     *
     * @param pEmployeeId The new employee ID.
     */
    public void setEmployeeId(String pEmployeeId) {
        this.aEmployeeId = pEmployeeId;
    }

    /**
     * Sets the position of the employee.
     *
     * @param pPosition The new employee position.
     */
    public void setPosition(String pPosition) {
        this.aPosition = pPosition;
    }

    /**
     * Sets the permission level of the employee.
     *
     * @param pPermission The new employee permission level.
     */
    public void setPermission(String pPermission) {
        this.aPermission = pPermission;
    }

    /**
     * Sets the number of hours worked by the employee.
     *
     * @param pHours The new hours worked.
     */
    public void setHours(double pHours) {
        this.aHours = pHours;
    }
}
