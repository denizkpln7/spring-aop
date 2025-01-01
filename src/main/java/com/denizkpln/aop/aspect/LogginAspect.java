package com.denizkpln.aop.aspect;

import com.denizkpln.aop.annotion.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
@Order(1)
public class LogginAspect {

//    @Before("execution(* com.denizkpln.hibernate.service.*.*(..))")
//    public void beforeAllMethods(JoinPoint joinPoint) {
//        Signature signature = joinPoint.getSignature();
//        System.out.println("Before all methods" + signature.getName());
//    }
//
//    @After("execution(* com.denizkpln.hibernate.service.*.*(..))")
//    public void afterAllMethods(JoinPoint joinPoint){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("After all methods" + signature.getName());
//    }
//
//    @AfterReturning("execution(* com.denizkpln.hibernate.service.*.*(..))")
//    public void afterReturningMethods(JoinPoint joinPoint){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("After returning methods" + signature.getName());
//    }
//
//    @AfterThrowing("execution(* com.denizkpln.hibernate.service.*.*(..))")
//    public void afterThrowingMethods(JoinPoint joinPoint){
//        Signature signature = joinPoint.getSignature();
//        System.out.println("After throwing methods" + signature.getName());
//    }



    @Pointcut("@annotation(com.denizkpln.aop.annotion.Logger)")
    public void annotationLogger() {

    }

    //    @Around("execution(* com.denizkpln.hibernate.service.*.*(..))")
    @Around("annotationLogger()")
    public Object aroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Logger annotation = method.getAnnotation(Logger.class);

        if (annotation != null) {
            if (annotation.methodExecutionTime()){
                //time ı yazdırma
            }
            if (annotation.methodParameter()){
                // parametersları yazdırma
            }
        }

        Object[] args = joinPoint.getArgs();
        System.out.println("Before Around methods" + signature.getName() + Arrays.toString(args));
        Object result = null;
        try{
            long startTime =System.currentTimeMillis();
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis()-startTime;
            System.out.println("After Around methods" + signature.getName()+ "time " +endTime);
        }catch (Exception e){
            System.out.println("After trowing Around methods" + signature.getName());
        }
        return result;
    }
}
