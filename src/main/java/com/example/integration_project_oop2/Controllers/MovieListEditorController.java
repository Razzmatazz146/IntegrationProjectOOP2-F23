package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.ExceptionAlert;
import com.example.integration_project_oop2.Classes.Movie;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This controller is used for CRUD purposes with the "managerMovie-view.fxml". It is used to add, remove or edit movies.
 */
@SuppressWarnings("ALL")
public class MovieListEditorController extends WindowController{
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

    /**
     * Gets the selected movie
     * @return selected movie
     */
    private String getSelectedMovie(){ return (String) movieListView.getSelectionModel().getSelectedItem(); }
    /**
     * Button to close the window
     * @param actionEvent
     */
    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Methods and instances initialized when window is opened or when the method is called.
     */
    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        this.movieList = lists.getMovieList();
        populateList();
    }

    /**
     * Method used to populate the movie list view.
     */
    private void populateList(){
        if (!movieListView.getItems().isEmpty()){
            movieListView.getItems().clear();
        }

        for(Movie movie : movieList){
            movieListView.getItems().add(movie.getMovieTitle());
        }
    }

    /**
     * Button to open window to add a new movie to the movie list.
     */
    public void onAddButtonClick(ActionEvent event) {
        newWindow(event, "addNewMovie-view.fxml", "Add New Movie");
        initialize();
    }

    /**
     * Button to update a movie from the movie list.
     */
    public void onUpdateButtonClick(ActionEvent event) {
        if(movieListView.getSelectionModel().isEmpty()) {
            ExceptionAlert.alertIllegalArgumentException("Select a movie to update.");
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
                initialize();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Button to remove the selected movie from the movie list.
     * @param event
     */
    public void onRemoveButtonClick(ActionEvent event) {

        if(movieListView.getSelectionModel().isEmpty()){
            ExceptionAlert.alertIllegalArgumentException("Select a movie to remove.");
        } else {

            Movie selectedMovie = movieList.getMovieByIndex(movieListView.getSelectionModel().getSelectedIndex());

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + " has been removed.");
            viewAlert.showAndWait();

            movieList.removeMovie(selectedMovie);

            movieListView.getItems().clear();

            initialize();
        }
    }

    /**
     * Updates the related labels when a new item is selected from the list view.
     * @param mouseEvent when new item is selected.
     */
    public void onNewSelection(MouseEvent mouseEvent) {

        Movie selectedMovie = movieList.getMovieByIndex(movieListView.getSelectionModel().getSelectedIndex());

        titleLabel.setText(selectedMovie.getMovieTitle());
        genreLabel.setText(selectedMovie.getMovieGenre());
        durationLabel.setText(String.valueOf(selectedMovie.getMovieDuration()));
        ratingLabel.setText(selectedMovie.getAgeRating());
    }
}
