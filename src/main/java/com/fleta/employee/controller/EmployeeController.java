package com.fleta.employee.controller;

import com.fleta.employee.model.dto.Employee;
import com.fleta.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Map<String, String> map) {
        employeeService.createEmployee(map);
        return map.get("사번") + " " + map.get("이름") + " - 등록 성공";
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employee.get사번() + " " + employee.get이름() + " - 업데이트 성공";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestBody Map<String, String> map) {
        employeeService.deleteEmployee(map.get("사번"), map.get("이름"));
        return map.get("사번") + " " + map.get("이름") + " - 삭제 성공";
    }
}
