package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Movie;
import com.example.integration_project_oop2.Lists.MovieList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MovieDetailsController {
    public TextField titleTextField;
    public TextField genreTextField;
    public TextField yearTextField;
    public TextField durationTextField;
    public TextField ratingTextField;
    public Button addMovieButton;
    public Button cancelMovieButton;
    private MovieList movieList;
    private Movie aMovie;
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);


    public void onCancelButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddMovieButtonClick(ActionEvent actionEvent) {

        String title = titleTextField.getText();
        String genre = genreTextField.getText();
        int year = Integer.parseInt(yearTextField.getText());
        int duration = Integer.parseInt(durationTextField.getText());
        String rating = ratingTextField.getText();

        SingletonLists lists = SingletonLists.getInstance();

        movieList = lists.getMovieList();

        movieList.addMovie(new Movie(title, genre, duration, year, rating));

        lists.setMovieList(movieList);

        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(title + " has successfully been added!");

        titleTextField.clear();
        genreTextField.clear();
        yearTextField.clear();
        durationTextField.clear();
        ratingTextField.clear();
    }

    public void setUpdateMovie(Movie pMovie){
        this.aMovie = pMovie;
        titleTextField.setText(pMovie.getMovieTitle());
        genreTextField.setText(pMovie.getMovieGenre());
        yearTextField.setText(String.valueOf(pMovie.getReleaseYear()));
        durationTextField.setText(String.valueOf(pMovie.getMovieDuration()));
        ratingTextField.setText(pMovie.getAgeRating());
    }

    public void onUpdateMovieButtonClick(ActionEvent actionEvent) {

        String title = titleTextField.getText();
        String genre = genreTextField.getText();
        int year = Integer.parseInt(yearTextField.getText());
        int duration = Integer.parseInt(durationTextField.getText());
        String rating = ratingTextField.getText();

        SingletonLists lists = SingletonLists.getInstance();

        movieList = lists.getMovieList();

        movieList.editMovie(new Movie(title, genre, duration, year, rating), aMovie);

        lists.setMovieList(movieList);

        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(title + " has successfully been updated!");

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
