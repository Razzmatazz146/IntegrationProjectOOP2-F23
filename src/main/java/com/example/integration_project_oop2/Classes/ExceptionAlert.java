package com.example.integration_project_oop2.Classes;

import javafx.scene.control.Alert;

/**
 * Methods to show messages for different errors. Uses a message as a parameter to show in the alert.
 */
public class ExceptionAlert {
    /**
     * Alert for confirmation messages.
     * @param pMessage Message to show in the alert
     */
    public static void alertConfirmation(String pMessage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(pMessage);
        alert.showAndWait();
    }

    /**
     * Alert for Illegal Argument Exceptions.
     * @param pMessage Message to show in the alert.
     */
    public static void alertIllegalArgumentException(String pMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(pMessage);
        alert.showAndWait();
    }
}
