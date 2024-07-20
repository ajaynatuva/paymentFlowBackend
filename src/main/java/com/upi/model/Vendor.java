package com.upi.model;

public class Vendor {
	private String name;
	private String email;
	private String upi;

	public Vendor() {
	}

	public Vendor(String name, String email, String upi) {
		this.name = name;
		this.email = email;
		this.upi = upi;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}
}