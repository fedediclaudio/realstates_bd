package com.dbd.realstate.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Owner {

    private String fullname;

    private String number;

    private String email;

    private String nationality;

    private String address;

    private List<Property> properties;

    public Owner() { }

    public Owner(String fullname, String number, String email, String nationality, String address) {
        this.fullname = fullname;
        this.number = number;
        this.email = email;
        this.nationality = nationality;
        this.address = address;
        this.properties = new ArrayList<Property>();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
