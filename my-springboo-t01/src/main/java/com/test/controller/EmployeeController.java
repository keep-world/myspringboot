package com.test.controller;

import com.test.pojo.Employee;
import com.test.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping(path = "/getAll")
    public List<Employee> getAll(){
        List<Employee> list = employeeService.getAll();
        log.info("查询完毕共有{}条数据", list.size());
        return list;
    }


    @GetMapping(path = "/selectAll")
    public List<Employee> selectAll(){
        List<Employee> list = employeeService.selectAll();

        log.info("查询完毕共有{}条数据", list.size());
        return list;
    }

    @GetMapping(path = "/selectMapUnderscoreAll")
    public List<Employee> selectMapUnderscoreAll(){
        return employeeService.selectMapUnderscoreAll();
    }

    @GetMapping(path = "/insertEmployee")
    public String insertEmployee(){
        Employee employee = new Employee();
        employee.setEmpName("测试4");
        employee.setEmpSalary(444.00);
        int row =  employeeService.insertEmployee(employee);

        log.info("插入成功{}条数据 {}", row, employee.toString());
        return employee.toString();
    }

    @RequestMapping(path = "/insertEmployeePath/{name}/{salary}")
    public String insertEmployeePath(@PathVariable("name") String myname,
                                     @PathVariable("salary") Double mysalary){
        Employee employee = new Employee();
        employee.setEmpName(myname);
        employee.setEmpSalary(mysalary);
        int row =  employeeService.insertEmployee(employee);
        log.info("插入成功{}条数据 {}", row, employee.toString());
        return employee.toString();
    }

    @RequestMapping(path = "/insertEmployeeByRequestBody", method = RequestMethod.POST)
    public String insertEmployeeByRequestBody(@RequestBody Employee employee){
        int row =  employeeService.insertEmployee(employee);
        log.info("插入成功{}条数据 {}", row, employee.toString());
        return employee.toString();
    }

    @PostMapping(path = "/insertEmployeeByRequestBodyRespObj")
    public Employee insertEmployeeByRequestBodyRespObj(@RequestBody Employee employee){
        int row =  employeeService.insertEmployee(employee);
        log.info("插入成功{}条数据 {}", row, employee.toString());
        return employee;
    }


    @GetMapping(path = "/insertEmployeeByParam")
    public String insertEmployeeByParam(){
        int row =  employeeService.insertEmployeeByParam("测试2",333.00);
        log.info("插入成功{}条数据", row);
        return  "插入成功 "  +row+ " 条数据!";
    }

    @RequestMapping("/insertEmployeeByParamPath/{name}/{salary}")
    public String insertEmployeeByParamPath(@PathVariable("name") String myname,
                                            @PathVariable("salary") Double mysalary){
        int row =  employeeService.insertEmployeeByParam(myname,mysalary);
        log.info("插入成功{}条数据", row);
        return  "插入成功 "  +row+ " 条数据!";
    }


    @GetMapping(path = "/selectEmployeeByResultMap")
    public List<Employee>  selectEmployeeByResultMap(){
        List<Employee> list=  employeeService.selectEmployeeByResultMap("大毛");
        log.info("查询完毕共有{}条数据", list.size());
        return  list;
    }


}
