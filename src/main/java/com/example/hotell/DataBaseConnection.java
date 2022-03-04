package com.example.hotell;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseConnection {
    Connection con;
    PreparedStatement pst;

    public DataBaseConnection(){
        Connect();
    }

    public void Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/hotels","root","");
            System.out.println("Succes");

        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();

        }
        catch (SQLException ex){
            ex.printStackTrace();

        }

    }
}
