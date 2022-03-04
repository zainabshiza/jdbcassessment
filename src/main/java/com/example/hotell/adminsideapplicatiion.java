package com.example.hotell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class adminsideapplicatiion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(adminsideapplicatiion.class.getResource("adminside.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("hotels details!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}