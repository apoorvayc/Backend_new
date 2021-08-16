package com.rkit.jpaproject.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.rkit.jpaproject.entities.Dashboard;
import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.Employee;
import com.rkit.jpaproject.entities.Pair;
import com.rkit.jpaproject.service.DashboardService;
import com.rkit.jpaproject.service.EmpRatingService;
import com.rkit.jpaproject.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@RestController
@AllArgsConstructor
@CrossOrigin
public class DashboardController {
    
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	DashboardService ds; 
	 
    @GetMapping("/dashboard")
    public List<Pair> getDashboardTable() {
    	return ds.getDashboardTable();
       
    }
    
    @GetMapping("/dashboard/searchEmployee/{name}")
    public List<Pair> searchEmployee(@PathVariable("name")String name) {
    	return ds.searchemployeeindashboard(name);
    	
    }
    
}