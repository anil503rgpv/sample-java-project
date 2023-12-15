package com.example.testing.contoller;

import com.example.testing.model.Emp;
import com.example.testing.model.EmpResponse;
import com.example.testing.service.TestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Hello", description = "testing emp")
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

    @PostMapping("createemp")
    public ResponseEntity<EmpResponse> createEmp(@RequestBody Emp emp){
        emplist.add(emp);
        EmpResponse empResponse = new EmpResponse(emp, "success");
        return new  ResponseEntity<>(empResponse,HttpStatus.CREATED);
    }

    @GetMapping("/getemp")
    public ResponseEntity<List<Emp>> getEmp(){
        return new ResponseEntity<>(emplist, HttpStatus.OK);
    }

    private static List<Emp> emplist = new ArrayList<>();
}
