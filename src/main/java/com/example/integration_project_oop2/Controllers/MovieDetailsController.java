package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
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


    public void onCancelButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddMovieButtonClick(ActionEvent actionEvent) {

    }
}
