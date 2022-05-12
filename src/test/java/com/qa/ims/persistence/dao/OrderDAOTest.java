package com.qa.ims.persistence.dao;

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
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;


public class OrderDAOTest {
	
	
	
	
	private Item item1 = new Item(1L, "Book", 8.99);
	private Item item2 = new Item(2L, "PS5 Controller", 45.99);

	private final OrderDAO orderDAO = new OrderDAO();


	@BeforeClass
	public static void init() {
		DBUtils.connect("root");
		System.out.println("Before class!");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		System.out.println("Before method!");
	}

	@Test
	public void createTest() {
		final Order created = new Order(2L, 1L);
		assertEquals(created, orderDAO.create(created));
	}

	@Test
	public void readLatestTest() {
		List<Item> items = new ArrayList<>();
		final Order expected = new Order(1L, 1L);
		items.add(item1);
		assertEquals(expected, orderDAO.readLatest());
	}

	@Test
	public void readTest() {
		
		
		final Long orderId = 1L;
		
		final Order order = new Order(1L, 1L);
		assertEquals(order, orderDAO.read(orderId));
	}

	@Test
	public void testUpdate() {
		Order updated = new Order(1L);
		assertEquals(null, orderDAO.update(updated));

	} 
	
	@Test
	public void deleteTest() {
		final Order created = new Order(2L, 1L);
		orderDAO.create(created);
		assertEquals(0, orderDAO.delete(2L));
	}

	@Test
	public void deleteOrderTest() {
		final Long orderId = 1L;
		assertEquals(0L, orderDAO.delete(orderId));
		System.out.println(orderId);
	}

	@Test
	public void deleteLineTest() {
		final Long orderId = 1L;
		final Long itemId = 1L;
		assertEquals(0, orderDAO.deleteOrderLines(orderId));
	
	}
	
	@Test
	public void deleteOrderItemsTest() {
		final Long orderId = 1L;
		final Long itemId = 1L;
		assertEquals(null, orderDAO.deleteOrderItems(orderId, itemId));	
	}
//	

	
	@Test 
	public void addItemTest() {
		final OrderItem orderItem = new OrderItem(1L, 1L, 1L);
		assertEquals(orderItem, orderDAO.addItem(orderItem));
	}
	
	@Test
	public void readAllTest() {
		List<Item> items = new ArrayList<>();
		
		List<Order> expected = new ArrayList<>();
		final Order order1 = new Order(1L, 1L);	
		items.add(item1);	
		expected.add(order1);
		assertEquals(expected, orderDAO.readAll());
		System.out.println(expected);
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