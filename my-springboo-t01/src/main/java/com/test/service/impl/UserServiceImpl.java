package com.test.service.impl;

import com.test.mappers.UserMapper;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public UserMapper userMapper;

    @Override
    public List<User> selectJoin() {
        List<User> list = userMapper.selectJoin();
        return list;
    }
}
