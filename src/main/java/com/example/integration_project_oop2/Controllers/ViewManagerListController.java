package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Client;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewManagerListController {
    @FXML
    private TableView<Client> ticketTableView;
    @FXML
    private Button backButton;

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

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
        TableColumn<Client, String> clientHistoryColumn = new TableColumn<>("Purchase History");
        clientHistoryColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Double.toString(cellData.getValue().getPurchaseHistory())));

        ticketTableView.getColumns().add(clientUsernameColumn);
        ticketTableView.getColumns().add(clientFirstNameColumn);
        ticketTableView.getColumns().add(clientLastNameColumn);
        ticketTableView.getColumns().add(clientEmailColumn);
        ticketTableView.getColumns().add(clientHistoryColumn);

        List<Client> displayClients = new ArrayList<>();

        for (Client client : lists.getClientList()) {
            displayClients.add(client);
        }

        ticketTableView.getItems().addAll(displayClients);
    }
}
