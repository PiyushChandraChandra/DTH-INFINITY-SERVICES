package com.bean;

public class Customer {
    int id;
    String FirstName;
    String LastName;
    String Email;
    Long Phone;
    String Address1;
    String Address2;
    String LandMark;
    int PIN;
    String date;
    String city;
    String State;
    String OperatorName;
    String RetailerName;
    public Customer(int id,String firstName, String lastName, String email, Long phone, String address1, String address2,
            String landMark, int PIN, String city, String state, String operatorName,
            String retailerName) {
        this.id=id;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Phone = phone;
        Address1 = address1;
        Address2 = address2;
        LandMark = landMark;
        this.PIN = PIN;
        this.date = "09/09/2022";
        this.city = city;
        State = state;
        OperatorName = operatorName;
        RetailerName = retailerName;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id=id;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public Long getPhone() {
        return Phone;
    }
    public void setPhone(Long phone) {
        Phone = phone;
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
    public String getLandMark() {
        return LandMark;
    }
    public void setLandMark(String landMark) {
        LandMark = landMark;
    }
    public int getPIN() {
        return PIN;
    }
    public void setPIN(int pIN) {
        PIN = pIN;
    }
    public String getDate() {
        return date;
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
    public String getOperatorName() {
        return OperatorName;
    }
    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }
    public String getRetailerName() {
        return RetailerName;
    }
    public void setRetailerName(String retailerName) {
        RetailerName = retailerName;
    }
    
}
