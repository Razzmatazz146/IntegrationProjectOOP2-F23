package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * This controller is associated with the "manager-view.fxml". Has all the necessary buttons to open the needed views to
 * manage and get information about the theater.
 */
public class ManagerViewController extends WindowController {

    /**
     * Closes the window
     */
    @FXML
    protected void onLogOutButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Open the movie list window
     */
    public void onEditMoviesButtonClick(ActionEvent event) {
        newWindow(event, "managerMovie-view.fxml", "Edit Movies");
    }

    /**
     * Opens the client list window
     */
    public void onClientListButtonClick(ActionEvent event) {
        newWindow(event, "managerClientList.fxml", "Client List");
    }

    /**
     * Opens a client's view window. Shows what a client sees
     */
    public void onClientViewButtonClick(ActionEvent event) {
        newWindow(event, "client-view.fxml", "Client's View");
    }

    /**
     * Opens the Showtime list window
     */
    public void onEditShowtimesButtonClick(ActionEvent event) {
        newWindow(event, "managerShowtime-view.fxml", "Edit Showtimes");
    }

    public void onSalesMovieButtonClick(ActionEvent event) {
        newWindow(event, "managerTicketPerMovieList.fxml", "Sales per Movie");
    }

    /**
     * Opens sales per showtime list window
     */
    public void onSalesShowtimeButtonClick(ActionEvent event) {
        newWindow(event, "managerTicketPerShowtimeList.fxml", "Sales per Showtime");
    }

    /**
     * Opens the sales per movie window
     */
    public void onViewShowroomsButtonClick(ActionEvent event) {
        newWindow(event, "managerShowrooms-view.fxml", "Showrooms");
    }
}
