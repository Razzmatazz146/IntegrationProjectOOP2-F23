package com.example.integration_project_oop2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends WindowController {
    public PasswordField passwordTextField;
    public Button loginButton;
    public Button signupButton;
    public TextField usernameTextField;
    public Button exitButton;

    /**
     * Closes the application
     */
    @FXML
    protected void onExitButtonClick() { System.exit(0); }

    /**
     * Check to see if username is of manager or client.
     * @return selected view and name of new window.
     */
    private String[] checkManager(){
        String realManager = "manager1";
        String realPassword = "password1";
        String selectedView;
        String viewName;

        if (usernameTextField.getText().equals(realManager) && passwordTextField.getText().equals(realPassword)){
            selectedView = "manager-view.fxml";
            viewName = "Manager View";
        } else {
            selectedView = "client-view.fxml";
            viewName = "Available Movies";
        }
        return new String[]{selectedView, viewName};
    }

    /**
     * Checks if user is Manager or Client and opens the appropriate window when Log In is clicked.
     */
    @FXML
    protected void onLoginButtonClick(ActionEvent event){
        if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Please enter a valid username and password.");
            viewAlert.showAndWait();
        } else {
            String[] result = checkManager();
            newWindow(event, result[0], result[1]);
        }
    }

    /**
     * Opens the Sign-Up window on button click.
     */
    @FXML
    protected void onSignUpButtonClick(ActionEvent event) {
        newWindow(event, "user-signup.fxml", "Sign Up");
    }
}
