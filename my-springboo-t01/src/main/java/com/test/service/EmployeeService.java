package com.test.service;

import com.test.mappers.EmplyeeMapper;
import com.test.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {



    public List<Employee> getAll();

    public List<Employee> selectAll();

    public List<Employee> selectMapUnderscoreAll();

    public int insertEmployee(Employee employee);


    public int insertEmployeeByParam(String empName,  Double empSalary);

    public List<Employee> selectEmployeeByResultMap(String name);

}
