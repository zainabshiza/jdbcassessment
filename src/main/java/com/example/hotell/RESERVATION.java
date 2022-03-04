package com.example.hotell;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class RESERVATION {

    @FXML
    public ChoiceBox mhotels;
    @FXML
    public TextField rhaddress;

    @FXML
    public TextField rooms;

    @FXML
    public TextField stars;
    @FXML
    public TextField gname;
    @FXML
    public TextField gaddress;
    @FXML
    public TextField gphone;
    @FXML
    public TextField hnamess;
    @FXML
    public TextField hadresss;
    @FXML
    public TextField hroomss;




    ArrayList<Rooms> roomss;



    String Rooms[]= {"hotel view", "hotel 2", "hotel 3"};
    ComboBox combo_box = new ComboBox((FXCollections.observableArrayList(Rooms)));

    Label selected = new Label ("default option selected");

    EventHandler<ActionEvent>event = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            selected.setText(combo_box.getValue() + "selected");

            combo_box.setOnAction(event);
        }
    };


    public ChoiceBox getMhotels() {
        return mhotels;
    }

    public void setMhotels(ChoiceBox mhotels) {
        this.mhotels = mhotels;
    }

    public TextField getRhaddress() {
        return rhaddress;
    }

    public void setRhaddress(TextField rhaddress) {
        this.rhaddress = rhaddress;
    }

    public TextField getRooms() {
        return rooms;
    }

    public void setRooms(TextField rooms) {
        this.rooms = rooms;
    }

    public TextField getStars() {
        return stars;
    }

    public void setStars(TextField stars) {
        this.stars = stars;
    }

    public ArrayList<Rooms> getRoomss() {
        return roomss;
    }

    public void setRoomss(ArrayList<Rooms> roomss) {
        this.roomss = roomss;
    }

    public void reserve(ActionEvent actionEvent) {
        if(roomss.isEmpty()){
            System.out.println("yuh are at right place ");
        }else{
            System.out.println("no rooms");
            confirmbooking();

        }
    }

    public void confirmbooking(){

        generatereport();

    }

    private void generatereport() {

        String name,phone,address,hotelname,hoteladdress,hotelrooms;

        name=gname.getText();
        phone=gphone.getText();
        address=gaddress.getText();
        hoteladdress=hadresss.getText();
        hotelrooms=hroomss.getText();




    }


}
