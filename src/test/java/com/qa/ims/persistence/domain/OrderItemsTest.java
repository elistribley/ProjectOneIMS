package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderItemsTest {
	private OrderItem testOrderItems1 = new OrderItem(1L, 1L, 1L);
	private OrderItem testOrderItems2 = new OrderItem(1L, 2L, 3L);
	private OrderItem nullOrder1 = new OrderItem(null, null, null);
	private OrderItem nullOrder2 = new OrderItem(null, null, null);
	
	
	
	@Test
	public void settersTest() {
		testOrderItems1.setOrderItemsId(1L);;
		testOrderItems1.setOrderId(2L);
		testOrderItems1.setItemId(3L);		
		assertFalse(testOrderItems1.equals(testOrderItems2));
	}
	@Test
	public void testGetters() {
		long orderId = 1L;
		long itemId = 2L;
		long orderItems = 1L;
		assertTrue(testOrderItems1.getOrderId().equals(orderId));
		assertTrue(testOrderItems2.getItemId().equals(itemId));
		assertTrue(testOrderItems1.getOrderItemsId().equals(orderItems));
	}
	@Test
	public void testEquals() {
		assertFalse(testOrderItems1.equals(testOrderItems2));
		assertFalse(nullOrder1.equals(testOrderItems1));
		assertFalse(testOrderItems1.equals(null));
		assertTrue(nullOrder1.equals(nullOrder2));
		
	}
}