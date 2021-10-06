package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try{
            List<Employee> employeeList = new ArrayList<Employee>();
            employeeRepository.findAll().forEach(employeeList ::add);
            if(employeeList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeeList, HttpStatus.OK) ;
        } catch(Exception ex) {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try{
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee,HttpStatus.CREATED);
        }catch (Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
