package com.fleta.employee.service;

import com.fleta.employee.model.dto.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public void createEmployee(Map<String, String> map);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(String id, String name);
}
