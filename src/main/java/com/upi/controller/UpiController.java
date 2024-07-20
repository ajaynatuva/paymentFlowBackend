package com.upi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upi.model.Employee;
import com.upi.model.Vendor;
import com.upi.service.DataService;

@RestController
@RequestMapping("/api")
public class UpiController {
	@Autowired
	private DataService dataService;

	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		dataService.addEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return dataService.getAllEmployees();
	}

	@PostMapping("/vendors")
	public void addVendor(@RequestBody Vendor vendor) {
		dataService.addVendor(vendor);
	}

	@GetMapping("/vendors")
	public List<Vendor> getAllVendors() {
		return dataService.getAllVendors();
	}

	@PostMapping("/email/vendors")
	public void sendEmailToVendors() {
		dataService.sendEmailToVendors();
	}

	@GetMapping("/email/history")
	public List<String> getEmailHistory() {
		return dataService.getEmailHistory();
	}

}
