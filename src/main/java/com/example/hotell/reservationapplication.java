package com.example.hotell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class reservationapplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(reservationapplication.class.getResource("RESERVATION.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("RESERVATIONSS!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();

    }
}

