package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.ExceptionAlert;
import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Lists.MovieList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This controller is associated with the "addNewMovie-view.fxml". It is used to add or edit movies from
 * the movie list.
 */
public class MovieDetailsController {
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField genreTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField durationTextField;
    @FXML
    private TextField ratingTextField;
    @FXML
    public Button addMovieButton;
    @FXML
    public Button cancelMovieButton;
    @FXML
    private MovieList movieList;
    private Movie aMovie;

    /**
     * Closes the window without saving
     */
    public void onCancelButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Button to add new movie to the move list.
     */
    public void onAddMovieButtonClick() {

        String title = titleTextField.getText();
        String genre = genreTextField.getText();
        int year = Integer.parseInt(yearTextField.getText());
        int duration = Integer.parseInt(durationTextField.getText());
        String rating = ratingTextField.getText();

        SingletonLists lists = SingletonLists.getInstance();

        movieList = lists.getMovieList();

        movieList.addMovie(new Movie(title, genre, duration, year, rating));

        lists.setMovieList(movieList);

        ExceptionAlert.alertConfirmation(title + " successfully added!");

        titleTextField.clear();
        genreTextField.clear();
        yearTextField.clear();
        durationTextField.clear();
        ratingTextField.clear();
    }

    /**
     * Method to set the selected movie from the previous window to the relevant information.
     * @param pMovie selected movie
     */
    public void setUpdateMovie(Movie pMovie){
        this.aMovie = pMovie;
        titleTextField.setText(pMovie.getMovieTitle());
        genreTextField.setText(pMovie.getMovieGenre());
        yearTextField.setText(String.valueOf(pMovie.getReleaseYear()));
        durationTextField.setText(String.valueOf(pMovie.getMovieDuration()));
        ratingTextField.setText(pMovie.getAgeRating());
    }

    /**
     * Button to update the movie on the move list.
     */
    public void onUpdateMovieButtonClick(ActionEvent actionEvent) {

        String title = titleTextField.getText();
        String genre = genreTextField.getText();
        int year = Integer.parseInt(yearTextField.getText());
        int duration = Integer.parseInt(durationTextField.getText());
        String rating = ratingTextField.getText();

        SingletonLists lists = SingletonLists.getInstance();

        movieList = lists.getMovieList();

        movieList.editMovie(aMovie, new Movie(title, genre, duration, year, rating));

        lists.setMovieList(movieList);

        ExceptionAlert.alertConfirmation(title + " successfully updated!");

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
