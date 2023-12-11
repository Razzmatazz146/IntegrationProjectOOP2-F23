package com.example.integration_project_oop2.Lists;

/**
 * A singleton class that manages and provides access to various lists used in the Movie Theater application.
 * These lists include client list, manager list, movie list, showroom list, showtime list, and ticket list.
 * This class ensures that only one instance of the lists is created and shared across the application.
 */

public class SingletonLists {
    private static SingletonLists instance;

    private ClientList clientList;
    private ManagerList managerList;
    private MovieList movieList;
    private ShowroomList showroomList;
    private ShowtimeList showtimeList;
    private TicketList ticketList;

    /**
     * Private constructor to initialize the lists when the instance is first created.
     */
    private SingletonLists() {
        clientList = new ClientList();
        managerList = new ManagerList();
        movieList = new MovieList();
        showroomList = new ShowroomList();
        showtimeList = new ShowtimeList();
        ticketList = new TicketList();
    }

    /**
     * Retrieves the singleton instance of SingletonLists.
     *
     * @return The SingletonLists instance.
     */
    public static synchronized SingletonLists getInstance() {
        if (instance == null) {
            instance = new SingletonLists();
        }
        return instance;
    }

    /**
     * Retrieves the client list.
     *
     * @return The client list.
     */
    public ClientList getClientList() {
        return clientList;
    }

    /**
     * Sets the client list.
     *
     * @param clientList The client list to set.
     */
    public void setClientList(ClientList clientList) {
        this.clientList = clientList;
    }

    /**
     * Retrieves the manager list.
     *
     * @return The manager list.
     */
    public ManagerList getManagerList() {
        return managerList;
    }

    /**
     * Sets the manager list.
     *
     * @param managerList The manager list to set.
     */
    public void setManagerList(ManagerList managerList) {
        this.managerList = managerList;
    }

    /**
     * Retrieves the movie list.
     *
     * @return The movie list.
     */
    public MovieList getMovieList() {
        return movieList;
    }

    /**
     * Sets the movie list.
     *
     * @param movieList The movie list to set.
     */
    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }

    /**
     * Retrieves the showroom list.
     *
     * @return The showroom list.
     */
    public ShowroomList getShowroomList() {
        return showroomList;
    }

    /**
     * Sets the showroom list.
     *
     * @param showroomList The showroom list to set.
     */
    public void setShowroomList(ShowroomList showroomList) {
        this.showroomList = showroomList;
    }

    /**
     * Retrieves the showtime list.
     *
     * @return The showtime list.
     */
    public ShowtimeList getShowtimeList() {
        return showtimeList;
    }

    /**
     * Sets the showtime list.
     *
     * @param showtimeList The showtime list to set.
     */
    public void setShowtimeList(ShowtimeList showtimeList) {
        this.showtimeList = showtimeList;
    }

    /**
     * Retrieves the ticket list.
     *
     * @return The ticket list.
     */
    public TicketList getTicketList() {
        return ticketList;
    }

    /**
     * Sets the ticket list.
     *
     * @param ticketList The ticket list to set.
     */
    public void setTicketList(TicketList ticketList) {
        this.ticketList = ticketList;
    }

}