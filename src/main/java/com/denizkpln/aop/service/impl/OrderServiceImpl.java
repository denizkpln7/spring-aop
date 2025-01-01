package com.denizkpln.aop.service.impl;

import com.denizkpln.aop.annotion.Transaction;
import com.denizkpln.aop.dto.Order;
import com.denizkpln.aop.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Transaction
    @Override
    public void createOrder(Order order) {

    }
}
