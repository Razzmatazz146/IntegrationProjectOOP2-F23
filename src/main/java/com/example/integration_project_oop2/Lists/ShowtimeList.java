package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Showtime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a list of showtimes in the Movie Theater application.
 * This list allows adding, removing, editing, and retrieving showtime information.
 */
public class ShowtimeList implements Serializable, Iterable<Showtime> {

    private List<Showtime> aShowtimeList;

    /**
     * Constructs a new ShowtimeList.
     */
    public ShowtimeList() {
        this.aShowtimeList = new ArrayList<>();
    }

    /**
     * Adds a showtime to the list.
     *
     * @param pShowtime The showtime to add.
     */
    public void addShowtime(Showtime pShowtime) {
        this.aShowtimeList.add(pShowtime);
    }

    /**
     * Removes a showtime from the list.
     *
     * @param pShowtime The showtime to remove.
     */
    public void removeShowtime(Showtime pShowtime) {
        this.aShowtimeList.remove(pShowtime);
    }

    /**
     * Edits an existing showtime in the list.
     *
     * @param pShowtime The showtime to be edited.
     * @param aShowtime The new showtime details.
     */
    public void editShowtime(Showtime pShowtime, Showtime aShowtime) {
        if (aShowtimeList.contains(pShowtime)) {
            int index = aShowtimeList.indexOf(pShowtime);
            aShowtimeList.set(index, aShowtime);
        }
    }

    /**
     * Retrieves a showtime from the list by its index.
     *
     * @param index The index of the showtime to retrieve.
     * @return The showtime at the specified index, or null if the index is out of bounds.
     */
    public Showtime getShowtimeByIndex(int index) {
        if (index >= 0 && index < aShowtimeList.size()) {
            return aShowtimeList.get(index);
        }
        return null;
    }

    /**
     * Returns an iterator over the showtimes in the list.
     *
     * @return An iterator over the showtimes.
     */
    @Override
    public Iterator<Showtime> iterator() {
        return aShowtimeList.iterator();
    }
}
