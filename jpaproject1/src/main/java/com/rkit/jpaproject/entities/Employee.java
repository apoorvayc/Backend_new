
package com.rkit.jpaproject.entities;

import java.util.Objects;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Employee {


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Override
	public int hashCode() {
		return Objects.hash(emailID, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emailID, other.emailID) && id == other.id && Objects.equals(name, other.name);
	}

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

	public Employee(long i, String string, String string2) {
		// TODO Auto-generated constructor stub
		this.id=i;
		this.name=string;
		this.emailID=string2;
	}

	
}

