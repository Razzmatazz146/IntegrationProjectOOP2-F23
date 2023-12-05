package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.*;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ViewTicketByMovieController {
    public TableView<Ticket> ticketTableView;
    public Button backButton;

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        SingletonLists lists = SingletonLists.getInstance();


        TableColumn<Ticket, String> ticketNumberColumn = new TableColumn<>("Ticket Number");
        ticketNumberColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getTicketNumber())));
        TableColumn<Ticket, String> ticketMovieColumn = new TableColumn<>("Movie");
        ticketMovieColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getShowtime().getMovie().getMovieTitle()));
        TableColumn<Ticket, String> ticketShowroomColumn = new TableColumn<>("Showroom Number");
        ticketShowroomColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getShowtime().getShowroom().getRoomNumber())));
        TableColumn<Ticket, String> ticketShowtimeColumn = new TableColumn<>("Start Time");
        ticketShowtimeColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getShowtime().getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")))));

        ticketTableView.getColumns().add(ticketNumberColumn);
        ticketTableView.getColumns().add(ticketMovieColumn);
        ticketTableView.getColumns().add(ticketShowroomColumn);
        ticketTableView.getColumns().add(ticketShowtimeColumn);

        List<Ticket> displayTickets = new ArrayList<>();


        for (Ticket ticket : lists.getTicketList()) {
            displayTickets.add(ticket);
        }

        ticketTableView.getItems().addAll(displayTickets);
    }
}
