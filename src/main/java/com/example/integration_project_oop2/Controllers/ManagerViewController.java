package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManagerViewController extends WindowController {


    public Button editMovieButton;
    public Button clientListButton;
    public Button clientViewButton;
    public Button editShowtimesButton;
    public Button staffListButton;
    public Button logoutButton;
    public Button salesMovieButton;
    public Button salesShowtimeButton;

    @FXML
    protected void onLogOutButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    public void onEditMoviesButtonClick(ActionEvent event) {
        newWindow(event, "managerMovie-view.fxml", "Edit Movies");
    }

    public void onClientListButtonClick(ActionEvent event) {
        newWindow(event, "managerLists-view.fxml", "Client List");
    }

    public void onClientViewButtonClick(ActionEvent event) {
        newWindow(event, "client-view.fxml", "Client's View");
    }

    public void onEditShowtimesButtonClick(ActionEvent event) {
        newWindow(event, "managerShowtime-view.fxml", "Edit Showtimes");
    }

    public void onStaffListButtonClick(ActionEvent event) {
        newWindow(event, "managerLists-view.fxml", "Staff List");
    }

    public void onShowtimesSalesButton(ActionEvent event) {
        newWindow(event, "managerLists-view.fxml", "Ticket Sales");
    }

    public void onSalesMovieButton(ActionEvent event) {
        newWindow(event, "managerLists-view.fxml", "Ticket Sales");
    }
}
