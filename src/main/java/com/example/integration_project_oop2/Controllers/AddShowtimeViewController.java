package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.ExceptionAlert;
import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.Showroom;
import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Lists.MovieList;
import com.example.integration_project_oop2.Lists.ShowroomList;
import com.example.integration_project_oop2.Lists.ShowtimeList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalTime;

/**
 * This controller is used with the associated addShowtime-view.fxml to add or update showtimes from the showtimes list.
 * It is used to create or update a showtime using a Movie, a Showroom, and the rest of the relevant attributes.
 */
@SuppressWarnings("ALL")
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
    private MovieList aMovieList;
    private ShowroomList aShowroomList;
    private LocalTime[] validTimes = {
            LocalTime.of(11,0),
            LocalTime.of(14, 0),
            LocalTime.of(17, 0),
            LocalTime.of(20, 0),
    };
    private Showtime aShowtime;

    /**
     * Setter for the showtime to be updated. Used in the new opened window to update showtimes.
     * @param pShowtime
     */
    public void setUpdateShowtime(Showtime pShowtime) {
        this.aShowtime = pShowtime;
        movieDropdown.setValue(pShowtime.getMovie().getMovieTitle());
        showroomDropdown.setValue(pShowtime.getShowroom().getRoomNumber());
        startTimeComboBox.setValue(pShowtime.getStartTime());
        endTimeComboBox.setValue(pShowtime.getEndTime());
        adultPriceTextField.setText(String.valueOf(pShowtime.getShowtimePrice()));
        childPriceTextField.setText(String.valueOf(pShowtime.getShowtimeChildPrice()));
    }

    /**
     * Back button. Closes the current window.
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
        aMovieList = lists.getMovieList();
        aShowroomList = lists.getShowroomList();

        populateList();
    }

    /**
     * Populates the dropdowns with their related information
     */
    private void populateList() {
        for (Showroom aShowroom : aShowroomList) {
            showroomDropdown.getItems().add(aShowroom.getRoomNumber());
        }
        for (LocalTime time : validTimes){
            startTimeComboBox.getItems().add(time);
            endTimeComboBox.getItems().add(time);
        }
        movieDropdown.getItems().addAll(aMovieList.getMovieTitleList());
    }

    /**
     * Button used to add or update a Showtime to the ShowtimeList
     */
    public void onAddButtonClick(ActionEvent event) {
        SingletonLists lists = SingletonLists.getInstance();
        ShowtimeList aShowtimeList = lists.getShowtimeList();

        LocalTime selectedStartTime = (LocalTime) startTimeComboBox.getSelectionModel().getSelectedItem();
        LocalTime selectedEndTime = (LocalTime) endTimeComboBox.getSelectionModel().getSelectedItem();

        Movie selectedMovie = aMovieList.getMovieByIndex(movieDropdown.getSelectionModel().getSelectedIndex());
        Showroom selectedRoom = aShowroomList.getShowroomByIndex(showroomDropdown.getSelectionModel().getSelectedIndex());

        try {
            double adultPrice = Double.parseDouble(adultPriceTextField.getText());
            double childPrice = Double.parseDouble(childPriceTextField.getText());

            if (selectedStartTime.isAfter(selectedEndTime)) {
                ExceptionAlert.alertIllegalArgumentException("Showtime cannot start after it ends.");
            } else if (checkDuplicate(aShowtimeList, selectedRoom, selectedStartTime)) {
                ExceptionAlert.alertIllegalArgumentException("A movie is already playing in this room at this time.");
            } else {
                aShowtimeList.addShowtime(new Showtime(selectedStartTime, selectedEndTime, selectedMovie, selectedRoom, adultPrice, childPrice));
                lists.setShowtimeList(aShowtimeList);
                ExceptionAlert.alertConfirmation("New showtime has been added for " + selectedMovie.getMovieTitle() + " in room " + selectedRoom.getRoomNumber() + "!");
            }
        } catch (NumberFormatException e) {
            ExceptionAlert.alertIllegalArgumentException("Invalid number format for prices.");
        }
    }

    /**
     * Method used to check if a movie is playing in the selected room at the selected time.
     * @param aShowtimeList The Showtime list
     * @param selectedRoom The selected room
     * @param selectedStartTime The selected start time
     * @return true if duplicate exists, else returns false
     */
    private boolean checkDuplicate(ShowtimeList aShowtimeList, Showroom selectedRoom, LocalTime selectedStartTime) {
        for (Showtime showtime : aShowtimeList) {
            if (selectedStartTime.equals(showtime.getStartTime()) && selectedRoom.getRoomNumber() == showtime.getShowroom().getRoomNumber()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Button to update selected showtime
     * @param actionEvent
     */
    public void onUpdateButtonClick(ActionEvent actionEvent) {
        SingletonLists lists = SingletonLists.getInstance();
        ShowtimeList aShowtimeList = lists.getShowtimeList();

        LocalTime selectedStartTime = (LocalTime) startTimeComboBox.getSelectionModel().getSelectedItem();
        LocalTime selectedEndTime = (LocalTime) endTimeComboBox.getSelectionModel().getSelectedItem();

        Movie selectedMovie = aMovieList.getMovieByIndex(movieDropdown.getSelectionModel().getSelectedIndex());
        Showroom selectedRoom = aShowroomList.getShowroomByIndex(showroomDropdown.getSelectionModel().getSelectedIndex());

        try {
            double adultPrice = Double.parseDouble(adultPriceTextField.getText());
            double childPrice = Double.parseDouble(childPriceTextField.getText());

            if (selectedStartTime.isAfter(selectedEndTime)) {
                ExceptionAlert.alertIllegalArgumentException("Showtime cannot start after it ends.");
            } else {
                aShowtimeList.editShowtime(aShowtime, new Showtime(selectedStartTime, selectedEndTime, selectedMovie, selectedRoom, adultPrice, childPrice));
                lists.setShowtimeList(aShowtimeList);
                ExceptionAlert.alertConfirmation("Showtime for " + selectedMovie.getMovieTitle() + " in room " + selectedRoom.getRoomNumber() + " has been updated!");
            }
        } catch (NumberFormatException e) {
            ExceptionAlert.alertIllegalArgumentException("Invalid number format for prices.");
        }
    }
}


