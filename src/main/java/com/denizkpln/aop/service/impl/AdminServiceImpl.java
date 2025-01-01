package com.denizkpln.aop.service.impl;

import com.denizkpln.aop.annotion.Secure;
import com.denizkpln.aop.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    @Secure(roles = {"ADMIN"})
    @Override
    public List<String> getConfigurations() {
        return List.of();
    }
}
