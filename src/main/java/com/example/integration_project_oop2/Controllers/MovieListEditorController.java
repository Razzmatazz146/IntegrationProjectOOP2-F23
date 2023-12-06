package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Lists.MovieList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MovieListEditorController extends WindowController{

    @FXML
    private Button addButton;
    @FXML
    private Button backButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button removeButton;
    @FXML
    private ListView movieListView;
    @FXML
    private Label titleLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label ratingLabel;
    @FXML
    private MovieList movieList;

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    private String getSelectedMovie(){ return (String) movieListView.getSelectionModel().getSelectedItem(); }

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

    public void onAddButtonClick(ActionEvent event) {
        newWindow(event, "addNewMovie-view.fxml", "Add New Movie");
    }

    public void onUpdateButtonClick(ActionEvent event) {
        if(movieListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a movie to update.");
            viewAlert.showAndWait();
        } else {
            String title = movieListView.getSelectionModel().getSelectedItem().toString();
            newWindow(event,"addNewMovie-view.fxml", "Update " + title);
        }
    }

    public void onRemoveButtonClick(ActionEvent event) {

        if(movieListView.getSelectionModel().isEmpty()){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a movie to remove.");
            viewAlert.showAndWait();
        } else {

            Movie selectedMovie = movieList.getMovieByIndex(movieListView.getSelectionModel().getSelectedIndex());

            movieListView.getItems().remove(selectedMovie);
            movieList.removeMovie(selectedMovie);

            initialize();

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + " has been removed.");
            viewAlert.showAndWait();
            movieListView.getItems().remove(getSelectedMovie());
        }
    }
}
