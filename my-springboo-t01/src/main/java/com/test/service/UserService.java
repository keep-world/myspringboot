package com.test.service;

import com.test.mappers.EmplyeeMapper;
import com.test.mappers.UserMapper;
import com.test.pojo.Employee;
import com.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    public List<User> selectJoin();

}
