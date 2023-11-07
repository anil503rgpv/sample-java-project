package com.example.testing.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/" )
    public String hello() {
        return "Application is running";
    }
}
