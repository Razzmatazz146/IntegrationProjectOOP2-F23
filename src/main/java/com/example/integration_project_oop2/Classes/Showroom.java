package com.example.integration_project_oop2.Classes;

import java.io.Serializable;

/**
 * Represents the theater's showrooms' Room Number and Capacity.
 *
 * Has methods to get and set Room Number and Room Capacity, as well as a @Showrooms constructor.
 */
public class Showroom implements Serializable {
    private int aRoomNumber;
    private int aRoomCapacity;

    /**
     * Showroom constructor.
     * @param pRoomNumber Room number.
     * @param pRoomCapacity Room capacity.
     */
    public Showroom(int pRoomNumber, int pRoomCapacity){
        this.setRoomCapacity(pRoomCapacity);
        this.setRoomNumber(pRoomNumber);
    }

    /**
     * Gets the room number.
     *
     * @return The room number.
     */
    public int getRoomNumber() { return aRoomNumber; }

    /**
     * Gets the capacity of the room.
     *
     * @return The room capacity.
     */
    public int getRoomCapacity() { return aRoomCapacity; }

    /**
     * Sets the room number.
     *
     * @param pRoomNumber The new room number.
     */
    public void setRoomNumber(int pRoomNumber) { this.aRoomNumber = pRoomNumber; }

    /**
     * Sets the capacity of the room.
     *
     * @param pRoomCapacity The new room capacity.
     */
    public void setRoomCapacity(int pRoomCapacity) { this.aRoomCapacity = pRoomCapacity; }

}
