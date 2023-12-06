package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Classes.Ticket;
import com.example.integration_project_oop2.Lists.TicketList;
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

public class ViewTicketByShowtimeController {

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

        TableColumn<Ticket, String> showtimeMovieTitleColumn = new TableColumn<>("Movie");
        showtimeMovieTitleColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getShowtime().getMovie().getMovieTitle()));
        TableColumn<Ticket, String> showtimeTimeColumn = new TableColumn<>("Time");
        showtimeTimeColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper((cellData.getValue().getShowtime().getStartTime().format(DateTimeFormatter.ofPattern("HH:mm")))));
        TableColumn<Ticket, String> ticketShowroomColumn = new TableColumn<>("Room");
        ticketShowroomColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getShowtime().getShowroom().getRoomNumber())));
        TableColumn<Ticket, String> ticketSalesColumn = new TableColumn<>("Total Sales");
        ticketSalesColumn.setCellValueFactory(cellData -> {
            Showtime showtime = cellData.getValue().getShowtime();
            int totalSales = calculateTotalSales(lists.getTicketList(), showtime);
            return new ReadOnlyStringWrapper(Integer.toString(totalSales));
        });

        ticketTableView.getColumns().add(showtimeMovieTitleColumn);
        ticketTableView.getColumns().add(showtimeTimeColumn);
        ticketTableView.getColumns().add(ticketShowroomColumn);
        ticketTableView.getColumns().add(ticketSalesColumn);

        List<Ticket> displayTickets = new ArrayList<>();

        for (Ticket ticket : lists.getTicketList()) {
            boolean isUnique = true;
            for (Ticket displayedTicket : displayTickets) {
                if (displayedTicket.getShowtime().getShowtimeID().equals(ticket.getShowtime().getShowtimeID())) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                displayTickets.add(ticket);
            }
        }

        ticketTableView.getItems().addAll(displayTickets);
    }
    private int calculateTotalSales(TicketList ticketList, Showtime showtime) {
        int totalSales = 0;

        for (Ticket ticket : ticketList) {
            if (ticket.getShowtime().getShowtimeID().equals(showtime.getShowtimeID())) {
                totalSales++;
            }
        }
        return totalSales;
    }
}
