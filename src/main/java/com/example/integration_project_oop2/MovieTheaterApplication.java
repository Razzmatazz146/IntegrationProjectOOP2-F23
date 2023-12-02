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
    private ClientList clientList;
    private ManagerList managerList;
    private MovieList movieList;
    private ShowroomList showroomList;
    private ShowtimesList showtimesList;
    private TicketSales ticketSales;

    @Override
    public void start(Stage stage) throws IOException {

        clientList = BinReader.deserialize("client.bin", ClientList.class);
        managerList = BinReader.deserialize("manager.bin", ManagerList.class);
        movieList = BinReader.deserialize("movie.bin", MovieList.class);
        showroomList = BinReader.deserialize("showroom.bin", ShowroomList.class);
        showtimesList = BinReader.deserialize("showtime.bin", ShowtimesList.class);
        ticketSales = BinReader.deserialize("tickets.bin", TicketSales.class);

        FXMLLoader movieTheaterApplicationLoader = new FXMLLoader(getClass().getResource("user-login.fxml"));
        Scene scene = new Scene(movieTheaterApplicationLoader.load());
        stage.setTitle("Movie Theater Login");
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() {
        BinWriter.serialize(clientList, "client.bin");
        BinWriter.serialize(managerList, "manager.bin");
        BinWriter.serialize(movieList, "movie.bin");
        BinWriter.serialize(showroomList, "showroom.bin");
        BinWriter.serialize(showtimesList, "showtime.bin");
        BinWriter.serialize(ticketSales, "tickets.bin");

        System.out.println("Application is closing. Data has been saved.");
    }

    public static void main(String[] args) {
        launch();
    }
}