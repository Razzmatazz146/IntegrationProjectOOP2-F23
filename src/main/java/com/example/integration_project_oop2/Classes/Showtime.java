package com.example.integration_project_oop2.Classes;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Represents theater showtimes' assigned movie, start time, end time, price per adult and price per child.
 *
 * Has methods to get and set the showtime Start Time, End Time, Adult Price and Child price as well as
 * a @Showtimes constructor. The instance of Movies has attributes for the assigned movie's title, genre
 * and duration.
 */
public class Showtime implements Serializable {
    /**
     * Instance of the Movies class.
     */
    private Movie aMovie;
    private LocalTime aStartTime;
    private LocalTime aEndTime;

    private double aShowtimeAdultPrice;
    private double aShowtimeChildPrice;
    private Showroom aShowroom;
    private int aDaySales;

    /**
     * Showtime constructor
     * @param pStartTime Showtime start time.
     * @param pEndTime Showtime end time.
     * @param pMovie Assigned movie.
     * @param pShowtimeAdultPrice Showtime price per adult.
     * @param pShowtimeChildPrice Showtime price per child.
     */
    public Showtime(LocalTime pStartTime, LocalTime pEndTime, Movie pMovie, Showroom pShowroom, double pShowtimeAdultPrice, double pShowtimeChildPrice, int pDaySales){
        this.setMovie(pMovie);
        this.setShowroom(pShowroom);
        this.setStartTime(pStartTime);
        this.setEndTime(pEndTime);
        this.setShowtimeAdultPrice(pShowtimeAdultPrice);
        this.setShowtimeChildPrice(pShowtimeChildPrice);
        this.setDaySales(pDaySales);
    }

    private void setShowroom(Showroom pShowroom) {
        if (pShowroom == null)
            throw new IllegalArgumentException("Showroom cannot be null");
        this.aShowroom = pShowroom;
    }
    public Showroom getShowroom(){
        return aShowroom;
    }

    /**
     * Gets the start time of the showtime.
     *
     * @return The start time.
     */
    public LocalTime getStartTime(){ return aStartTime; }

    /**
     * Gets the end time of the showtime.
     *
     * @return The end time.
     */
    public LocalTime getEndTime(){ return aEndTime; }

    /**
     * Gets the associated movie for the showtime.
     *
     * @return The associated movie.
     */
    public Movie getMovie() { return aMovie; }

    /**
     * Gets the adult ticket price for the showtime.
     *
     * @return The adult ticket price.
     */
    public double getShowtimePrice(){ return aShowtimeAdultPrice; }

    /**
     * Gets the child ticket price for the showtime.
     *
     * @return The child ticket price.
     */
    public double getShowtimeChildPrice() { return aShowtimeChildPrice; }

    /**
     * Sets the start time of the showtime.
     *
     * @param pStartTime The new start time.
     */
    public void setStartTime(LocalTime pStartTime){
        if (pStartTime == null)
            throw new IllegalArgumentException("Start time cannot be null");
        this.aStartTime = pStartTime; }

    /**
     * Sets the end time of the showtime.
     *
     * @param pEndTime The new end time.
     */
    public void setEndTime(LocalTime pEndTime){
        if (pEndTime == null)
            throw new IllegalArgumentException("End time cannot be null");
        this.aEndTime = pEndTime;
    }

    /**
     * Sets the associated movie for the showtime.
     *
     * @param pMovie The new associated movie.
     */
    public void setMovie(Movie pMovie) {
        if (pMovie == null)
            throw new IllegalArgumentException("Movie cannot be null");
        this.aMovie = pMovie;
    }

    /**
     * Sets the adult ticket price for the showtime.
     *
     * @param pShowtimeAdultPrice The new adult ticket price.
     */
    public void setShowtimeAdultPrice(double pShowtimeAdultPrice) {
        if (pShowtimeAdultPrice < 0)
            throw new IllegalArgumentException("Price cannot be 0");
        this.aShowtimeAdultPrice = pShowtimeAdultPrice; }

    /**
     * Sets the child ticket price for the showtime.
     *
     * @param pShowtimeChildPrice The new child ticket price.
     */
    public void setShowtimeChildPrice(double pShowtimeChildPrice) {
        this.aShowtimeChildPrice = pShowtimeChildPrice;
    }

    public int getDaySales() {
        return aDaySales;
    }

    public void setDaySales(int pDaySales) {
        this.aDaySales = pDaySales;
    }
}
