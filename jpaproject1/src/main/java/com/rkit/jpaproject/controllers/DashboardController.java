package com.rkit.jpaproject.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.rkit.jpaproject.entities.Dashboard;
import com.rkit.jpaproject.entities.Emp_Rating;
import com.rkit.jpaproject.entities.Employee;
import com.rkit.jpaproject.entities.Pair;
import com.rkit.jpaproject.service.EmpRatingService;
import com.rkit.jpaproject.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
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
    EmpRatingService empRatingService;

	@PersistenceContext
	private EntityManager entityManager;
	
    @GetMapping("/dashboard")
    public List<Pair> getDashboardTable() {


        Query query = (Query) entityManager.createQuery("select e.emailID,e.name,avg(r.rating) from Emp_Rating r  join Employee e on r.empId = e.id group by e.id");
        List<Object> list = (List<Object>) query.getResultList();
       System.out.println(list);
        List<Pair> records = new ArrayList<Pair>();
        for (Object h1 : list) {
            Object[] fields = (Object[]) h1;
            String email = (String) fields[0];
            String name = (String) fields[1];
            double avgrating = (double) fields[2];


            Pair r = new Pair(email, avgrating, name);
            records.add(r);
        }
        return records;
    }
    
    @GetMapping("/dashboard/searchEmployee/{name}")
    public List<Pair> searchEmployee(@PathVariable("name")String name) {
    	Query query = (Query) entityManager.createQuery("select e.emailID,e.name,avg(r.rating) from Emp_Rating r join Employee e on r.empId = e.id group by e.id having e.name='"+name+"'");
        List<Object> list = (List<Object>) query.getResultList();
        List<Pair> records = new ArrayList<Pair>();
        for (Object h1 : list) {
            Object[] fields = (Object[]) h1;
            String email = (String) fields[0];
            String name1 = (String) fields[1];
            double avgrating = (double) fields[2];


            Pair r = new Pair(email, avgrating, name1);
            records.add(r);
        }
        return records;
    	
    }
    
}









