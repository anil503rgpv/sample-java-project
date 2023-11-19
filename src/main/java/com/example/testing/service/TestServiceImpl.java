package com.example.testing.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    @Override
    public String serviceResponse() {
        return "Test Response Success";
    }
}
