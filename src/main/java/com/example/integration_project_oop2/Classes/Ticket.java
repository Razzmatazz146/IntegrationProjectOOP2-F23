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
    private boolean aAdult;
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
        this.setAdult(pAdult);
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
    public boolean getAdult(){ return aAdult; }

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
    public void setShowtime(Showtime pShowtime){ this.aShowtime = pShowtime; }

    /**
     * Sets whether the ticket is for an adult.
     *
     * @param pAdult True if the ticket is for an adult, false otherwise.
     */
    public void setAdult(boolean pAdult){ this.aAdult = pAdult; }

    /**
     * Sets the ticket number.
     *
     * @param pTicketNumber The new ticket number.
     */
    public void setTicketNumber(int pTicketNumber){ this.aTicketNumber = pTicketNumber; }

    /**
     * Sets the purchase date of the ticket.
     *
     * @param pPurchaseDate The new purchase date.
     */
    public void setPurchaseDate(LocalDate pPurchaseDate){ this.aPurchaseDate = pPurchaseDate; }
}
