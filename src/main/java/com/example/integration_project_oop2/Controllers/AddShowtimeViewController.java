package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddShowtimeViewController {

    @FXML
    private ComboBox movieDropdown;
    @FXML
    private ComboBox showroomDropdown;
    @FXML
    private ComboBox startTimeComboBox;
    @FXML
    private ComboBox endTimeComboBox;

    @FXML
    private TextField adultPriceTextField;
    @FXML
    private TextField childPriceTextField;

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddButtonClick(ActionEvent event) {
    String realMovie = "It";
    int realRoom = 1;

    String selectedMovie = (String) movieDropdown.getSelectionModel().getSelectedItem();
    int selectedRoom = (int) showroomDropdown.getSelectionModel().getSelectedItem();
       if (movieDropdown.getSelectionModel().getSelectedItem().equals(realMovie) && showroomDropdown.getSelectionModel().getSelectedItem().equals(realRoom)){
        Alert viewAlert = new Alert(Alert.AlertType.ERROR, "This showtime already exists.");
        viewAlert.showAndWait();
    } else {

        // TODO: Add code to add movie to database and ListView
        //showtimeList.addShowtime(new Showtime());

        Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "A new showtime for "+ selectedMovie + "and " + selectedRoom +" has been successfully added!");
        viewAlert.showAndWait();
    }
}

}
