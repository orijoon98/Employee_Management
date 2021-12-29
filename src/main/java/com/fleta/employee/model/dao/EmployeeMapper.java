package com.fleta.employee.model.dao;

import com.fleta.employee.model.dto.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {
    List<Employee> getAllEmployee();
}
