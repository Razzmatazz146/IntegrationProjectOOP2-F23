package com.example.integration_project_oop2.Classes;

import java.util.ArrayList;
import java.util.List;

public class ShowtimesList {
    
    private List<Showtimes> aShowtimesList;

    public ShowtimesList() { this.aShowtimesList = new ArrayList<>(); }

    public void addShowtime(Showtimes showtime) { this.aShowtimesList.add(showtime); }

    public void removeShowtime(Showtimes showtime) { this.aShowtimesList.remove(showtime); }

    public void editShowtime(Showtimes oldShowtime, Showtimes newShowtime) {
        if (aShowtimesList.contains(oldShowtime)) {
            int index = aShowtimesList.indexOf(oldShowtime);
            aShowtimesList.set(index, newShowtime);
        }
    }

    public List<Showtimes> getAllShowtimes() { return new ArrayList<>(aShowtimesList); }
}
