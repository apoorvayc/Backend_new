package com.rkit.jpaproject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {


    @OneToMany(targetEntity=Emp_Rating.class,cascade=CascadeType.ALL)
    @JoinColumn(name="emp_fk" , referencedColumnName="id")
    private List<Emp_Rating> er;

    public List<Emp_Rating> getEr() {
        return er;
    }

    public void setEr(List<Emp_Rating> er) {
        this.er = er;
    }

    @Id
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

