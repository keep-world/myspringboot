package com.test.service.impl;

import com.test.mappers.EmplyeeMapper;
import com.test.pojo.Employee;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public EmplyeeMapper emplyeeMapper;


    @Override
    public List<Employee> getAll() {
        String sql = "select * from t_emp";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> list = emplyeeMapper.selectAll();
        return list;
    }

    @Override
    public List<Employee> selectMapUnderscoreAll() {
        return emplyeeMapper.selectMapUnderscoreAll();
    }

    @Override
    public int insertEmployee(Employee employee) {
        int row = emplyeeMapper.insertEmployee(employee);
//        int i = 1/0;
        return row;
    }


    @Override
    public int insertEmployeeByParam(String empName, Double empSalary) {
        return emplyeeMapper.insertEmployeeByParam(empName, empSalary);
    }

    @Override
    public List<Employee> selectEmployeeByResultMap(String name) {
        return emplyeeMapper.selectEmployeeByResultMap(name);
    }

}
