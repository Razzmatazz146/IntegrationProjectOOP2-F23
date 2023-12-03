package com.example.integration_project_oop2.Serialization;

import com.example.integration_project_oop2.Classes.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateBins {
    public static void main(String[] args) {
        SingletonLists lists = SingletonLists.getInstance();


        ClientList clientList = new ClientList();
        clientList.addClient(new Client("jdoe", "johndoe@example.com", "John", "Doe", "johndoe@exmaple.com", "555-5555",LocalDate.now(), 120, "123123", false));
        clientList.addClient(new Client("jsmith", "janesmith@example.com", "Jane", "Smith", "janesmith@exmaple.com", "555-5445", LocalDate.now(), 85, "4561651", false));
        lists.setClientList(clientList);


        ManagerList managerList = new ManagerList();
        managerList.addManager(new Manager("manager1", "password1", "Olivia", "Wilson", "olivia.wilson@exmaple.com", "555-5514", true));
        lists.setManagerList(managerList);

        MovieList movieList = new MovieList();
        movieList.addMovie(new Movie("Arrival", "Sci-Fi/Drama", 116, 2016, "PG-13"));
        movieList.addMovie(new Movie("The Dark Knight", "Action/Crime", 152, 2008, "PG-13"));
        movieList.addMovie(new Movie("Interstellar", "Sci-Fi/Adventure", 169, 2014, "PG-13"));
        movieList.addMovie(new Movie("Titanic", "Romance/Drama", 195, 1997, "PG-13"));
        movieList.addMovie(new Movie("Jurassic Park", "Sci-Fi/Adventure", 127, 1993, "PG-13"));
        movieList.addMovie(new Movie("The Avengers", "Action/Fantasy", 143, 2012, "PG-13"));
        movieList.addMovie(new Movie("Toy Story", "Animation/Adventure/Comedy", 81, 1995, "G"));
        movieList.addMovie(new Movie("Star Wars: Episode III - Revenge of the Sith", "Action/Adventure/Fantasy", 140, 2005, "PG-13"));
        movieList.addMovie(new Movie("Harry Potter and the Philosopher's Stone", "Fantasy/Adventure", 159, 2001, "PG"));
        movieList.addMovie(new Movie("The Lord of the Rings: The Return of the King", "Fantasy/Drama", 201, 2003, "PG-13"));
        movieList.addMovie(new Movie("Shrek 2", "Comedy", 92, 2004, "PG"));
        lists.setMovieList(movieList);

        ShowtimeList showtimeList = new ShowtimeList();
        showtimeList.addShowtime(new Showtime(LocalTime.of(11, 00, 00), LocalTime.of(14, 00, 00), lists.getMovieList().getMovieByIndex(0), lists.getShowroomList().getShowroomByIndex(0), 10, 5, 14));
        showtimeList.addShowtime(new Showtime(LocalTime.of(14, 00, 00), LocalTime.of(17, 00, 00), lists.getMovieList().getMovieByIndex(7), lists.getShowroomList().getShowroomByIndex(0), 10, 5, 13));
        showtimeList.addShowtime(new Showtime(LocalTime.of(11, 00, 00), LocalTime.of(14, 00, 00), lists.getMovieList().getMovieByIndex(3), lists.getShowroomList().getShowroomByIndex(1), 14, 7, 11));
        showtimeList.addShowtime(new Showtime(LocalTime.of(17, 00, 00), LocalTime.of(20, 00, 00), lists.getMovieList().getMovieByIndex(4), lists.getShowroomList().getShowroomByIndex(3), 10, 5, 5));
        lists.setShowtimeList(showtimeList);

        ShowroomList showroomList = new ShowroomList();
        showroomList.addShowroom(new Showroom(1, 20));
        showroomList.addShowroom(new Showroom(2, 25));
        showroomList.addShowroom(new Showroom(3, 15));
        lists.setShowroomList(showroomList);

        TicketList ticketList = new TicketList();
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), false, 2, LocalDate.of(2023, 11, 20)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), false, 2, LocalDate.of(2023, 11, 20)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), true, 13, LocalDate.of(2023, 11, 24)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), true, 28, LocalDate.of(2023, 11, 29)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), false, 37, LocalDate.of(2023, 12, 02)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), true, 8, LocalDate.of(2023, 11, 22)));
        lists.setTicketList(ticketList);



        // Saves the lists to the bins
        BinWriter.serialize(lists.getClientList(), "client.bin");
        BinWriter.serialize(lists.getManagerList(), "manager.bin");
        BinWriter.serialize(lists.getMovieList(), "movie.bin");
        BinWriter.serialize(lists.getShowroomList(), "showroom.bin");
        BinWriter.serialize(lists.getShowtimeList(), "showtime.bin");
        BinWriter.serialize(lists.getTicketList(), "tickets.bin");

        System.out.println("Data has been saved.");
    }
}
