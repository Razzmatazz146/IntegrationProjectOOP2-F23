package com.example.integration_project_oop2;

import com.example.integration_project_oop2.Classes.*;
import com.example.integration_project_oop2.Serialization.BinReader;
import com.example.integration_project_oop2.Serialization.BinWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieTheaterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SingletonLists lists = SingletonLists.getInstance();

        lists.setClientList(BinReader.deserialize("client.bin", ClientList.class));
        lists.setManagerList(BinReader.deserialize("manager.bin", ManagerList.class));
        lists.setMovieList(BinReader.deserialize("movie.bin", MovieList.class));
        lists.setShowroomList(BinReader.deserialize("showroom.bin", ShowroomList.class));
        lists.setShowtimeList(BinReader.deserialize("showtime.bin", ShowtimeList.class));
        lists.setTicketList(BinReader.deserialize("tickets.bin", TicketList.class));
        System.out.println(lists.getManagerList());
        FXMLLoader movieTheaterApplicationLoader = new FXMLLoader(getClass().getResource("user-login.fxml"));
        Scene scene = new Scene(movieTheaterApplicationLoader.load());
        stage.setTitle("Movie Theater Login");
        stage.setScene(scene);
        System.out.println("Managers:");
        for (Manager manager : lists.getManagerList().getAllManagers()) {
            System.out.println("Username: " + manager.getUsername());
            System.out.println("First Name: " + manager.getFirstName());
            System.out.println("Last Name: " + manager.getLastName());
            // Add more fields as needed
            System.out.println(); // Separate each manager's information
        }

        // Print the client information
        System.out.println("Clients:");
        for (Client client : lists.getClientList().getAllClients()) {
            System.out.println("Username: " + client.getUsername());
            System.out.println("First Name: " + client.getFirstName());
            System.out.println("Last Name: " + client.getLastName());
            // Add more fields as needed
            System.out.println(); // Separate each client's information
        }

        stage.show();
    }

    @Override
    public void stop() {
        SingletonLists lists = SingletonLists.getInstance();

        BinWriter.serialize(lists.getClientList(), "client.bin");
        BinWriter.serialize(lists.getManagerList(), "manager.bin");
        BinWriter.serialize(lists.getMovieList(), "movie.bin");
        BinWriter.serialize(lists.getShowroomList(), "showroom.bin");
        BinWriter.serialize(lists.getShowtimeList(), "showtime.bin");
        BinWriter.serialize(lists.getTicketList(), "tickets.bin");

        System.out.println("Application is closing. Data has been saved.");
    }

    public static void main(String[] args) {
        launch();
    }
}