package com.example.integration_project_oop2.Classes;

import java.util.ArrayList;
import java.util.List;

public class ShowtimesList {
    
    private List<Showtime> aShowtimeList;

    public ShowtimesList() { this.aShowtimeList = new ArrayList<>(); }

    public void addShowtime(Showtime showtime) { this.aShowtimeList.add(showtime); }

    public void removeShowtime(Showtime showtime) { this.aShowtimeList.remove(showtime); }

    public void editShowtime(Showtime oldShowtime, Showtime newShowtime) {
        if (aShowtimeList.contains(oldShowtime)) {
            int index = aShowtimeList.indexOf(oldShowtime);
            aShowtimeList.set(index, newShowtime);
        }
    }

    public List<Showtime> getAllShowtimes() { return new ArrayList<>(aShowtimeList); }
}
