package com.example.testing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmpResponse {

    private Emp emp;
    private String status;
}
