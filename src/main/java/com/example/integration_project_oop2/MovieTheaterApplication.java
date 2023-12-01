package com.example.integration_project_oop2;

import com.example.integration_project_oop2.Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class MovieTheaterApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader movieTheaterApplicationLoader = new FXMLLoader(getClass().getResource("user-login.fxml"));
        Scene scene = new Scene(movieTheaterApplicationLoader.load());
        stage.setTitle("Movie Theater Login");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();

        ClientList clientList = new ClientList();
        clientList.addClient(new Client("jdoe", "johndoe@example.com", "John", "Doe", "johndoe@exmaple.com", "555-5555", LocalDate.now(), 120, 123123, true));
        clientList.addClient(new Client("jsmith", "janesmith@example.com", "Jane", "Smith", "janesmith@exmaple.com", "555-5445", LocalDate.now(), 85, 4561651, false));

        MovieList movieList = new MovieList();
        movieList.addMovie(new Movies("Interstellar", "Sci-Fi", 169));
        movieList.addMovie(new Movies("Shrek 2", "Slice of Life", 120));

        ShowroomList showroomList = new ShowroomList();
        showroomList.addShowroom(new Showroom(1, 20));
        showroomList.addShowroom(new Showroom(2, 35));

        ShowtimesList showtimesList = new ShowtimesList();
        showtimesList.addShowtime(new Showtime(LocalTime.now(), LocalTime.now().plusHours(2), movieList.getAllMovies().get(0), showroomList.getShowroomsList().get(0),10, 6));
        showtimesList.addShowtime(new Showtime(LocalTime.now(), LocalTime.now().plusHours(2), movieList.getAllMovies().get(1), showroomList.getShowroomsList().get(1), 10, 6));


    }
}