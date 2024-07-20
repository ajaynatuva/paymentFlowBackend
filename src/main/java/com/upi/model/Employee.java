package com.upi.model;

//Employee.java
public class Employee {
	private String name;
	private String designation;
	private double ctc;
	private String email;

	public Employee() {
	}

	public Employee(String name, String designation, double ctc, String email) {
		this.name = name;
		this.designation = designation;
		this.ctc = ctc;
		this.email = email;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getCtc() {
		return ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
