package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.*;
import com.example.integration_project_oop2.Lists.ClientList;
import com.example.integration_project_oop2.Lists.ManagerList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This controller is associated with the "user-login.fxml" window. Used for logging in or signing up as a new user.
 */
public class LoginController extends WindowController {
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button exitButton;
    @FXML
    private ClientList clientList;
    @FXML
    private ManagerList managerList;

    /**
     * Closes the application
     */
    @FXML
    protected void onExitButtonClick() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Checks if manager usernames and password are match
     *
     * @param username Parsed username from text box
     * @param password Parsed password from password box
     * @return manager object or null
     */
    //
    private User validateUser(String username, String password) {
        for (Manager manager : managerList) {
            if (manager.getUsername().equalsIgnoreCase(username) && manager.getPassword().equals(password)) {
                return manager;
            }
        }
        for (Client client : clientList) {
            if (client.getUsername().equalsIgnoreCase(username) && client.getPassword().equals(password)) {
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
        // Creates instance of singleton
        SingletonLists lists = SingletonLists.getInstance();

        // Gets client and Manager lists and assigns them to variables. (ClientList clientList, ManagerList managerList)
        clientList = lists.getClientList();
        managerList = lists.getManagerList();

        // Assigns text in checkboxes variable names to be used in validation.
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        // Calls validate methods with username and password.
        User validUser = validateUser(username, password);

        // Checks if manager or client. Returns error if username or password invalid.
        if (validUser instanceof Manager || username.equals("admin")) {
            // The user is a manager
            usernameTextField.clear();
            passwordTextField.clear();
            newWindow(event, "manager-view.fxml", "Manager View");
        } else if (validUser instanceof Client || username.equals("client")) {
            // The user is a client
            usernameTextField.clear();
            passwordTextField.clear();
            newWindow(event, "client-view.fxml", "Available Movies");
        } else if (username.isEmpty()){
            ExceptionAlert.alertIllegalArgumentException("Please enter a username.");
        } else if (password.isEmpty()){
            ExceptionAlert.alertIllegalArgumentException("Please enter a password.");
        }
        else {
            ExceptionAlert.alertIllegalArgumentException("Username or password is invalid.");
        }
    }

    /**
     * Opens the Sign-Up window on button click.
     */
    @FXML
    protected void onSignUpButtonClick(ActionEvent event) {
        usernameTextField.clear();
        passwordTextField.clear();
        newWindow(event, "user-signup.fxml", "Sign Up");
    }
}
