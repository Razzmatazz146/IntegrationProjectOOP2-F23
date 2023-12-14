package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller is used with the associated "managerClientList.fxml" to view client information from the manager's view.
 */
public class ViewClientListController {
    @FXML
    private TableView<Client> ticketTableView;

    /**
     * Button to close the window.
     * @param actionEvent
     */
    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Actions when window is opened. Populates the list with client information. (legal?)
     */
    @FXML
    private void initialize() {
        SingletonLists lists = SingletonLists.getInstance();

        TableColumn<Client, String> clientUsernameColumn = new TableColumn<>("Username");
        clientUsernameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getUsername()));
        TableColumn<Client, String> clientFirstNameColumn = new TableColumn<>("First Name");
        clientFirstNameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getFirstName()));
        TableColumn<Client, String> clientLastNameColumn = new TableColumn<>("Last Name");
        clientLastNameColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getLastName()));
        TableColumn<Client, String> clientEmailColumn = new TableColumn<>("E-mail");
        clientEmailColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEmail()));
        TableColumn<Client, String> clientPhoneColumn = new TableColumn<>("Phone Number");
        clientPhoneColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPhoneNumber()));
        TableColumn<Client, String> clientHistoryColumn = new TableColumn<>("Purchase History");
        clientHistoryColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Double.toString(cellData.getValue().getPurchaseHistory())));
        TableColumn<Client, String> clientSignupDateColumn = new TableColumn<>("Signup Date");
        clientSignupDateColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSignUpDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        ticketTableView.getColumns().add(clientUsernameColumn);
        ticketTableView.getColumns().add(clientFirstNameColumn);
        ticketTableView.getColumns().add(clientLastNameColumn);
        ticketTableView.getColumns().add(clientEmailColumn);
        ticketTableView.getColumns().add(clientPhoneColumn);
        ticketTableView.getColumns().add(clientHistoryColumn);
        ticketTableView.getColumns().add(clientSignupDateColumn);

        List<Client> displayClients = new ArrayList<>();

        for (Client client : lists.getClientList()) {
            displayClients.add(client);
        }

        ticketTableView.getItems().addAll(displayClients);
    }
}
