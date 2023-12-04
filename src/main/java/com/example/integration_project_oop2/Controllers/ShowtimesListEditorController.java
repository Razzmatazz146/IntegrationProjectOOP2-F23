package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Classes.ShowtimeList;
import com.example.integration_project_oop2.Classes.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.util.ArrayList;

public class ShowtimesListEditorController {

    public ListView showtimesListView;
    public TextField adultPriceTextField;
    public TextField childPriceTextField;
    public Button addButton;
    public Button backButton;
    public Button updateButton;
    public Button removeButton;
    public ChoiceBox movieDropdown;
    public ChoiceBox showroomDropdown;
    public ChoiceBox timeDropdown;
    private ShowtimeList showtimeList;

    private String getSelectedMovie() { return  (String) movieDropdown.getSelectionModel().getSelectedItem(); }
    private String getSelectedRoom() { return (String) showroomDropdown.getSelectionModel().getSelectedItem(); }

    private LocalTime[] validTimes = {
            LocalTime.of(11,0),
            LocalTime.of(15, 0),
            LocalTime.of(18, 0),
            LocalTime.of(21, 0)
    };

    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        showtimeList = lists.getShowtimeList();
        populateList();
    }
    private void populateList(){
        for(Showtime showtime : showtimeList){
            showtimesListView.getItems().add(showtime.getMovie().getMovieTitle());
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddButtonClick() {
        String realMovie = "It";
        int realRoom = 1;

        String selectedMovie = (String) movieDropdown.getSelectionModel().getSelectedItem();
        int selectedRoom = (int) showroomDropdown.getSelectionModel().getSelectedItem();

        //TODO Add code to add new movie using fields.

        if (movieDropdown.getSelectionModel().getSelectedItem().equals(realMovie) && showroomDropdown.getSelectionModel().getSelectedItem().equals(realRoom)){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "This showtime already exists.");
            viewAlert.showAndWait();
        } else {

            // TODO: Add code to add movie to database and ListView

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "A new showtime for "+ selectedMovie + "and " + selectedRoom +" has been successfully added!");
            viewAlert.showAndWait();
        }
    }

    public void onUpdateButtonClick() {

        if(showtimesListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a showtime.");
            viewAlert.showAndWait();
        } else {

            // TODO: Add code to update database List.

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "Showtime for "+ getSelectedMovie() + "and " + getSelectedRoom() +" has been updated.");
            viewAlert.showAndWait();
        }
    }

    public void onRemoveButtonClick() {

        if(showtimesListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a showtime.");
            viewAlert.showAndWait();
        } else {

            // TODO Add code to remove item from ListView and database list.

            showtimesListView.getItems().remove(getSelectedMovie());
            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + "'s showtime in " + getSelectedRoom() + " has been removed.");
            viewAlert.showAndWait();
        }
    }
}
