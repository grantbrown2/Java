package com.grantbrown.caresoftinterfaces.models;

public class User {
    private Integer id;
    private int pin;
    
    // TO DO: Getters and setters
    // Implement a constructor that takes an ID
    public Integer getId() {
    	return id;
    }
    public int getPin() {
    	return pin;
    }
    public void setId(Integer id) {
    	this.id = id;
    }
    public void setPin(int pin) {
    	this.pin = pin;
    }
    public User(Integer id, int pin) {
    	this.id = id;
    	this.pin = pin;
    }
}
