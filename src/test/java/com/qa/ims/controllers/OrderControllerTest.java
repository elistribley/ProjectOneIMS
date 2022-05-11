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

		final Long customerId = 1L;
		final Order created = new Order(customerId);

		when(utils.getLong()).thenReturn(customerId);
		when(orderDAO.create(created)).thenReturn(created);

		assertEquals(created, orderController.create());
		Mockito.verify(utils, Mockito.times(1)).getString();
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
		final Long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(orderDAO.delete(ID)).thenReturn(1);

		assertEquals(1L, this.orderController.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(orderDAO, Mockito.times(2)).delete(ID);
	}
	@Test
	public void testUpdate() {
		
		

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
