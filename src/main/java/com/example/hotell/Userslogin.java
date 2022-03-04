package com.example.hotell;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.sql.*;

import static javafx.application.Platform.exit;

public class Userslogin {

    @FXML
    public TextField tflname;
    @FXML
    public TextField tfpassword;
   //public User user;
    
    public void loginn(ActionEvent actionEvent) {
        
        
        String name = tflname.getText();
        String password = String.valueOf(tfpassword.getText());
        
        user = getAuthenticatedUser(name,password);
        if(user!=null){
            exit();
        }else{
            System.out.println("invalid");
        }
    }

    public void cancel(ActionEvent actionEvent) {
        
        exit();
    }
    public User user;
    private  User getAuthenticatedUser(String name,String password){
        User user = null;
        final String DB_URL="jdbc:mysql://localhost/MyStore?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM  users WHERE(name=?,password=?" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(4,password);

            ResultSet resultset = preparedStatement.executeQuery();

            if(resultset.next()){
                user = new User();
                user.name = resultset.getString("name");
                user.address = resultset.getString("address");
                user.gender = resultset.getString("gender");
                user.password = resultset.getString("password");
                
            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;


    }
}
