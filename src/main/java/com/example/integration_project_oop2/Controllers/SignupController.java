package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController extends WindowController {


    public Button signupButton;
    public TextField usernameTextField;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField emailTextField;
    public PasswordField passwordTextField;
    public Button backButton;

    @FXML
    protected void onSignUpButtonClick(ActionEvent pEvent) {
        String realExistingUser = "manager1";

        // TODO Add code to add new user to database.

        if(usernameTextField.getText().equals(realExistingUser)){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Username already exists.");
            viewAlert.showAndWait();
        } else {
            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "Welcome " + usernameTextField.getText() + "!");
            viewAlert.showAndWait();

            Stage stage = (Stage) ((Node) pEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}