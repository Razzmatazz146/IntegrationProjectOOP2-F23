package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.ExceptionAlert;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalTime;

import static com.example.integration_project_oop2.Controllers.WindowController.newWindow;

/**
 * Controller used for CRUD purposes for the showtimes list. Can Add, Update or Remove showtimes, as well as see the
 * relevant information about each showtime when selected.
 */
public class ShowtimesListEditorController {

    public Label showroomLabel;
    public Label startTimeLabel;
    public Label endTimeLabel;
    public Label adultPriceLabel;
    public Label childPriceLabel;
    @FXML
    private Label movieTitleLabel;
    @FXML
    private ListView showtimesListView;
    @FXML
    private ShowtimeList aShowtimeList;
    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        aShowtimeList = lists.getShowtimeList();
        populateList();
    }
    private void populateList(){
        if (!showtimesListView.getItems().isEmpty()){
            showtimesListView.getItems().clear();
        }
        
        for(Showtime showtime : aShowtimeList){
            showtimesListView.getItems().add(showtime.getMovie().getMovieTitle());
        }
    }

    public void onAddButtonClick(ActionEvent event) {
        newWindow(event, "addShowtime-view.fxml", "Add Showtime");
        initialize();
    }

    public void onUpdateButtonClick(ActionEvent event) {
        if(showtimesListView.getSelectionModel().isEmpty()) {
            ExceptionAlert.alertIllegalArgumentException("Select a showtime to update.");
        } else {
            String title = showtimesListView.getSelectionModel().getSelectedItem().toString();
            Showtime pShowtime = aShowtimeList.getShowtimeByIndex(showtimesListView.getSelectionModel().getSelectedIndex());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MovieTheaterApplication.class.getResource("updateShowtime-view.fxml"));
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
                initialize();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onRemoveButtonClick() {

        if(showtimesListView.getSelectionModel().isEmpty()) {
            ExceptionAlert.alertIllegalArgumentException("Select a showtime to remove.");
        } else {
            Showtime selectedShowtime = aShowtimeList.getShowtimeByIndex(showtimesListView.getSelectionModel().getSelectedIndex());

            ExceptionAlert.alertConfirmation("Showtime for " + selectedShowtime.getMovie().getMovieTitle() + " in room " + selectedShowtime.getShowroom().getRoomNumber() + " has been removed.");

            aShowtimeList.removeShowtime(selectedShowtime);

            showtimesListView.getItems().clear();

            initialize();
        }
    }

    public void onNewSelection(MouseEvent mouseEvent) {
        Showtime selectedShowtime = aShowtimeList.getShowtimeByIndex(showtimesListView.getSelectionModel().getSelectedIndex());

        movieTitleLabel.setText(selectedShowtime.getMovie().getMovieTitle());
        showroomLabel.setText(String.valueOf(selectedShowtime.getShowroom().getRoomNumber()));
        startTimeLabel.setText(String.valueOf(selectedShowtime.getStartTime()));
        endTimeLabel.setText(String.valueOf(selectedShowtime.getEndTime()));
        adultPriceLabel.setText(String.format("$%.2f", (selectedShowtime.getShowtimePrice())));
        childPriceLabel.setText(String.format("$%.2f", (selectedShowtime.getShowtimeChildPrice())));
    }
}
