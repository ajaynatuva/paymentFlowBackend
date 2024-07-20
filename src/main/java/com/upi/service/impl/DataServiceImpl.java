package com.upi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.upi.model.Employee;
import com.upi.model.Vendor;
import com.upi.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private JavaMailSender mailSender;

	private final Map<String, Employee> employeeMap = new HashMap<>();
	private final Map<String, Vendor> vendorMap = new HashMap<>();
	private final List<String> emailHistory = new ArrayList<>();
	private static final Pattern GMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@gmail\\.com$");

	public void addEmployee(Employee employee) {
		employeeMap.put(employee.getEmail(), employee);
	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<>(employeeMap.values());
	}

	public void addVendor(Vendor vendor) {
		vendorMap.put(vendor.getEmail(), vendor);
	}

	public List<Vendor> getAllVendors() {
		return new ArrayList<>(vendorMap.values());
	}

//	public void sendEmailToVendors() {
//		for (Vendor vendor : vendorMap.values()) {
//			String message = String.format("Sending payments to vendor %s at upi %s", vendor.getName(),
//					vendor.getUpi());
//			emailHistory.add(message);
//			System.out.println("Sending email: " + message);
//		}
//	}

	public void sendEmailToVendors() {
		for (Vendor vendor : vendorMap.values()) {
			String vendorEmail = vendor.getEmail();
			if (isGmail(vendorEmail)) {
				String message = String.format("Sending payments to vendor %s at upi %s", vendor.getName(),
						vendor.getUpi());
				// Send the email
				sendEmail(vendorEmail, "Payment Notification", message);
				// Add to email history
				emailHistory.add(message);
			}
		}
	}

	private boolean isGmail(String email) {
		return GMAIL_PATTERN.matcher(email).matches();
	}

	private void sendEmail(String to, String subject, String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);

		mailSender.send(mailMessage);
		System.out.println("Email sent to: " + to);
	}

	public List<String> getEmailHistory() {
		return new ArrayList<>(emailHistory);
	}

}
