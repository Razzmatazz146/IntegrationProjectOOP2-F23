package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.*;
import com.example.integration_project_oop2.Lists.SingletonLists;
import com.example.integration_project_oop2.Lists.TicketList;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller is used with the ticket view window to show ticket sales by movie title from the manager view.
 */
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
        TicketList ticketList = lists.getTicketList();

        TableColumn<Ticket, String> ticketMovieColumn = new TableColumn<>("Movie");
        ticketMovieColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getShowtime().getMovie().getMovieTitle()));

        TableColumn<Ticket, String> ticketSalesColumn = new TableColumn<>("Total Sales");
        ticketSalesColumn.setCellValueFactory(cellData -> {
            Movie movie = cellData.getValue().getShowtime().getMovie();
            int totalSales = calculateTotalSales(lists.getTicketList(), movie);
            return new ReadOnlyStringWrapper(Integer.toString(totalSales));
        });

        ticketTableView.getColumns().add(ticketMovieColumn);
        ticketTableView.getColumns().add(ticketSalesColumn);

        List<Ticket> uniqueMovieTickets = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            boolean isUnique = true;
            for (Ticket uniqueTicket : uniqueMovieTickets) {
                if (uniqueTicket.getShowtime().getMovie().getMovieTitle().equals(ticket.getShowtime().getMovie().getMovieTitle())) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueMovieTickets.add(ticket);
            }
        }

        ticketTableView.getItems().addAll(uniqueMovieTickets);
    }

    private int calculateTotalSales(TicketList ticketList, Movie movie) {
        int totalSales = 0;

        for (Ticket ticket : ticketList) {
            if (ticket.getShowtime().getMovie().equals(movie)) {
                totalSales++;
            }
        }
        return totalSales;
    }
}
