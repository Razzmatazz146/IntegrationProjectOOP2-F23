package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.MovieTheaterApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {


    public Button signupButton;
    public TextField usernameTextField;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField emailTextField;
    public PasswordField passwordTextField;
    public Button backButton;

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

    @FXML
    protected void onBackButtonClick(ActionEvent pEvent) throws IOException {

    }

}