package com.example.hotell;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.TextField;

import java.sql.*;

public class Adminside {

    @FXML
    public TextField hname;
    @FXML
    public TextField haddress;

    @FXML
    public TextField hrooms;

    @FXML
    public TextField hstars;
    @FXML
    public TextField hid;



    Connection con;
    PreparedStatement pst;

    public Adminside(){
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

    public void save(ActionEvent actionEvent) {
        String name,address,rooms,stars;
        name=hname.getText();
        address=haddress.getText();
        rooms=hrooms.getText();
        stars=hstars.getText();

        try{
           pst = con.prepareStatement("INSERT INTO hotelsinfo(hotel_name,hotel_address,total_rooms,stars)" + "VALUES(?,?,?,?)");


            pst.setString(1,name);
            pst.setString(2,address);
            pst.setString(3,rooms);
            pst.setString(4,stars);

        }catch(Exception e1){
            e1.printStackTrace();
        }

    }

    public void update(ActionEvent actionEvent) {
        String name,address,rooms,stars,id;
        name=hname.getText();
        address=haddress.getText();
        rooms=hrooms.getText();
        stars=hstars.getText();
        id=hid.getText();

        try{
            pst = con.prepareStatement("update hotelsinfo set hotel_name = ?,hotel_address= ?,total_rooms= ?,stars= ?");


            pst.setString(1,name);
            pst.setString(2,address);
            pst.setString(3,rooms);
            pst.setString(4,stars);

            pst.executeUpdate();

        }catch(Exception e1){
            e1.printStackTrace();
        }


    }

    public void search(ActionEvent actionEvent) {
        try{
            String pid = hid.getText();
            pst = con.prepareStatement("select hname,haddress,hrooms,stars from hotelsinfo where hid=?");
            pst.setString(1,pid);
            ResultSet rs = pst.executeQuery();

            if(rs.next()==true){
                String name = rs.getString(1);
                String address = rs.getString(2);
                String rooms = rs.getString(3);
                String stars = rs.getString(4);

                hname.setText(name);
                haddress.setText(address);
                hrooms.setText(rooms);
                hstars.setText(stars);
            }else{
                hname.setText("");
                haddress.setText("");
                hrooms.setText("");
                hstars.setText("");
                System.out.println("invalid hotel");
            }

        }catch (SQLException ex){ex.printStackTrace();}
    }

    public void delete(ActionEvent actionEvent) {
        String bid;
        bid = hid.getText();

        try{
            pst = con.prepareStatement("delete from hotelsinfo where hid = ?");
            pst.setString(1,bid);

            pst.executeUpdate();
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
}
