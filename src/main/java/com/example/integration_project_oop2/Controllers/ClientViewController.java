package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.MovieList;
import com.example.integration_project_oop2.Classes.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ClientViewController {

    public Label titleLabel;
    public Label durationLabel;
    public Label genreLabel;
    public ChoiceBox showtimeDropdown;
    public Button backButton;
    public ListView movieListView;
    public Label ratingLabel;
    private MovieList movieList;

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
        for(Movie movie : movieList){
            movieListView.getItems().add(movie.getMovieTitle());
        }
    }
}

