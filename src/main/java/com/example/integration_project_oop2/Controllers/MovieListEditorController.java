package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Classes.Showtime;
import com.example.integration_project_oop2.Lists.MovieList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import com.example.integration_project_oop2.MovieTheaterApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

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
        movieListView.getItems().clear();
        for(Movie movie : movieList){
            movieListView.getItems().add(movie.getMovieTitle());
        }
    }

    public void onAddButtonClick(ActionEvent event) {
        newWindow(event, "addNewMovie-view.fxml", "Add New Movie");
        populateList();
    }

    public void onUpdateButtonClick(ActionEvent event) {
        if(movieListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a movie to update.");
            viewAlert.showAndWait();
        } else {
            String title = movieListView.getSelectionModel().getSelectedItem().toString();
            Movie pMovie = movieList.getMovieByIndex(movieListView.getSelectionModel().getSelectedIndex());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MovieTheaterApplication.class.getResource("updateMovie-view.fxml"));
                Parent view = fxmlLoader.load();
                MovieDetailsController updateMovieController = fxmlLoader.getController();
                Scene nextScene = new Scene(view);
                Stage nextStage = new Stage();
                nextStage.setScene(nextScene);
                nextStage.setTitle("Update " + title);
                nextStage.initModality(Modality.WINDOW_MODAL);
                updateMovieController.setUpdateMovie(pMovie);
                nextStage.initOwner(((Node) event.getSource()).getScene().getWindow());
                nextStage.showAndWait();
                populateList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

            movieListView.getItems().remove(getSelectedMovie());

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + " has been removed.");
            viewAlert.showAndWait();

        }
    }

    public void onNewSelection(MouseEvent mouseEvent) {

        Movie selectedMovie = movieList.getMovieByIndex(movieListView.getSelectionModel().getSelectedIndex());

        titleLabel.setText(selectedMovie.getMovieTitle());
        genreLabel.setText(selectedMovie.getMovieGenre());
        durationLabel.setText(String.valueOf(selectedMovie.getMovieDuration()));
        ratingLabel.setText(selectedMovie.getAgeRating());
    }
}
