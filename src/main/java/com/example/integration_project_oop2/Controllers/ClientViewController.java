package com.example.integration_project_oop2.Controllers;

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

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}

