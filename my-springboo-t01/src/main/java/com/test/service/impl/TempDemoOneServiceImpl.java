package com.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mappers.TempDemoOneMapper;
import com.test.pojo.TempDemoOne;
import com.test.service.TempDemoOneService;
import org.springframework.stereotype.Service;

@Service
public class TempDemoOneServiceImpl extends ServiceImpl<TempDemoOneMapper,TempDemoOne> implements TempDemoOneService{
}
