package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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
    private Button addMovieButton;
    @FXML
    private Button cancelMovieButton;


    public void onCancelButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddMovieButtonClick(ActionEvent actionEvent) {

    }
}
