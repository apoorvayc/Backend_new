package com.rkit.jpaproject.controllers;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.rkit.jpaproject.entities.Employee;
import com.rkit.jpaproject.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@RestController
@CrossOrigin
@AllArgsConstructor
public class EmployeeController {
	
	@Autowired
    EmployeeService employeeService;
    
	@PersistenceContext
	private EntityManager entityManager;
	
	//return employee details
	@PostMapping("/createemployee")
    public Employee saveEmployee(@RequestBody Employee employee){
		return employeeService.createemployee(employee); 
    }

    @GetMapping("/getemployees")
    public Set<Employee> fetchAll(){
        return employeeService.findAll();
    }

    @GetMapping("/getemployee/{id}")
    public Employee findById(@PathVariable("id") long employeeId){
        return employeeService.findById(employeeId);
    }
    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployeeById(@PathVariable("id") long employeeId, @RequestBody Employee employee){
        return employeeService.update(employeeId,employee);
    }
    @GetMapping("/getemployee/name/{name}")
    public List<Employee> fetchByName(@PathVariable("name") String name){
        return employeeService.findByName(name);
    }
    


}