package com.dbd.realstate.model;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private String title;

    private String typeOfPublication; //Si se trata de alquiler, venta, etc.

    private String completeAddress;

    private String postalCode;

    private String type;

    private String state;

    private int m2;

    private float price;

    private String coin;

    private String description;

    private Owner owner;

    private List<RealState> realStateList;

    public Property() {}

    public Property(String title, String typeOfPublication, String completeAddress, String postalCode, String type, String state, int m2, float price, String coin, String description, Owner owner) {
        this.title = title;
        this.typeOfPublication = typeOfPublication;
        this.completeAddress = completeAddress;
        this.postalCode = postalCode;
        this.type = type;
        this.state = state;
        this.m2 = m2;
        this.price = price;
        this.coin = coin;
        this.description = description;
        this.owner = owner;
        this.realStateList = new ArrayList<RealState>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeOfPublication() {
        return typeOfPublication;
    }

    public void setTypeOfPublication(String typeOfPublication) {
        this.typeOfPublication = typeOfPublication;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<RealState> getRealStateList() {
        return realStateList;
    }

    public void setRealStateList(List<RealState> realStateList) {
        this.realStateList = realStateList;
    }


}
