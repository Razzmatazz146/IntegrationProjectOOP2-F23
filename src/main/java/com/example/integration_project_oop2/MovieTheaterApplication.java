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
        // Creates an instance of singleton
        SingletonLists lists = SingletonLists.getInstance();

        // Deserializes the bins to then set them in the singleton. They can then be used throughout the application.
        lists.setClientList(BinReader.deserialize("client.bin", ClientList.class));
        lists.setManagerList(BinReader.deserialize("manager.bin", ManagerList.class));
        lists.setMovieList(BinReader.deserialize("movie.bin", MovieList.class));
        lists.setShowroomList(BinReader.deserialize("showroom.bin", ShowroomList.class));
        lists.setShowtimeList(BinReader.deserialize("showtime.bin", ShowtimeList.class));
        lists.setTicketList(BinReader.deserialize("tickets.bin", TicketList.class));

        FXMLLoader movieTheaterApplicationLoader = new FXMLLoader(getClass().getResource("user-login.fxml"));
        Scene scene = new Scene(movieTheaterApplicationLoader.load());
        stage.setTitle("Movie Theater Login");
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() {
        SingletonLists lists = SingletonLists.getInstance();

        // Saves the lists to the bins
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