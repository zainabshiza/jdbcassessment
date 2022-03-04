package com.example.hotell;

public class User {
    public String name;
    public String address;
    public String gender;
    public String password;
    public String cpassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
