package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private CustomerDAO customerDAO;

	@Mock
	private OrderDAO orderDAO;

	@Mock
	private ItemsDAO itemDAO;

	@InjectMocks
	private OrderController orderController;

	@Test
	public void testCreate() {
		final Long orderId = 1L;
		final Long customerId = 1L;
		final Order created = new Order(orderId, customerId);
		
		
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(utils.getLong()).thenReturn(customerId);
		
		Mockito.when(orderDAO.create(any(Order.class))).thenReturn(created);
		assertEquals(created, orderController.create());
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(orderDAO, times(1)).create(created);
		Mockito.verify(orderDAO, times(1)).create(any(Order.class));
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class!");
	}
	
	
	
	@Before
	public void before() {
		System.out.println("Before method!");
	}
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		orders.add(new Order(1L, 1L, items));

		when(orderDAO.readAll()).thenReturn(orders);

		assertEquals(orders, orderController.readAll());

		verify(orderDAO, times(1)).readAll();
	}

	@Test
	public void testDelete() {
		final Long id = 1L;

		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(orderDAO.delete(id)).thenReturn(1);
		
		assertEquals(1L, this.orderController.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderDAO, Mockito.times(2)).delete(id);
	}
	@Test
	public void testUpdate() {
		Long orderId = 1L;
		Long itemId = 1L;

		//trying to get update test completed.
		final Order updated = new Order(orderId);
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(utils.getLong()).thenReturn(itemId);
		Mockito.when(utils.getString()).thenReturn("add");
		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(this.orderDAO.addItem(1L, 1L)).thenReturn(updated);
		
		
		

		assertEquals(updated, orderController.update());
		
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(orderDAO, times(1)).addItem(1L, 1L);
		
	}
//	@Test
//	public void testAddItem() {
//		Long itemId = 1L;
//		Long orderId = 2L;
//		
//		final Order updated = new Order(orderId, itemId);
//		Mockito.when(utils.getLong()).thenReturn(orderId);
//		Mockito.when(utils.getLong()).thenReturn(itemId);
//		
//		Mockito.when(this.orderDAO.addItem(2L, 1L)).thenReturn(updated);}
////		assertEquals(updated, orderController.addItem());
////		
////		Mockito.verify(utils, Mockito.times(1)).getLong();
////		Mockito.verify(orderDAO, times(1)).addItem(orderId, itemId);
////	}
////	
	@Test
	public void deleteItemTest() {
		Long orderId = 1L;
		Long itemId = 1L;
		int item;
		Mockito.when(utils.getLong()).thenReturn(orderId);
		Mockito.when(utils.getLong()).thenReturn(itemId);
		
		assertEquals(null, this.orderController.deleteItem());
		
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(orderDAO, times(1)).deleteOrderItems(1L, 1L);
	}
	
	@After
	public void after() {
		System.out.println("After method!");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class!");
	}
	
	
}
