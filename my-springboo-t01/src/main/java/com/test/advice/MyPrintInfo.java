package com.test.advice;


import com.test.controller.UserController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyPrintInfo {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Before("com.test.advice.config.PulbicPointCutProperties.myPrintInfoCut()")
    public void printBefor(JoinPoint joinPoint){
        String className =  joinPoint.getTarget().getClass().getSimpleName();
        String methodName =  joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info(">>>>SpringMVC.AOP Before 消息处理!{} ==> {}",className,methodName);
    }

    @After("com.test.advice.config.PulbicPointCutProperties.myPrintInfoCut()")
    public void printAfter(JoinPoint joinPoint){
        String className =  joinPoint.getTarget().getClass().getSimpleName();
        String methodName =  joinPoint.getSignature().getName();
        log.info(">>>>SpringMVC.AOP After 消息处理!{} ==> {}",className,methodName);
    }

    @AfterReturning(value = "com.test.advice.config.PulbicPointCutProperties.myPrintInfoCut()", returning = "resultObj")
    public void printAfterReturning(JoinPoint joinPoint, Object resultObj){
        String className =  joinPoint.getTarget().getClass().getSimpleName();
        String methodName =  joinPoint.getSignature().getName();
        log.info(">>>>SpringMVC.AOP AfterReturning 消息处理!{} ==> {}",className,methodName);
    }


    @AfterThrowing(value = "com.test.advice.config.PulbicPointCutProperties.myPrintInfoCut()", throwing = "throwable")
    public void printAfterThrowing(JoinPoint joinPoint, Throwable throwable){
        String className =  joinPoint.getTarget().getClass().getSimpleName();
        String methodName =  joinPoint.getSignature().getName();
        log.info(">>>>SpringMVC.AOP AfterThrowing 消息处理!{} ==> {}",className,methodName);
    }


    @Around("com.test.advice.config.PulbicPointCutProperties.myPrintInfoCut()")
    public Object printAround(ProceedingJoinPoint proceedingJoinPoint){
        String className =  proceedingJoinPoint.getTarget().getClass().getSimpleName();
        String methodName =  proceedingJoinPoint.getSignature().getName();
        Object[] args= proceedingJoinPoint.getArgs();
        Object rusult = null;
        log.info(">>>>SpringMVC.AOP around-before执行。。。。。");
        try {
             rusult =  proceedingJoinPoint.proceed(args);
            log.info(">>>>SpringMVC.AOP around-afterReturn执行。。。。。");
        } catch (Throwable throwable) {
            log.info(">>>>SpringMVC.AOP around-Exception执行。。。。。");
            throwable.printStackTrace();
        }finally {
            log.info(">>>>SpringMVC.AOP around-after执行。。。。。");
        }

        log.info(">>>>SpringMVC.AOP Around 消息处理!{} ==> {}",className,methodName);
        return rusult;
    }


}
