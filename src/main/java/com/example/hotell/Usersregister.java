package com.example.hotell;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import static javafx.application.Platform.exit;

//import static com.sun.javafx.application.PlatformImpl.exit;

public class Usersregister {

   // @FXML
    //private Label welcomeText;

    @FXML
    public TextField tfname;
    @FXML
    public TextField tfaddress;
    @FXML
    public TextField tfgender;

    @FXML
    public TextField tfpassword;

    @FXML
    public TextField tfcpassword;



    public void register(ActionEvent actionEvent) {
        registerUser();
    }

    public void cancel(ActionEvent actionEvent) {
        exit();
    }




    private void registerUser(){
        String name =tfname.getText();
        String address =tfaddress.getText();
        String gender =tfgender.getText();
        String password =String.valueOf(tfpassword.getText());
        String cpassword = String.valueOf(tfcpassword.getText());

        if(name.isEmpty()||address.isEmpty()||gender.isEmpty()||password.isEmpty()||cpassword.isEmpty()){
            Exception e =new Exception("an exception");
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("fill All");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
            alert.showAndWait();
        }
        if(!password.equals(cpassword)){
            Exception e =new Exception("an exception");
            StringWriter sw = new StringWriter();
             e.printStackTrace(new PrintWriter(sw));
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setHeaderText("both should match ");
              alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
              alert.showAndWait();
        }

        user=adduserToDatabse(name,address,gender,password);
        if(user!=null){
        exit();}
        else {Exception e =new Exception("an exception");
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("cannot add ");
            alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(sw.toString())));
            alert.showAndWait();}
    }
    public User user;
    private User adduserToDatabse(String name, String address, String gender,String password){
        User user = null;
        final String DB_URL="jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users(name,address,gender,password)" + "VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,gender);
            preparedStatement.setString(4,password);

            //insert row into table

            int addedRows = preparedStatement.executeUpdate();
            if(addedRows>0){
                user = new User();
                user.name = name;
                user.address = address;
                user.gender = gender;
                user.password = password;

            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;


    }





}
