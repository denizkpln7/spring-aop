package com.denizkpln.aop.service;

import com.denizkpln.aop.dto.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(UUID id) throws Exception;
}
