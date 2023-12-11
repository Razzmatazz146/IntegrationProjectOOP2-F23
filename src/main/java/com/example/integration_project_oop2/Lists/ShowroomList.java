package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Showroom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a list of showrooms in the Movie Theater application.
 * This list allows adding, removing, editing, and retrieving showroom information.
 */
public class ShowroomList implements Serializable, Iterable<Showroom> {
    private List<Showroom> aShowroomList;

    /**
     * Constructs a new ShowroomList.
     */
    public ShowroomList() {
        this.aShowroomList = new ArrayList<>();
    }

    /**
     * Adds a showroom to the list.
     *
     * @param pShowroom The showroom to add.
     */
    public void addShowroom(Showroom pShowroom) {
        this.aShowroomList.add(pShowroom);
    }

    /**
     * Removes a showroom from the list.
     *
     * @param pShowroom The showroom to remove.
     */
    public void removeShowroom(Showroom pShowroom) {
        this.aShowroomList.remove(pShowroom);
    }

    /**
     * Edits an existing showroom in the list.
     *
     * @param pShowroom The showroom to be edited.
     * @param aShowroom The new showroom details.
     */
    public void editShowroom(Showroom pShowroom, Showroom aShowroom) {
        if (aShowroomList.contains(pShowroom)) {
            int index = aShowroomList.indexOf(pShowroom);
            aShowroomList.set(index, aShowroom);
        }
    }

    /**
     * Retrieves a showroom from the list by its index.
     *
     * @param index The index of the showroom to retrieve.
     * @return The showroom at the specified index, or null if the index is out of bounds.
     */
    public Showroom getShowroomByIndex(int index) {
        if (index >= 0 && index < aShowroomList.size()) {
            return aShowroomList.get(index);
        }
        return null;
    }

    /**
     * Retrieves a list of showroom numbers.
     *
     * @return A list of showroom numbers.
     */
    public List<Integer> getShowroomNumberList() {
        List<Integer> showroomList = new ArrayList<>();
        for (Showroom showroom : aShowroomList) {
            showroomList.add(showroom.getRoomNumber());
        }
        return showroomList;
    }

    /**
     * Returns an iterator over the showrooms in the list.
     *
     * @return An iterator over the showrooms.
     */
    @Override
    public Iterator<Showroom> iterator() {
        return aShowroomList.iterator();
    }
}
