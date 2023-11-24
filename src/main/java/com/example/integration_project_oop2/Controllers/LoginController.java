package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.MovieTheaterApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public PasswordField passwordTextField;
    public Button loginButton;
    public Button signupButton;
    public Button managementButton;
    public Button userButton;
    public TextField usernameTextField;


    private String checkManager(){

        String selectedView;

        if (usernameTextField.getText().isEmpty()){
            selectedView = "client-view.fxml";
        } else {
            selectedView = "manager-view.fxml";
        }
        return selectedView;
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieTheaterApplication.class.getResource(checkManager()));
        Parent view = fxmlLoader.load();
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Available Movies");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }
    @FXML
    protected void onSignUpButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieTheaterApplication.class.getResource("user-signup.fxml"));
        Parent view = fxmlLoader.load();
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Sign Up");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }
}
