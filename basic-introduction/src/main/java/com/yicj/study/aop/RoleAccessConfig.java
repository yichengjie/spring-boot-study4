package com.yicj.study.aop;

import com.yicj.study.annnotation.Function;
import com.yicj.study.util.AppContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect
@Slf4j
public class RoleAccessConfig {

    @Around("within(@org.springframework.stereotype.Controller *) && @annotation(func)")
    public Object functionAccessCheck(final ProceedingJoinPoint joinPoint, Function func) throws Throwable{
        if (func != null){
            String funcName = func.value();
            if (!canAccess(funcName)){
                MethodSignature ms = (MethodSignature)joinPoint.getSignature() ;
                throw new RuntimeException("Can not Access " + ms.getMethod()) ;
            }
        }
        //继续处理原有调用
        Object o = joinPoint.proceed();
        return o ;
    }

    private boolean canAccess(String funName) {
        if (funName.length() == 0){
            //总是允许访问
            return true ;
        }else {
            //取出当前用户对应的所有角色，从数据库中查询是否有访问funcName的权限
            String userName = AppContext.getUserName();
            log.info("userName : " + userName);
            if ("admin".equals(userName)){
                return true ;
            }
            return false ;
        }
    }
}
