package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.qa.ims.utils.DBUtils;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;


public class OrderDAOTest {
	private Item item1 = new Item(1L, "Comic Book", 8.99);
	private Item item2 = new Item(2L, "PS5 Controller", 45.99);

	private final OrderDAO orderDAO = new OrderDAO();


	@BeforeClass
	public static void init() {
		DBUtils.connect("root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void createTest() {
		List<Item> items = new ArrayList<>();
		final Order created = new Order(1L, 1L, items);
		assertEquals(created, orderDAO.create(created));
	}

	@Test
	public void readLatestTest() {
		List<Item> items = new ArrayList<>();
		items.add(item1);
		final Order expected = new Order(2l, 1l, items);
		assertEquals(expected, orderDAO.readLatest());
	}

	@Test
	public void readTest() {
		List<Item> items = new ArrayList<>();
		items.add(item2);
		final Long orderId = 2L;
		final Order order = new Order(2L, 1L, items);
		assertEquals(order, orderDAO.read(orderId));
	}

	@Test
	public void deleteTest() {
		final Order created = new Order(2L, 2L);
		orderDAO.create(created);
		assertEquals(1, orderDAO.delete(1L));
	}

	@Test
	public void deleteOrderTest() {
		final Long orderId = 1L;
		assertEquals(2, orderDAO.delete(orderId));
	}

	@Test
	public void deleteLineTest() {
		final long orderId = 1L;
		final long itemId = 4L;
		assertEquals(1, orderDAO.deleteOrderItems(orderId, itemId));

	}
	
	@Test
	public void updateTest() {
		List<Item> items = new ArrayList<>();
		items.add(item2);
		final Order updated = new Order(2L, 2L, items);
		
		assertEquals(updated, orderDAO.update(updated));
	}

	
	@Test 
	public void addItemTest() {
		final OrderItem orderItem = new OrderItem(1L, 3L, 1L);
		assertEquals(orderItem, orderDAO.addItem(orderItem));
	}
	
	@Test
	public void readAllTest() {
		List<Item> items1 = new ArrayList<>();
		List<Item> items2 = new ArrayList<>();
		List<Order> expected = new ArrayList<>();
		final Order order1 = new Order(1L, 1L, items1);
		final Order order2 = new Order(2L, 1L, items2);
		items1.add(item1);
		items2.add(item2);
		expected.add(order1);
		expected.add(order2);
		assertEquals(expected, orderDAO.readAll());
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