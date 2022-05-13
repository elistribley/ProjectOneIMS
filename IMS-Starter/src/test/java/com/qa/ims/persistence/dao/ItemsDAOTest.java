package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO dao = new ItemsDAO();
	
	@BeforeClass
	public static void initsetup() {
		System.out.println("Before Class");
	}
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		System.out.println("Before method!");
	}

	@Test
	public void testCreate() {
		Item created = new Item(2L, "Book", 8.99);
		assertEquals(created, dao.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Book", 8.99));
		assertEquals(expected, dao.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(1L, "Book", 8.99), dao.readLatest());
	}

	@Test
	public void testRead() {
		Long id = 1L;
		assertEquals(new Item(1L, "Book", 8.99), dao.read(id));
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "Book", 8.99);
		assertEquals(updated, dao.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, dao.delete(1L));
	}
	@Test
	public void testDeleteOrderLines() {
		assertEquals(1, dao.delete(1L));
	}
	@After
	public void after() {
		System.out.println("At the end!");
	}
	
}