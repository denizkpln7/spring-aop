package com.denizkpln.aop;

import com.denizkpln.aop.dto.Customer;
import com.denizkpln.aop.dto.Order;
import com.denizkpln.aop.dto.Product;
import com.denizkpln.aop.proxy.DatabaseTransactionInvocationHandler;
import com.denizkpln.aop.service.CustomerService;
import com.denizkpln.aop.service.OrderService;
import com.denizkpln.aop.service.impl.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) throws Exception {

        //aspect
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopApplication.class);
//        CustomerService customerService = ctx.getBean(CustomerService.class);
//        customerService.getAllCustomers();
//        AdminService bean = ctx.getBean(AdminService.class);
//        bean.getConfigurations();
//        OrderService bean1 = ctx.getBean(OrderService.class);
//        bean1.createOrder(new Order(UUID.randomUUID(),new Customer(UUID.randomUUID(),"aa","aaa"), Arrays.asList(new Product(UUID.randomUUID(),"aa",24))));


        //proxy
        CustomerService customerService1 =(CustomerService) Proxy.newProxyInstance(SpringApplication.class.getClassLoader(),
                new Class[]{CustomerService.class},
                new DatabaseTransactionInvocationHandler(new CustomerServiceImpl())
        );
        customerService1.getCustomerById(UUID.randomUUID());

    }

}
