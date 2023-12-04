package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.MovieList;
import com.example.integration_project_oop2.Classes.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MovieListEditorController extends WindowController{

    public Button addButton;
    public Button backButton;
    public Button updateButton;
    public Button removeButton;
    public ListView movieListView;
    public Label titleLabel;
    public Label genreLabel;
    public Label durationLabel;
    public Label ratingLabel;
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

            // TODO Add code to remove item from ListView and database list.

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + " has been removed.");
            viewAlert.showAndWait();
            movieListView.getItems().remove(getSelectedMovie());
        }
    }
}
