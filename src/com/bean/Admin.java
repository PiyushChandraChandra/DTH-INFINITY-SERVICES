package com.bean;

public class Admin {

	int id;
	String name;
	String Username;
	String Password;
    public Admin(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        Username = username;
        Password = password;
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
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
	
    
}
