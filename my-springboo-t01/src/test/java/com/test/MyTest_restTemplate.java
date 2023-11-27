package com.test;

import com.test.pojo.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyTest_restTemplate {

    @Autowired
    private RestTemplate restTemplate;


    @Test
    public void Test01() {
        Employee employee = new Employee();
        employee.setEmpName("test测试1");
        employee.setEmpSalary(1111.11);
        String url = "http://localhost:8080/user/insertEmployeeByRequestBody";
        String postForObject = restTemplate.postForObject(url, employee, String.class);
        log.info(">>> 返回数据 {}", postForObject);
    }


    @Test
    public void Test02() {
        Employee employee = new Employee();
        employee.setEmpName("test测试1");
        employee.setEmpSalary(1111.11);
        String url = "http://localhost:8080/user/insertEmployeeByRequestBodyRespObj";
        Employee postForObject = restTemplate.postForObject(url, employee, Employee.class);
        log.info(">>> 返回数据 {}", postForObject.toString());

    }

    @Test
    public void Test03() {
        Employee employee = new Employee();
        employee.setEmpName("test测试1");
        employee.setEmpSalary(1111.11);
        String url = "http://localhost:8080/user/insertEmployeeByRequestBodyRespObj";
        ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(url, employee, Employee.class);
        log.info(">>> 返回数据 {} |  {}", responseEntity.getStatusCode(), responseEntity.getStatusCodeValue());
        log.info(">>> headers 返回数据 {}", responseEntity.getHeaders().toString());
        log.info(">>> bodys 返回数据 {}", responseEntity.getBody().toString());

    }

}
