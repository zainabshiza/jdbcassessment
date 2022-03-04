package com.example.hotell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class registrationapplicaion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(registrationapplicaion.class.getResource("usersregister.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("user registration!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        }
    }

