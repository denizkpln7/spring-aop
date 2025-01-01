package com.denizkpln.aop.dto;

import java.io.Serializable;
import java.util.UUID;

public record Product(UUID id, String name, int price) implements Serializable {
}
