package com.denizkpln.aop.proxy;

import com.denizkpln.aop.service.impl.CustomerServiceImpl;
import iocexamples.services.CustomerService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DatabaseTransactionInvocationHandler implements InvocationHandler {

    private final CustomerServiceImpl customerService;

    public DatabaseTransactionInvocationHandler(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
      try {
          System.out.println("DatabaseTransactionInvocationHandler begin ");
          result = method.invoke(customerService, args);
          System.out.println("DatabaseTransactionInvocationHandler commit ");
      } catch (Exception e) {
          System.out.println("DatabaseTransactionInvocationHandler rollback");
      }
      return result;
    }
}
