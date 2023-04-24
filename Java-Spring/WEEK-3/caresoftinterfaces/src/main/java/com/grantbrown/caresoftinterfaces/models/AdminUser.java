package com.grantbrown.caresoftinterfaces.models;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser implements HIPAACompliantUser, HIPAACompliantAdmin {
	private int id;
	private String role;
	private int pin;
	private ArrayList<String> securityIncidents;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
	
	public AdminUser(int id, String role) {
		this.id = id;
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}
	
	public void newIncident(String notes) {
	    String report = String.format(
	        "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	        new Date(), this.id, notes
	    );
	    securityIncidents.add(report);
	}
	
	public void authIncident() {
	    String report = String.format(
	        "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	        new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	    );
	    securityIncidents.add(report);
	}
	
	
	@Override
	public boolean assignPin(int pin) {
		if (pin < 100000) {
			return false;
		}
		this.pin = pin;
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthId) {
		if (Integer.valueOf(this.id).equals(confirmedAuthId)) {
			return true;
		} else {
			authIncident();
			return false;
		}
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
	
}