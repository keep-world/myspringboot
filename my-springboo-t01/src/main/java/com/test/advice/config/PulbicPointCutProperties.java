package com.test.advice.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PulbicPointCutProperties {


    @Pointcut("execution(* com.test.service.EmployeeService.*(..))")
    public void myPrintInfoCut(){}
}
