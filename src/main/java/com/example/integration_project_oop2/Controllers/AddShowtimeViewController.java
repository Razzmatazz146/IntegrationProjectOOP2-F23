package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
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

import java.util.ArrayList;
import java.util.List;

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
    private Showtime aShowtime;

    public void setUpdateShowtime(Showtime pShowtime){
        this.aShowtime = pShowtime;
        movieDropdown.setValue(pShowtime.getMovie());
        showroomDropdown.setValue(pShowtime.getShowroom());
        startTimeComboBox.setValue(pShowtime.getStartTime());
        endTimeComboBox.setValue(pShowtime.getEndTime());
        adultPriceTextField.setText(String.valueOf(pShowtime.getShowtimePrice()));
        childPriceTextField.setText(String.valueOf(pShowtime.getShowtimeChildPrice()));
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        movieList = lists.getMovieList();
        populateList();
    }
    private void populateList(){
        movieDropdown.getItems().addAll(movieList.getMovieTitleList());
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


        Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "A new showtime for "+ selectedMovie + "and " + selectedRoom +" has been successfully added!");
        viewAlert.showAndWait();
    }
}

}
