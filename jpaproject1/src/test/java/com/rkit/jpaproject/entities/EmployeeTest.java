package com.rkit.jpaproject.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.aspectj.lang.annotation.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


class EmployeeTest {



	@Test
    public void testDefaultConstructor(){
        Employee emp = new Employee();
        assertNotNull(emp);
        
        assertNull(emp.getEmailID());
        assertEquals(emp.getId(),0);
        assertNull(emp.getName());
        
    }
	@Test
    public void testAllArgConstructor(){
         Employee emp = new  Employee(100,"faizan","faizan@gmail.com");
         assertEquals(100,emp.getId());
         assertEquals("faizan",emp.getName());
         assertEquals("faizan@gmail.com",emp.getEmailID());
        
    }
	 @Test
	    public void testEquals(){
	        Employee emp1 = new  Employee(100,"faizan","faizan@gmail.com");
	        Employee emp2 = new  Employee(100,"faizan","faizan@gmail.com");

	        assertTrue(emp1.equals(emp2));
	    }
	 @Test
	    public void testNotEquals(){
		 Employee emp1 = new  Employee(100,"faizan","faizan@gmail.com");
	        Employee emp2 = new  Employee(100,"ahad","faizan@gmail.com");

	        assertFalse(emp1.equals(emp2));
	    }






}
