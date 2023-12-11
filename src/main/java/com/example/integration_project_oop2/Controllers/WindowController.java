package com.example.integration_project_oop2.Controllers;

import com.example.integration_project_oop2.MovieTheaterApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This abstract class is used by other classes when opening a new window. Expects an event, the window's associated
 * FXML and the window title.
 */
abstract class WindowController {
    protected static void newWindow(ActionEvent pEvent, String windowName, String windowTitle){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MovieTheaterApplication.class.getResource(windowName));
            Parent view = fxmlLoader.load();
            Scene nextScene = new Scene(view);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle(windowTitle);
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
