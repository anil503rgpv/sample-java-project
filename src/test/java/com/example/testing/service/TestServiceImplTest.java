package com.example.testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {
    @InjectMocks
    TestServiceImpl testService;

    @Test
    void serviceResponse() {
        String str = testService.serviceResponse();
        assertEquals( "Test Response Success",str);
    }
}