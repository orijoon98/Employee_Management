package com.fleta.employee.controller;

import com.fleta.employee.model.dto.Employee;
import com.fleta.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("api/employee/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
