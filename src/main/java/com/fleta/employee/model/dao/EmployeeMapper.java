package com.fleta.employee.model.dao;

import com.fleta.employee.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {
    public List<Employee> getAllEmployee();
    public void createEmployee(Employee employee);
    public void deleteEmployee(String 사번);
}
