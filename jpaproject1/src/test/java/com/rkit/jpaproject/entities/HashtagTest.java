package com.rkit.jpaproject.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashtagTest {

	@Test
    public void testDefaultConstructor(){
        Hashtag h = new Hashtag();
        assertNotNull(h);
        
        assertEquals(0,h.getId());
        assertEquals(0,h.getEmp_rating_id());
        assertEquals(0,h.getRating());
        assertNull(h.getHashtagname());
     
        
        
        
    }
	@Test
    public void testAllArgConstructor(){
		
		
		Hashtag h = new Hashtag(10,3,"night",1289);
        assertNotNull(h);
        assertEquals(10,h.getId());
        assertEquals(1289,h.getEmp_rating_id());
        assertEquals(3,h.getRating());
        assertEquals("night",h.getHashtagname());
         
        
        
    }
	 @Test
	    public void testEquals(){
		 Hashtag h = new Hashtag(10,3,"night",1289);
		 Hashtag h1 = new Hashtag(10,3,"night",1289);

	        assertTrue(h.equals(h1));
	    }
	 @Test
	    public void testNotEquals(){
		 Hashtag h = new Hashtag(10,3,"day",1289);
		 Hashtag h1 = new Hashtag(10,3,"night",1289);
	        assertFalse(h.equals(h1));
	    }

}
