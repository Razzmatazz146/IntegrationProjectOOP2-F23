package com.example.integration_project_oop2.Classes;

/**
 * Represents the theater's showrooms' Room Number and Capacity.
 *
 * Has methods to get and set Room Number and Room Capacity, as well as a @Showrooms constructor.
 */
public class Showrooms {
    private int aRoomNumber;
    private int aRoomCapacity;

    /**
     * Showroom constructor.
     * @param pRoomNumber Room number.
     * @param pRoomCapacity Room capacity.
     */
    public Showrooms(int pRoomNumber, int pRoomCapacity){
        this.setRoomCapacity(pRoomCapacity);
        this.setRoomNumber(pRoomNumber);
    }

    public int getRoomNumber() { return aRoomNumber; }
    public int getRoomCapacity() { return aRoomCapacity; }

    public void setRoomNumber(int pRoomNumber) { this.aRoomNumber = pRoomNumber; }
    public void setRoomCapacity(int pRoomCapacity) { this.aRoomCapacity = pRoomCapacity; }

}
