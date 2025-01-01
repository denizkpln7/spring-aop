package com.denizkpln.aop;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class RoleInitializer {

    private static final List<String> roles = Arrays.asList("USER", "ANALYST");

    public boolean hasRole(String role) {
        return roles.contains(role);
    }
}
