package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MovieListEditorController {

    public TextField titleTextField;
    public TextField durationTextField;
    public TextField genreTextField;
    public Button addButton;
    public Button backButton;
    public Button updateButton;
    public Button removeButton;
    public ListView movieListView;

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    private String getSelectedMovie(){ return (String) movieListView.getSelectionModel().getSelectedItem(); }

    public void onAddButtonClick() {
        String realMovie = "It";

        //TODO Add code to add new movie using fields.

        if(titleTextField.getText().isEmpty() || durationTextField.getText().isEmpty() || genreTextField.getText().isEmpty()){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "All fields must not be empty.");
            viewAlert.showAndWait();
        } else if (titleTextField.getText().equals(realMovie)) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Movie already exists.");
            viewAlert.showAndWait();
        } else {
            movieListView.getItems().add(titleTextField.getText());
            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + "has been added!");
            viewAlert.showAndWait();
        }
    }

    public void onUpdateButtonClick() {
        if(movieListView.getSelectionModel().isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Select a movie to update.");
            viewAlert.showAndWait();
        } else if(titleTextField.getText().isEmpty() || durationTextField.getText().isEmpty() || genreTextField.getText().isEmpty()){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "All fields must not be empty.");
            viewAlert.showAndWait();
        } else {

            // TODO: Add code to update database List.

            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, getSelectedMovie() + " has been updated.");
            viewAlert.showAndWait();
        }
    }

    public void onRemoveButtonClick() {

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
