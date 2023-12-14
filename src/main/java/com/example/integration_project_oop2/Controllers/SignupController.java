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
 * This controller is used with the Signup window. Uses the User and Client classes to create a new client
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

    @FXML
    private void initialize(){
        SingletonLists lists = SingletonLists.getInstance();
        clientList = lists.getClientList();
        managerList = lists.getManagerList();
    }

    private boolean ifExists(String username, String email) {
        for (Manager manager : managerList) {
            if (manager.getUsername().equals(username) && manager.getEmail().equals(email)) {
                return true;
            }
        }
        for (Client client : clientList) {
            if (client.getUsername().equals(username) && client.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @FXML
    protected void onSignUpButtonClick(ActionEvent pEvent) {

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String email = emailTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String paymentInfo = paymentInfoTextField.getText();

        if (ifExists(username, email)){
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Username already exists or email is already in use.");
            viewAlert.showAndWait();
        } else if(username.isEmpty() || password.isEmpty() || email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || paymentInfo.isEmpty()) {
            Alert viewAlert = new Alert(Alert.AlertType.ERROR, "Please fill out all fields.");
            viewAlert.showAndWait();
        } else {
            Alert viewAlert = new Alert(Alert.AlertType.CONFIRMATION, "Welcome " + usernameTextField.getText() + "!");
            viewAlert.showAndWait();

            clientList.addClient(new Client(username, password, firstName, lastName, email, phoneNumber, LocalDate.now(), 0, paymentInfo, false));

            SingletonLists lists = SingletonLists.getInstance();

            lists.setClientList(clientList);

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