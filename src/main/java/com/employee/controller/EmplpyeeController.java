package com.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmplpyeeController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public String helloWorld() {
        return "Hello World! ";
    }
}
