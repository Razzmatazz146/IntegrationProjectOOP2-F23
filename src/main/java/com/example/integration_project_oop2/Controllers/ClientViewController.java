package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Lists.ShowtimeList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 */
public class ClientViewController {

    @FXML
    private Label titleLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private ListView movieListView;
    @FXML
    private Label ratingLabel;
    @FXML
    private ListView showtimeListView;
    @FXML
    private ShowtimeList showtimeList;

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
        for(Showtime showtime : showtimeList){
            movieListView.getItems().add(showtime.getMovie().getMovieTitle());
        }
    }

    public void onNewSelection(MouseEvent mouseEvent) {
        showtimeListView.getItems().clear();

        Showtime selectedMovie = showtimeList.getShowtimeByIndex(movieListView.getSelectionModel().getSelectedIndex());

        titleLabel.setText(selectedMovie.getMovie().getMovieTitle());
        genreLabel.setText(selectedMovie.getMovie().getMovieGenre());
        durationLabel.setText(String.valueOf(selectedMovie.getMovie().getMovieDuration()));
        ratingLabel.setText(selectedMovie.getMovie().getAgeRating());

        showtimeListView.getItems().addAll(selectedMovie.getStartTime());
    }
}

