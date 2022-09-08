package com.bean;

import java.time.LocalDate;

public class Retailer {

    int id;
    String name;
    String Email;
    Long Phone1;
    Long Phone2;
    String Address1;
    String Address2;
    int PIN;
    String city;
    String State;
    int SetTopBoxLimit;
    int creditLimit;
    int InventoryCost;
    int ServicesCharge;
    int percentGoodsSale;
    String Creation;

    public Retailer(int id, String name, String email, Long phone1, Long phone2, String address1, String address2, int pIN,
            String city, String state, int setTopBoxLimit, int creditLimit, int inventoryCost, int servicesCharge,
            int percentGoodsSale) {
        this.name = name;
        Email = email;
        Phone1 = phone1;
        Phone2 = phone2;
        Address1 = address1;
        Address2 = address2;
        PIN = pIN;
        this.city = city;
        State = state;
        SetTopBoxLimit = setTopBoxLimit;
        this.creditLimit = creditLimit;
        InventoryCost = inventoryCost;
        ServicesCharge = servicesCharge;
        this.percentGoodsSale = percentGoodsSale;
        Creation = "09/09/2022";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getPhone1() {
        return Phone1;
    }

    public void setPhone1(Long phone1) {
        Phone1 = phone1;
    }

    public Long getPhone2() {
        return Phone2;
    }

    public void setPhone2(Long phone2) {
        Phone2 = phone2;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int pIN) {
        PIN = pIN;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getSetTopBoxLimit() {
        return SetTopBoxLimit;
    }

    public void setSetTopBoxLimit(int setTopBoxLimit) {
        SetTopBoxLimit = setTopBoxLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getInventoryCost() {
        return InventoryCost;
    }

    public void setInventoryCost(int inventoryCost) {
        InventoryCost = inventoryCost;
    }

    public int getServicesCharge() {
        return ServicesCharge;
    }

    public void setServicesCharge(int servicesCharge) {
        ServicesCharge = servicesCharge;
    }

    public int getPercentGoodsSale() {
        return percentGoodsSale;
    }

    public void setPercentGoodsSale(int percentGoodsSale) {
        this.percentGoodsSale = percentGoodsSale;
    }

    public String getCreation() {
        return Creation;
    }
}
