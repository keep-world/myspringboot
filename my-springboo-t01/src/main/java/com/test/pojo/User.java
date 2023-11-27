package com.test.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@Alias("user")
public class User {

    private Integer userId;

    private String userName;

    private Double userSalary;

    private List<Employee> employees;
}
