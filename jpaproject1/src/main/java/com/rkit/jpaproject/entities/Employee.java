package com.rkit.jpaproject.entities;

import java.util.List;

import javax.persistence.*;

import com.rkit.jpaproject.service.EmployeeService;

@Entity
public class Employee {
    
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Employee_name", nullable = false )
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    @Column(name = "Employee_email", nullable = false )
    private String emailID;

    public Employee() {

    }

}

