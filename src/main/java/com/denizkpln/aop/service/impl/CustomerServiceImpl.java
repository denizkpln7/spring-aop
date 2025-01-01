package com.denizkpln.aop.service.impl;

import com.denizkpln.aop.annotion.Logger;
import com.denizkpln.aop.dto.Customer;
import com.denizkpln.aop.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Logger
    @Override
    public List<Customer> getAllCustomers() {
        return List.of();
    }

    @Override
    public Customer getCustomerById(UUID id) throws Exception {
        return null;
    }
}
