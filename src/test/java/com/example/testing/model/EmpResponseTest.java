package com.example.testing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpResponseTest {

    @Test
    public void testConstructorAndGetters() {
        Emp emp = new Emp("John Doe", 1, "Hello");
        String status = "Success";

        EmpResponse empResponse = new EmpResponse(emp, status);

        Assertions.assertEquals(emp, empResponse.getEmp());
        Assertions.assertEquals(status, empResponse.getStatus());
    }

    @Test
    public void testSetters() {
        Emp emp = new Emp("John Doe", 1, "Hello");
        String status = "Success";

        EmpResponse empResponse = new EmpResponse(emp, status);

        Emp newEmp = new Emp("Jane Smith", 2, "Hi");
        String newStatus = "Failure";

        empResponse.setEmp(newEmp);
        empResponse.setStatus(newStatus);

        Assertions.assertEquals(newEmp, empResponse.getEmp());
        Assertions.assertEquals(newStatus, empResponse.getStatus());
    }
}