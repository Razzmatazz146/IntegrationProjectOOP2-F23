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
    private Showtimes aShowtime;
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
    public Ticket(Showtimes pShowtime, boolean pAdult, int pTicketNumber, LocalDate pPurchaseDate) {
        this.aShowtime = pShowtime;
        this.aAdult = pAdult;
        this.aTicketNumber = pTicketNumber;
        this.aPurchaseDate = pPurchaseDate;
    }

    public Showtimes getShowtime(){ return aShowtime; }
    public boolean getAdult(){ return aAdult; }
    public int getTicketNumber(){ return aTicketNumber; }
    public LocalDate getPurchaseDate(){ return aPurchaseDate; }

    public void setShowtime(Showtimes pShowtime){ this.aShowtime = pShowtime; }
    public void setAdult(boolean pAdult){ this.aAdult = pAdult; }
    public void setTicketNumber(int pTicketNumber){ this.aTicketNumber = pTicketNumber; }
    public void setPurchaseDate(LocalDate pPurchaseDate){ this.aPurchaseDate = pPurchaseDate; }
}
