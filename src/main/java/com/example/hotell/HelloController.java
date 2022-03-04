package com.example.hotell;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {


    @FXML
    private Label welcomeText;

    @FXML
    public TextField user_name;
    @FXML
    public TextField password;



    @FXML
    public  void login() {
        if (user_name.equals("admin") && password.equals(1234)) {
            welcomeText.setText("Welcome !");

        }
        else {
            System.out.println("try again");
        }

    }
}