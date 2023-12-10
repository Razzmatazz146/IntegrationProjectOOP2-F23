package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Lists.ShowtimeList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import com.example.integration_project_oop2.MovieTheaterApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;

import static com.example.integration_project_oop2.Controllers.WindowController.newWindow;

public class ShowtimesListEditorController {

    @FXML
    private Label movieTitleLabel;
    @FXML
    private ListView showtimesListView;
    @FXML
    private TextField adultPriceTextField;
    @FXML
    private TextField childPriceTextField;
    @FXML
    private Button addButton;
    @FXML
    private Button backButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button removeButton;
    @FXML
   private ComboBox movieDropdown;
    @FXML
    private ComboBox showroomDropdown;
    @FXML
    private ComboBox startTimeComboBox;
    @FXML
    private ComboBox endTimeComboBox;
    @FXML
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
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        showtimeList = lists.getShowtimeList();
        populateList();
    }
    private void populateList(){
        showtimesListView.getItems().clear();
        for(Showtime showtime : showtimeList){
            showtimesListView.getItems().add(showtime.getMovie().getMovieTitle());
        }
    }

    public void onAddButtonClick(ActionEvent event) {
        newWindow(event, "addShowtime-view.fxml", "Add Showtime");
    }

    public void onUpdateButtonClick(ActionEvent event) {

        if(showtimesListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a showtime.");
            viewAlert.showAndWait();
        } else {
            String title = showtimesListView.getSelectionModel().getSelectedItem().toString();
            Showtime pShowtime = showtimeList.getShowtimeByIndex(showtimesListView.getSelectionModel().getSelectedIndex());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MovieTheaterApplication.class.getResource("addShowtime-view.fxml"));
                Parent view = fxmlLoader.load();
                AddShowtimeViewController updateShowtimeController = fxmlLoader.getController();
                Scene nextScene = new Scene(view);
                Stage nextStage = new Stage();
                nextStage.setScene(nextScene);
                nextStage.setTitle("Update " + title);
                nextStage.initModality(Modality.WINDOW_MODAL);
                updateShowtimeController.setUpdateShowtime(pShowtime);
                nextStage.initOwner(((Node) event.getSource()).getScene().getWindow());
                nextStage.showAndWait();
                populateList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            String title = showtimesListView.getSelectionModel().getSelectedItem().toString();
            newWindow(event,"addShowtime-view.fxml", "Update " + title);


            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "Showtime for "+ getSelectedMovie() + "and " + getSelectedRoom() +" has been updated.");
            viewAlert.showAndWait();
    }

    public void onRemoveButtonClick() {

        if(showtimesListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a showtime.");
            viewAlert.showAndWait();
        } else {
            Showtime selectedShowtime = showtimeList.getShowtimeByIndex(showtimesListView.getSelectionModel().getSelectedIndex());

            showtimesListView.getItems().remove(selectedShowtime);
            showtimeList.removeShowtime(selectedShowtime);

            initialize();

            showtimesListView.getItems().remove(getSelectedMovie());
            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + "'s showtime in " + getSelectedRoom() + " has been removed.");
            viewAlert.showAndWait();
        }
    }
}
