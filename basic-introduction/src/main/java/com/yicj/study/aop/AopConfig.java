package com.yicj.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Slf4j
@Configuration
@Aspect
public class AopConfig {
    //@within(org.springframework.stereotype.Controller)：类型申明了@Controller的所有方法
    //@target(org.springframework.transaction.annotation.Transactional)：所有用@Transactional注解的方法
    //----------------------------------------------------------------------------------------------
    //target(com.xyz.service.CommonService)：所有实现了CommonService接口的类的方法
    //----------------------------------------------------------------------------------------------
    //execution(public com.xyz.service.* set*(..))：所有以set开头的public方法，且位于com.xyz.service包下
    //execution(public * *(..))：所有public方法，后面星号代表类路径和方法名
    //@Around("execution(public * *(..))")
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(ProceedingJoinPoint pjo) throws Throwable{
        Object[] args = pjo.getArgs();
        log.info("args : {}", Arrays.asList(args));
        // 调用原有方法
        Object o = pjo.proceed();
        log.info("return : {}", o);
        return o ;
    }
}
