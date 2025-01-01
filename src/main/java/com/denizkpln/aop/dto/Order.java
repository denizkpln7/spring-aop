package com.denizkpln.aop.dto;

import java.util.List;
import java.util.UUID;

public record Order(UUID id, Customer customer, List<Product> product) {
}
