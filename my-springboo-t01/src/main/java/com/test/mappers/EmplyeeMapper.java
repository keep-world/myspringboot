package com.test.mappers;

import com.test.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmplyeeMapper {

    public List<Employee> selectAll();

    public List<Employee> selectMapUnderscoreAll();

    public int insertEmployee(@Param("myEmp") Employee employee);


    public int insertEmployeeByParam(@Param("col1") String empName, @Param("col2")  Double empSalary);

    public List<Employee> selectEmployeeByResultMap(@Param("name") String name);
}
