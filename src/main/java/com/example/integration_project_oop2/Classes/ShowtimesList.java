package com.example.integration_project_oop2.Classes;

import com.example.integration_project_oop2.Interfaces.ShowtimeManager;

import java.util.ArrayList;
import java.util.List;

public class ShowtimesList implements ShowtimeManager {

    private List<Showtimes> showtimes;
    @Override
    public void scheduleShowtime(Showtimes showtime) {

    }

    @Override
    public void cancelShowtime(Showtimes showtime) {

    }

    @Override
    public List<Showtimes> getAllShowtimes() {
        return showtimes;
    }

    /**
     * Constructor
     */
    public void ShowtimesList(){
        this.showtimes = new ArrayList<>();
    }
}
