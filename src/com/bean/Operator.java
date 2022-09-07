package com.bean;

import java.time.LocalDate;

public class Operator {
    int id;
    String FirstName;
    String LastName;
    String Email;
    Long Phone;
    String StartShift;
    String EndShift;
    int maxCustomersManage;
    int ActiveCustomers;
    LocalDate Creation;    
    public Operator(int id,String firstName, String lastName, String email, Long phone, String startShift, String endShift,
            int maxCustomersManage, int activeCustomers) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Phone = phone;
        StartShift = startShift;
        EndShift = endShift;
        this.maxCustomersManage = maxCustomersManage;
        ActiveCustomers = activeCustomers;
        Creation = LocalDate.now();
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
    public String getStartShift() {
        return StartShift;
    }
    public void setStartShift(String startShift) {
        StartShift = startShift;
    }
    public String getEndShift() {
        return EndShift;
    }
    public void setEndShift(String endShift) {
        EndShift = endShift;
    }
    public int getMaxCustomersManage() {
        return maxCustomersManage;
    }
    public void setMaxCustomersManage(int maxCustomersManage) {
        this.maxCustomersManage = maxCustomersManage;
    }
    public int getActiveCustomers() {
        return ActiveCustomers;
    }
    public void setActiveCustomers(int activeCustomers) {
        ActiveCustomers = activeCustomers;
    }
    public LocalDate getCreation() {
        return Creation;
    }
    public void setCreation() {
        Creation = LocalDate.now();
    }
}
