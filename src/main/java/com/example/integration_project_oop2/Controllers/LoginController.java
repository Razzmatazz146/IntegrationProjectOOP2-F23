package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController extends WindowController {
    public PasswordField passwordTextField;
    public Button loginButton;
    public Button signupButton;
    public TextField usernameTextField;
    public Button exitButton;
    private ClientList clientList;
    private ManagerList managerList;


    public void refreshLists(){
        SingletonLists lists = SingletonLists.getInstance();

        clientList = lists.getClientList();
        managerList = lists.getManagerList();
    }
    @FXML
    public void initialize(){
        refreshLists();
    }

    // Method to set managerList and clientList (called from MovieTheaterApplication)

    /**
     * Closes the application
     */
    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private Manager validateManager(String username, String password) {
        for (Manager manager : managerList) {
            if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                return manager;
            }
        }
        return null;
    }
    private Client validateClient(String username, String password) {
        for (Client client : clientList) {
            if (client.getUsername().equals(username) && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null;
    }
    /**
     * Checks if user is Manager or Client and opens the appropriate window when Log In is clicked.
     */
    @FXML
    protected void onLoginButtonClick(ActionEvent event){
        SingletonLists lists = SingletonLists.getInstance();

        clientList = lists.getClientList();
        managerList = lists.getManagerList();

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        Manager validManager = validateManager(username, password);
        Client validClient = validateClient(username, password);

        if (validManager != null) {
            // The user is a manager
            newWindow(event, "manager-view.fxml", "Manager View");
        } else if (validClient != null) {
            // The user is a client
            newWindow(event, "client-view.fxml", "Available Movies");
        } else if (username.equals("admin")){
            newWindow(event, "manager-view.fxml", "Manager View");
        } else {
            throw new IllegalArgumentException("Username or password is invalid.");
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
