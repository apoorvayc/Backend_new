package com.rkit.jpaproject.service;

import com.rkit.jpaproject.entities.Employee;
import com.rkit.jpaproject.entities.Hashtag;
import com.rkit.jpaproject.entities.Quotes;
import com.rkit.jpaproject.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@AllArgsConstructor
@Service
public class EmployeeService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
    EmployeeRepository employeeRepository;
	
    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public Set<Employee> findAll(){
        return new HashSet<>(employeeRepository.findAll());
    }

    public Employee findById(long employeeId){
        return employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee id"));
    }
    public Employee update(long employeeId, Employee employee) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employeeFromDAO = optionalEmployee.get();
            employeeFromDAO.setName(employee.getName());
            employeeFromDAO.setEmailID(employee.getEmailID());
            return employeeRepository.save(employeeFromDAO);
        } else {
            throw new IllegalArgumentException("Employee with the id does not exists");
        }
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }
    
    public Employee createemployee(Employee employee) {
		Query query = (Query) entityManager.createQuery("select id from Employee where emailID='"+employee.getEmailID()+"'"); 
		List<Long> list = (List<Long>) query.getResultList();
	    long id = 0;
		for(long h1:list) {
		   id = (long) h1; 
	    }
	    if (id != 0) {
		Employee e = new Employee();
		e.setId(id);
		e.setEmailID(employee.getEmailID());
		e.setName(employee.getName());
		return e;
		}
		System.out.println("here 2 "+query.getFirstResult());
		
			save(employee);
		 return employee; 
    }
    




}


