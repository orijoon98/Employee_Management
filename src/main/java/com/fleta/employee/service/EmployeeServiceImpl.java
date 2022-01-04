package com.fleta.employee.service;

import com.fleta.employee.model.dao.*;
import com.fleta.employee.model.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final AuthMapper authMapper;
    private final RoleMapper roleMapper;
    private final EmployeeMapper employeeMapper;
    private final BankMapper bankMapper;
    private final CommentMapper commentMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public void createEmployee(Map<String, String> map) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Auth auth = new Auth();
        Role role = new Role();
        Employee employee = new Employee();
        Bank bank = new Bank();
        Comment comment = new Comment();

        auth.set사번(map.get("사번"));
        auth.set비밀번호("0000");

        role.set사번(map.get("사번"));
        role.set등급("사용자");

        employee.set사번(map.get("사번"));
        employee.set이름(map.get("이름"));
        employee.set국적(map.get("국적"));
        employee.set성별(map.get("성별"));
        employee.set부서(map.get("부서"));
        employee.set직급(map.get("직급"));
        employee.set직종(map.get("직종"));
        Date 입사년월일, 생년월일;
        try{
            입사년월일 = formatter.parse(map.get("입사년월일"));
            생년월일 = formatter.parse(map.get("생년월일"));
            employee.set입사년월일(입사년월일);
            employee.set생년월일(생년월일);
        } catch (ParseException error) {}

        bank.set사번(map.get("사번"));

        comment.set사번(map.get("사번"));

        authMapper.createAuth(auth);
        roleMapper.createRole(role);
        employeeMapper.createEmployee(employee);
        bankMapper.createBank(bank);
        commentMapper.createComment(comment);

        log.info(employee.get사번() + " " + employee.get이름() + " - 등록 성공");
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.deleteEmployee(employee.get사번());
        employeeMapper.createEmployee(employee);
        log.info(employee.get사번() + " " + employee.get이름() + " - 업데이트 성공");
    }

    @Override
    public void deleteEmployee(String id, String name) {
        authMapper.deleteAuth(id);
        log.info(id + " " + name + " - 삭제 성공");
    }
}
