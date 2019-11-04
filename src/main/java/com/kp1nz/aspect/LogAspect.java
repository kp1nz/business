package com.kp1nz.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志服务切面类
 *
 * @author kp1nz
 * @create 2019-01-21 10:51
 */
@Component
@org.aspectj.lang.annotation.Aspect
public class LogAspect {
    @Pointcut("execution(* com.kp1nz.controller.portal.UserController.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointCut()")
    public void After() {
        System.out.println("After");
    }

    @AfterThrowing("pointCut()")
    public void AfterThrowing() {
        System.out.println("AfterThrowing");
    }

    @AfterReturning("pointCut()")
    public void AfterReturning() {
        System.out.println("AfterReturning");
    }
}
