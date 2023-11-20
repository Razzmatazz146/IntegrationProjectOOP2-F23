package com.example.integration_project_oop2.Classes;

import com.example.integration_project_oop2.Interfaces.ShowtimeManager;

import java.time.LocalDate;
import java.util.List;

public class Showtimes implements ShowtimeManager {
    private Movies movie;
    private LocalDate startTime;
    private LocalDate endTime;
    @Override
    public void scheduleShowtime(Showtimes showtime) {

    }

    @Override
    public void cancelShowtime(Showtimes showtime) {

    }

    @Override
    public List<Showtimes> getAllShowtimes() {
        return null;
    }

    /**
     * Constructor for selected movie showtime
     * @param startTime Movie's start time
     * @param endTime Movie's end time
     * @param movie Selected Movie
     */
    public Showtimes(LocalDate startTime, LocalDate endTime, Movies movie){
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    /**
     * Get selected movie's start time
     * @return start time
     */
    public LocalDate getStartTime(){ return startTime; }

    /**
     * Set selected movie's start time
     * @param startTime
     */
    public void setStartTime(LocalDate startTime){
        this.startTime = startTime;
    }

    /**
     * Get selected movie's end time
     * @return end time
     */
    public LocalDate getEndTime(){ return endTime; }

    /**
     * Sets selected movie's end time.
     * @param endTime
     */
    public void setEndTime(LocalDate endTime){
        this.endTime = endTime;
    }
}
