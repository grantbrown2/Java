package com.grantbrown.caresoftinterfaces.models;

import java.util.ArrayList;
import java.util.Date;

public class Physician implements HIPAACompliantUser {

	private int pin;
	private Integer id;
	private ArrayList<String> patientNotes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int pin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	public Physician(int id) {
		this.id = id;
		this.patientNotes = new ArrayList<String>();
	}
	
	
	public void newPatientNotes(String notes, String patientName, Date date) {
	    String report = String.format(
	        "Datetime Submitted: %s \n", date);
	    report += String.format("Reported By ID: %s\n", this.id);
	    report += String.format("Patient Name: %s\n", patientName);
	    report += String.format("Notes: %s \n", notes);
	    this.patientNotes.add(report);
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin >= 1000 && pin <= 9999) {
			this.pin = pin;
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		return id == confirmedAuthID;
	}
}