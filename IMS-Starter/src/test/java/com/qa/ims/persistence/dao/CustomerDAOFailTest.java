package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class CustomerDAOFailTest {
	
private final CustomerDAO DAO = new CustomerDAO();
	
	
	@BeforeClass
	public static void initsetup() {
		System.out.println("Before Class");
	}
	@Before
	public void setup() {
		DBUtils.connect("Fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		System.out.println("Before every test!");
	}
//--- PAWEL TEACHING ME EXTRA TEST, COULDN'T DISCONNECT FROM DATABASE ELSE WOULD WORK ---
//	@Test
//	public void testCreate() {
//		final Customer created = new Customer(2L, "jordan", "harrison", "64 Zoo Lane");
//		assertNull(DAO.create(created));
//	}

//	@Test
//	public void testReadAll() {
//		List<Customer> expected = new ArrayList<>();
//		expected.add(new Customer(1L, "jordan", "harrison", "64 Zoo Lane"));
//		assertEquals(expected, DAO.readAll());
//		
//	}
//
//	@Test
//	public void testReadLatest() {
//		assertEquals(new Customer(1L, "jordan", "harrison", "64 Zoo Lane"), DAO.readLatest());
//		
//	}
//
//	@Test
//	public void testRead() {
//		final Long ID = 1L;
//		assertEquals(new Customer(ID, "jordan", "harrison", "64 Zoo Lane"), DAO.read(ID));
//	}
//
//	@Test
//	public void testUpdate() {
//		final Customer updated = new Customer(1L, "chris", "perrins", "64 Zoo Lane");
//		assertEquals(updated, DAO.update(updated));
//
//	}
//
//	@Test
//	public void testDelete() {
//		assertEquals(1, DAO.delete(1L));
//}
	@After
	public void after() {
		System.out.println("Finished!");
	}
	
}



