package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Showroom;
import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Lists.MovieList;
import com.example.integration_project_oop2.Lists.ShowroomList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalTime;

/**
 * This controller is used with the associated window to add or update showtimes from the showtimes list.
 */
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

    MovieList movieList;
    private ShowroomList aShowroomList;
    private LocalTime[] validTimes = {
            LocalTime.of(11,0),
            LocalTime.of(14, 0),
            LocalTime.of(17, 0),
            LocalTime.of(20, 0),
    };

    /**
     * Setter for the showtime to be updated. Used in the new opened window to update showtimes.
     * @param pShowtime
     */
    public void setUpdateShowtime(Showtime pShowtime) {
        movieDropdown.setValue(pShowtime.getMovie().getMovieTitle());
        showroomDropdown.setValue(pShowtime.getShowroom().getRoomNumber());
        startTimeComboBox.setValue(pShowtime.getStartTime());
        endTimeComboBox.setValue(pShowtime.getEndTime());
        adultPriceTextField.setText(String.valueOf(pShowtime.getShowtimePrice()));
        childPriceTextField.setText(String.valueOf(pShowtime.getShowtimeChildPrice()));
    }

    /**
     * Back button. Closes the current window.
     * @param actionEvent
     */
    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Contains methods and attributes to be executed and set when the window is initialized.
     */
    @FXML
    private void initialize() {
        SingletonLists lists = SingletonLists.getInstance();
        movieList = lists.getMovieList();
        aShowroomList = lists.getShowroomList();
        for (LocalTime time : validTimes){
            startTimeComboBox.getItems().add(time);
            endTimeComboBox.getItems().add(time);
        }
        populateList();
    }

    /**
     * Populates the listview with
     */
    private void populateList() {
        for (Showroom aShowroom : aShowroomList) {
            showroomDropdown.getItems().add(aShowroom.getRoomNumber());
        }
    }



        public void onAddButtonClick (ActionEvent event){
            String realMovie = "It";
            int realRoom = 1;

            String selectedMovie = (String) movieDropdown.getSelectionModel().getSelectedItem();
            int selectedRoom = (int) showroomDropdown.getSelectionModel().getSelectedItem();
            if (movieDropdown.getSelectionModel().getSelectedItem().equals(realMovie) && showroomDropdown.getSelectionModel().getSelectedItem().equals(realRoom)) {
                Alert viewAlert = new Alert(Alert.AlertType.ERROR, "This showtime already exists.");
                viewAlert.showAndWait();
            } else {

                // TODO: Add code to add movie to database and ListView


                Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "A new showtime for " + selectedMovie + "and " + selectedRoom + " has been successfully added!");
                viewAlert.showAndWait();
            }
        }

    }

