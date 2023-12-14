package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.Classes.Showroom;
import com.example.integration_project_oop2.Lists.SingletonLists;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * This controller is used with the associated "managerShowroomsList.fxml" to view showrooms.
 */
public class ViewScreeningRooms {
    @FXML
    private TableView<Showroom> showroomTableView;

    /**
     * Button to close the window
     * @param actionEvent
     */
    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Populates the list when window is opened.
     */
    @FXML
    private void initialize() {
        SingletonLists lists = SingletonLists.getInstance();

        TableColumn<Showroom, String> showroomNumberColumn = new TableColumn<>("Showroom");
        showroomNumberColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoomNumber())));
        TableColumn<Showroom, String> showroomSeatsColumn = new TableColumn<>("Seats");
        showroomSeatsColumn.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoomCapacity())));

        showroomTableView.getColumns().add(showroomNumberColumn);
        showroomTableView.getColumns().add(showroomSeatsColumn);

        List<Showroom> displayShowrooms = new ArrayList<>();

        for (Showroom showroom : lists.getShowroomList()) {
            displayShowrooms.add(showroom);
        }

        showroomTableView.getItems().addAll(displayShowrooms);
    }
}
