package com.example.testing.contoller;

import com.example.testing.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @GetMapping("/hello")
    ResponseEntity<String> testResponse() {
        String str = testService.serviceResponse();
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
    @GetMapping(path = "/" )
    public String hello() {
        return "Application is running";
    }
}
