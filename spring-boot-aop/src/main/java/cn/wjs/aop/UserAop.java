package cn.wjs.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
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
    public void afterAdvice() {
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
