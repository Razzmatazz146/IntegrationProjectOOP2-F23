package com.example.integration_project_oop2.Lists;

public class SingletonLists {
    private static SingletonLists instance;

    private ClientList clientList;
    private ManagerList managerList;
    private MovieList movieList;
    private ShowroomList showroomList;
    private ShowtimeList showtimeList;
    private TicketList ticketList;

    private SingletonLists() {
        clientList = new ClientList();
        managerList = new ManagerList();
        movieList = new MovieList();
        showroomList = new ShowroomList();
        showtimeList = new ShowtimeList();
        ticketList = new TicketList();
    }
    public static synchronized SingletonLists getInstance() {
        if (instance == null) {
            instance = new SingletonLists();
        }
        return instance;
    }

    public ClientList getClientList() {
        return clientList;
    }

    public void setClientList(ClientList clientList) {
        this.clientList = clientList;
    }

    public ManagerList getManagerList() {
        return managerList;
    }

    public void setManagerList(ManagerList managerList) {
        this.managerList = managerList;
    }

    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }

    public ShowroomList getShowroomList() {
        return showroomList;
    }

    public void setShowroomList(ShowroomList showroomList) {
        this.showroomList = showroomList;
    }

    public ShowtimeList getShowtimeList() {
        return showtimeList;
    }

    public void setShowtimeList(ShowtimeList showtimeList) {
        this.showtimeList = showtimeList;
    }

    public TicketList getTicketList() {
        return ticketList;
    }

    public void setTicketList(TicketList ticketList) {
        this.ticketList = ticketList;
    }
}
