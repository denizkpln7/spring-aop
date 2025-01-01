package com.denizkpln.aop.service.impl;

import com.denizkpln.aop.dto.Product;
import com.denizkpln.aop.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProducts() {
        return List.of();
    }
}
