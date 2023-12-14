package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.*;
import com.example.integration_project_oop2.Lists.ClientList;
import com.example.integration_project_oop2.Lists.ManagerList;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * This controller is used with the "user-signup.fxml" window. Uses the User and Client classes to create a new client
 * using the given information.
 */
public class SignupController extends WindowController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField paymentInfoTextField;
    @FXML
    private ClientList clientList;
    @FXML
    private ManagerList managerList;

    /**
     * Initializes instances of lists when window opens.
     */
    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        clientList = lists.getClientList();
        managerList = lists.getManagerList();
    }

    /**
     * Boolean to check if user or email already exists.
     * @param username
     * @param email
     * @return true if exists, else false
     */
    private boolean ifExists(String username, String email) {
        for (Manager manager : managerList) {
            if (manager.getUsername().equalsIgnoreCase(username) && manager.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        for (Client client : clientList) {
            if (client.getUsername().equalsIgnoreCase(username) && client.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Button to add new client to database. Shows confirmation message then closes if successful.
     */
    @FXML
    protected void onSignUpButtonClick(ActionEvent pEvent) {
        SingletonLists lists = SingletonLists.getInstance();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String email = emailTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String paymentInfo = paymentInfoTextField.getText();

        if (ifExists(username, email)){
            ExceptionAlert.alertIllegalArgumentException("Username already exists or email is already in use.");
        } else if(username.isEmpty() || password.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || paymentInfo.isEmpty()) {
            ExceptionAlert.alertIllegalArgumentException("Please fill out all fields.");
        } else {
            clientList.addClient(new Client(username, password, firstName, lastName, email, phoneNumber, LocalDate.now(), 0, paymentInfo, false));

            lists.setClientList(clientList);

            ExceptionAlert.alertConfirmation("Welcome " + usernameTextField.getText() + "!");

            Stage stage = (Stage) ((Node) pEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    /**
     * Button to close the window
     */
    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}