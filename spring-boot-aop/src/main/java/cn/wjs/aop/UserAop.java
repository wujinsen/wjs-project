package cn.wjs.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class UserAop {

    //@Pointcut("execution(* cn.wjs.service.UserService.insertUser(..))"|| cn.wjs.service.UserService.updateUser(..))")
    @Pointcut("execution(* cn.wjs.service.UserService..*(..))")
    public void pointCut() {

    }
    @Before("pointCut()")
    public void beforeAdvice() {
        System.out.println("beforeAdvice");
    }

    @After("pointCut()")
    public void afterAdvice(JoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();

        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        System.out.println("param: " + param);
        System.out.println("args: " + joinPoint.getArgs());
        System.out.println("target: "+joinPoint.getTarget());
        System.out.println("name: "+ joinPoint.getSignature().getName());
        System.out.println("afterAdvice");
    }

    @AfterReturning(returning = "ret", pointcut = "pointCut()")
    public void afterAdvice(JoinPoint joinPoint, Object ret) {
        System.out.println("afterAdvice");
    }

    //环绕通知。注意要有ProceedingJoinPoint参数传入
    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("注解类型环绕通知..环绕前");
        pjp.proceed();//执行方法
        System.out.println("注解类型环绕通知..环绕后");
    }


}
