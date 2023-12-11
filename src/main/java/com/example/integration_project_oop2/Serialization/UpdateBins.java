package com.example.integration_project_oop2.Serialization;

import com.example.integration_project_oop2.Classes.*;
import com.example.integration_project_oop2.Lists.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Used to recreate bins if any errors occur or bins become unusable for any reason.
 */
public class UpdateBins {
    public static void main(String[] args) {
        SingletonLists lists = SingletonLists.getInstance();


        ClientList clientList = new ClientList();
        clientList.addClient(new Client("jdoe", "1234", "John", "Doe", "johndoe@exmaple.com", "555-5555",LocalDate.now(), 120, "123123", false));
        clientList.addClient(new Client("jsmith", "1234", "Jane", "Smith", "janesmith@exmaple.com", "555-5445", LocalDate.now(), 85, "4561651", false));
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

        ShowroomList showroomList = new ShowroomList();
        showroomList.addShowroom(new Showroom(1, 20));
        showroomList.addShowroom(new Showroom(2, 25));
        showroomList.addShowroom(new Showroom(3, 15));
        lists.setShowroomList(showroomList);

        ShowtimeList showtimeList = new ShowtimeList();
        showtimeList.addShowtime(new Showtime(LocalTime.of(11, 00, 00), LocalTime.of(14, 00, 00), lists.getMovieList().getMovieByIndex(0), lists.getShowroomList().getShowroomByIndex(0), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(14, 00, 00), LocalTime.of(17, 00, 00), lists.getMovieList().getMovieByIndex(1), lists.getShowroomList().getShowroomByIndex(0), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(17, 00, 00), LocalTime.of(20, 00, 00), lists.getMovieList().getMovieByIndex(2), lists.getShowroomList().getShowroomByIndex(0), 14, 7));
        showtimeList.addShowtime(new Showtime(LocalTime.of(20, 00, 00), LocalTime.of(23, 00, 00), lists.getMovieList().getMovieByIndex(3), lists.getShowroomList().getShowroomByIndex(0), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(11, 00, 00), LocalTime.of(14, 00, 00), lists.getMovieList().getMovieByIndex(4), lists.getShowroomList().getShowroomByIndex(1), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(14, 00, 00), LocalTime.of(17, 00, 00), lists.getMovieList().getMovieByIndex(5), lists.getShowroomList().getShowroomByIndex(1), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(17, 00, 00), LocalTime.of(20, 00, 00), lists.getMovieList().getMovieByIndex(6), lists.getShowroomList().getShowroomByIndex(1), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(20, 00, 00), LocalTime.of(23, 00, 00), lists.getMovieList().getMovieByIndex(7), lists.getShowroomList().getShowroomByIndex(1), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(11, 00, 00), LocalTime.of(14, 00, 00), lists.getMovieList().getMovieByIndex(8), lists.getShowroomList().getShowroomByIndex(2), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(14, 00, 00), LocalTime.of(17, 00, 00), lists.getMovieList().getMovieByIndex(9), lists.getShowroomList().getShowroomByIndex(2), 10, 5));
        showtimeList.addShowtime(new Showtime(LocalTime.of(17, 00, 00), LocalTime.of(20, 00, 00), lists.getMovieList().getMovieByIndex(10), lists.getShowroomList().getShowroomByIndex(2), 10, 5));
        lists.setShowtimeList(showtimeList);

        TicketList ticketList = new TicketList();
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), false, 2, LocalDate.of(2023, 11, 20)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), false, 2, LocalDate.of(2023, 11, 20)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), true, 13, LocalDate.of(2023, 11, 24)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), true, 28, LocalDate.of(2023, 11, 29)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), false, 37, LocalDate.of(2023, 12, 2)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), true, 8, LocalDate.of(2023, 11, 22)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(5), true, 7, LocalDate.of(2023, 11, 15)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(8), false, 4, LocalDate.of(2023, 11, 10)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), true, 0, LocalDate.of(2023, 11, 5)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), false, 3, LocalDate.of(2023, 11, 8)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(7), true, 9, LocalDate.of(2023, 11, 3)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(10), false, 6, LocalDate.of(2023, 11, 12)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(4), true, 1, LocalDate.of(2023, 11, 19)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), false, 8, LocalDate.of(2023, 11, 9)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(9), true, 5, LocalDate.of(2023, 11, 17)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(3), false, 2, LocalDate.of(2023, 11, 6)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(6), true, 10, LocalDate.of(2023, 11, 1)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(5), false, 4, LocalDate.of(2023, 11, 7)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(8), true, 1, LocalDate.of(2023, 11, 2)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), false, 6, LocalDate.of(2023, 11, 14)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), true, 3, LocalDate.of(2023, 11, 13)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(7), false, 8, LocalDate.of(2023, 11, 11)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(10), true, 0, LocalDate.of(2023, 11, 18)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(4), false, 5, LocalDate.of(2023, 11, 4)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), true, 7, LocalDate.of(2023, 11, 16)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(9), false, 2, LocalDate.of(2023, 11, 6)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(3), true, 9, LocalDate.of(2023, 11, 9)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(6), false, 1, LocalDate.of(2023, 11, 20)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(5), true, 8, LocalDate.of(2023, 11, 10)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(8), false, 3, LocalDate.of(2023, 11, 1)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), true, 4, LocalDate.of(2023, 11, 19)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), false, 0, LocalDate.of(2023, 11, 17)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(7), true, 10, LocalDate.of(2023, 11, 12)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(10), false, 6, LocalDate.of(2023, 11, 14)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(4), true, 5, LocalDate.of(2023, 11, 2)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(0), false, 1, LocalDate.of(2023, 11, 3)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(9), true, 4, LocalDate.of(2023, 11, 8)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(3), false, 7, LocalDate.of(2023, 11, 5)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(6), true, 2, LocalDate.of(2023, 11, 15)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(5), false, 10, LocalDate.of(2023, 11, 7)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(8), true, 9, LocalDate.of(2023, 11, 4)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(2), false, 8, LocalDate.of(2023, 11, 18)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(1), true, 3, LocalDate.of(2023, 11, 16)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(7), false, 5, LocalDate.of(2023, 11, 11)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(10), true, 6, LocalDate.of(2023, 11, 13)));
        ticketList.addTicket(new Ticket(lists.getShowtimeList().getShowtimeByIndex(4), false, 4, LocalDate.of(2023, 11, 6)));

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
