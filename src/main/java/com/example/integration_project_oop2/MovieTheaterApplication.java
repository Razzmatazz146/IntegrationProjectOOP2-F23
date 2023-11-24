package com.example.integration_project_oop2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieTheaterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader movieTheaterApplicationLoader = new FXMLLoader(getClass().getResource("user-login.fxml"));
        Scene scene = new Scene(movieTheaterApplicationLoader.load());
        stage.setTitle("Movie Theater Login");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}