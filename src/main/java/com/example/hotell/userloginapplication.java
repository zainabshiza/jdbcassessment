package com.example.hotell;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class userloginapplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(userloginapplication.class.getResource("userslogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("user login!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}
