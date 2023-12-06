package com.example.integration_project_oop2.Lists;

import com.example.integration_project_oop2.Classes.Showtime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowtimeList implements Serializable, Iterable<Showtime> {

    private List<Showtime> aShowtimeList;

    public ShowtimeList() {
        this.aShowtimeList = new ArrayList<>();
    }

    public void addShowtime(Showtime pShowtime) {
        this.aShowtimeList.add(pShowtime);
    }

    public void removeShowtime(Showtime pShowtime) {
        this.aShowtimeList.remove(pShowtime);
    }

    public void editShowtime(Showtime pShowtime, Showtime aShowtime) {
        if (aShowtimeList.contains(pShowtime)) {
            int index = aShowtimeList.indexOf(pShowtime);
            aShowtimeList.set(index, aShowtime);
        }
    }

    public Showtime getShowtimeByIndex(int index) {
        if (index >= 0 && index < aShowtimeList.size()) {
            return aShowtimeList.get(index);
        }
        return null;
    }

    @Override
    public Iterator<Showtime> iterator() {
        return aShowtimeList.iterator();
    }
}
