package com.upi.repository;

import java.util.HashMap;
import java.util.Map;

import com.upi.model.Employee;

public class EmployeeRepository {
    private final Map<String, Employee> employeeMap = new HashMap<>();

    public void save(Employee employee) {
        employeeMap.put(employee.getEmail(), employee);
    }

    public Map<String, Employee> findAll() {
        return employeeMap;
    }
}
