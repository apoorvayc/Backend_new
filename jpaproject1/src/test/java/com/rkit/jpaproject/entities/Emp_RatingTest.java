package com.rkit.jpaproject.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Emp_RatingTest {

	
	@Test
    public void testDefaultConstructor(){
        Emp_Rating er = new Emp_Rating();
        assertNotNull(er);
        
        assertEquals(er.getEmpRatingId(),0);
        assertEquals(er.getEmpId(),0);
        assertEquals(er.getRating(),0);
        assertNull(er.getDescription());
        assertNull(er.getTimestamp());
        
        
        
    }
	@Test
    public void testAllArgConstructor(){
		
		 Emp_Rating er = new Emp_Rating(2,"Sleepy#night",100,1289,"12th august");
//		 int rating, String description, int empRatingId, int empId,String timestamp)
         assertEquals(2,er.getRating());
         assertEquals(1289,er.getEmpId());
         assertEquals("Sleepy#night",er.getDescription());
         assertEquals("12th august",er.getTimestamp());
         assertEquals(100,er.getEmpRatingId());
         
        
        
    }
	 @Test
	    public void testEquals(){
		 Emp_Rating er1 = new Emp_Rating(2,"Sleepy#night",100,1289,"12th august");
		 Emp_Rating er2 = new Emp_Rating(2,"Sleepy#night",100,1289,"12th august");

	        assertTrue(er1.equals(er2));
	    }
	 @Test
	    public void testNotEquals(){
		 Emp_Rating er1 = new Emp_Rating(3,"Sleepy#night",100,1289,"12th august");
		 Emp_Rating er2 = new Emp_Rating(2,"Sleepy#night",100,1289,"12th august");

	        assertFalse(er1.equals(er2));
	    }



}
