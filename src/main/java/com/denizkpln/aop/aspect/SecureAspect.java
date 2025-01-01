package com.denizkpln.aop.aspect;


import com.denizkpln.aop.RoleInitializer;
import com.denizkpln.aop.annotion.Secure;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class SecureAspect {

    @Pointcut("@annotation(com.denizkpln.aop.annotion.Secure)")
    public void securePointcut() {

    }

    @Before("securePointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before Method: " + joinPoint.getSignature().getName());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Secure annotation = methodSignature.getMethod().getAnnotation(Secure.class);
        if (annotation == null) {
            throw new RuntimeException("Secure annotation not found");
        }
        String[] roles = annotation.roles();

        boolean hasRole = false;

        for (String role : roles) {
            if (RoleInitializer.hasRole(role)) {
                hasRole = true;
            }
        }
        if (!hasRole) {
            throw new RuntimeException("Role does not exist");
        }
        System.out.println("Before Method: " + joinPoint.getSignature().getName());

    }
}
