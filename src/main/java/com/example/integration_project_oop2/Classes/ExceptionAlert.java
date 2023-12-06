package com.example.integration_project_oop2.Classes;

import javafx.scene.control.Alert;

public class ExceptionAlert {
    public static void alertConfirmation(String pMessage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(pMessage);
        alert.showAndWait();
    }

    public static void alertIllegalArgumentException(String pMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(pMessage);
        alert.showAndWait();
    }
}
