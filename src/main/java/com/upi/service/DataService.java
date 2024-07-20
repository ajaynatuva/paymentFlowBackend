package com.upi.service;

import java.util.List;

import com.upi.model.Employee;
import com.upi.model.Vendor;

public interface DataService {
	void addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void addVendor(Vendor vendor);

	List<Vendor> getAllVendors();

	void sendEmailToVendors();

	List<String> getEmailHistory();
}
