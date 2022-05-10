package com.qa.ims.persistence.domain;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;


public class OrderTest {
	
	private Order testOrder1 = new Order(1L, 1L);
	private Order testOrder2 = new Order(1L, 2L);
	private Order testOrder3 = new Order(1L, 3L);
	private Order orderNull = new Order(null, null, null);

	
	
	@Test
	public void settersTest() {
		testOrder1.setCustomerId(2l);
		testOrder1.setOrderId(2l);
		
		assertFalse(testOrder1.equals(testOrder2));
	}
	@Test
	public void gettersTest() {
		Long orderId = 1l;
		Long customerId = 1l;
		
		assertTrue(testOrder1.getOrderId().equals(orderId));
		assertTrue(testOrder1.getCustomerId().equals(customerId));
	}
	@Test
	public void testEquals() {
		assertFalse(testOrder1.equals(testOrder2));
		assertFalse(testOrder1.equals(null));
		
	}
}