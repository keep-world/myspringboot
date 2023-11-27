package com.test.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("emp")
public class Employee implements Serializable {

    private Integer empId;

    private String empName;

    private Double empSalary;

}
