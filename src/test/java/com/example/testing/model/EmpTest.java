package com.example.testing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpTest {

    @Test
    public void testConstructorAndGetters() {
        String name = "John Doe";
        int id = 1;
        String msg = "Hello";

        Emp emp = new Emp(name, id, msg);

        Assertions.assertEquals(name, emp.getName());
        Assertions.assertEquals(id, emp.getId());
        Assertions.assertEquals(msg, emp.getMsg());
    }

    @Test
    public void testSetters() {
        Emp emp = new Emp("John Doe", 1, "Hello");

        String newName = "Jane Smith";
        int newId = 2;
        String newMsg = "Hi";

        emp.setName(newName);
        emp.setId(newId);
        emp.setMsg(newMsg);

        Assertions.assertEquals(newName, emp.getName());
        Assertions.assertEquals(newId, emp.getId());
        Assertions.assertEquals(newMsg, emp.getMsg());
    }
}