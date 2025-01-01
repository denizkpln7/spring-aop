package com.denizkpln.aop.aspect;


import com.denizkpln.aop.service.TransactionManagement;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    private final TransactionManagement transactionManagement=new TransactionManagement();


    @Pointcut("@annotation(com.denizkpln.aop.annotion.Transaction)")
    public void transactionPointcut() {}

    @Around("transactionPointcut()")
    public Object transactionAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object method = null;
        try{
            transactionManagement.begin();
            method = joinPoint.proceed();
            transactionManagement.commit();
            joinPoint.proceed();
        } catch (Exception e) {
            transactionManagement.rollback();
        }
        return method;
    }


}
