package com.example.integration_project_oop2.Classes;

import java.time.LocalDate;

/**
 * Represents theater showtimes' assigned movie, start time, end time, price per adult and price per child.
 *
 * Has methods to get and set the showtime Start Time, End Time, Adult Price and Child price as well as
 * a @Showtimes constructor. The instance of Movies has attributes for the assigned movie's title, genre
 * and duration.
 */
public class Showtimes {
    /**
     * Instance of the Movies class.
     */
    private Movies aMovie;
    private LocalDate aStartTime;
    private LocalDate aEndTime;
    private double aShowtimeAdultPrice;
    private double aShowtimeChildPrice;

    /**
     * Showtime constructor
     * @param pStartTime Showtime start time.
     * @param pEndTime Showtime end time.
     * @param pMovie Assigned movie.
     * @param pShowTimeAdultPrice Showtime price per adult.
     * @param pShowtimeChildPrice Showtime price per child.
     */
    public Showtimes(LocalDate pStartTime, LocalDate pEndTime, Movies pMovie, double pShowTimeAdultPrice, double pShowtimeChildPrice){
        this.aMovie = pMovie;
        this.aStartTime = pStartTime;
        this.aEndTime = pEndTime;
        this.aShowtimeAdultPrice = pShowTimeAdultPrice;
        this. aShowtimeChildPrice = pShowtimeChildPrice;
    }

    public LocalDate getStartTime(){ return aStartTime; }
    public LocalDate getEndTime(){ return aEndTime; }
    public Movies getMovie() { return aMovie; }
    public double getShowtimePrice(){ return aShowtimeAdultPrice; }
    public double getShowtimeChildPrice() { return aShowtimeChildPrice; }

    public void setStartTime(LocalDate pStartTime){ this.aStartTime = pStartTime; }
    public void setEndTime(LocalDate pEndTime){ this.aEndTime = pEndTime; }
    public void setMovie(Movies pMovie) { this.aMovie = pMovie; }
    public void setShowtimePrice(int pShowtimeAdultPrice){ this.aShowtimeAdultPrice = pShowtimeAdultPrice; }
    public void setShowtimeChildPrice(int pShowtimeChildPrice){ this.aShowtimeChildPrice = pShowtimeChildPrice; }
}
