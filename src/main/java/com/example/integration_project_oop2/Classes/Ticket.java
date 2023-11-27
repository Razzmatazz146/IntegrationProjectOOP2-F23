package com.example.integration_project_oop2.Classes;

import java.time.LocalDate;

/**
 * Represents one theater ticket's assigned showtime, ticket number, purchase date, if the
 * ticket owner is an adult, and the ticket purchase date.
 *
 * Has methods to get and set the ticket's Showtime, Ticket Number and Purchase Date, as well as
 * a @Ticket constructor. The instance of showtime has attributes for the movie's information,
 * room number and start/end time for the assigned movie.
 */
public class Ticket {
    /**
     * Instance of the Showtimes class.
     */
    private Showtime aShowtime;
    private boolean aIsAdult;
    private int aTicketNumber;
    private LocalDate aPurchaseDate;

    /**
     * Ticket constructor.
     * @param pShowtime Assigned showtime.
     * @param pAdult Boolean for if owner is an adult.
     * @param pTicketNumber Ticket's ID number.
     * @param pPurchaseDate Ticket's purchase date.
     */
    public Ticket(Showtime pShowtime, boolean pAdult, int pTicketNumber, LocalDate pPurchaseDate) {
        this.setIsAdult(pAdult);
        this.setShowtime(pShowtime);
        this.setTicketNumber(pTicketNumber);
        this.setPurchaseDate(pPurchaseDate);
    }

    /**
     * Gets the showtime associated with the ticket.
     *
     * @return The associated showtime.
     */
    public Showtime getShowtime(){ return aShowtime; }

    /**
     * Checks if the ticket is for an adult.
     *
     * @return True if the ticket is for an adult, false otherwise.
     */
    public boolean getIsAdult(){ return aIsAdult; }

    /**
     * Gets the ticket number.
     *
     * @return The ticket number.
     */
    public int getTicketNumber(){ return aTicketNumber; }

    /**
     * Gets the purchase date of the ticket.
     *
     * @return The purchase date.
     */
    public LocalDate getPurchaseDate(){ return aPurchaseDate; }

    /**
     * Sets the showtime associated with the ticket.
     *
     * @param pShowtime The new associated showtime.
     */
    public void setShowtime(Showtime pShowtime){
        if (pShowtime == null)
            throw new IllegalArgumentException("Showtime cannot be null");
        this.aShowtime = pShowtime; }

    /**
     * Sets whether the ticket is for an adult.
     *
     * @param pIsAdult True if the ticket is for an adult, false otherwise.
     */
    public void setIsAdult(boolean pIsAdult){
        this.aIsAdult = pIsAdult; }

    /**
     * Sets the ticket number.
     *
     * @param pTicketNumber The new ticket number.
     */
    public void setTicketNumber(int pTicketNumber){
        if (pTicketNumber < 0)
            throw new IllegalArgumentException("Ticket number cannot be less than 0");
        this.aTicketNumber = pTicketNumber; }

    /**
     * Sets the purchase date of the ticket.
     *
     * @param pPurchaseDate The new purchase date.
     */
    public void setPurchaseDate(LocalDate pPurchaseDate){
        if (pPurchaseDate == null)
            throw new IllegalArgumentException("Purchase date cannot be null");
        if (pPurchaseDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Purchase dat cannot be in the future");
        this.aPurchaseDate = pPurchaseDate; }
}
