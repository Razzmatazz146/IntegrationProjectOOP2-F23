package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeList implements Serializable {
    
    private List<Showtime> aShowtimeList;

    public ShowtimeList() { this.aShowtimeList = new ArrayList<>(); }

    public void addShowtime(Showtime showtime) { this.aShowtimeList.add(showtime); }

    public void removeShowtime(Showtime showtime) { this.aShowtimeList.remove(showtime); }

    public void editShowtime(Showtime oldShowtime, Showtime newShowtime) {
        if (aShowtimeList.contains(oldShowtime)) {
            int index = aShowtimeList.indexOf(oldShowtime);
            aShowtimeList.set(index, newShowtime);
        }
    }

    public Showtime getShowtimeByIndex(int index) {
        if (index >= 0 && index < aShowtimeList.size()) {
            return aShowtimeList.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    public List<Showtime> getAllShowtimes() { return new ArrayList<>(aShowtimeList); }
}
