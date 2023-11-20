package com.example.integration_project_oop2.Interfaces;

import com.example.integration_project_oop2.Classes.Showtimes;

import java.util.List;

public interface ShowtimeManager {
    void scheduleShowtime(Showtimes showtime);
    void cancelShowtime(Showtimes showtime);
    List<Showtimes> getAllShowtimes();
}
