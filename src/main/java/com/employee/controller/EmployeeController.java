package com.employee.controller;

import com.employee.model.Employee;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmplpyeeController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Employee> getAllEmployees() {
        return "Hello World! ";
    }
}
